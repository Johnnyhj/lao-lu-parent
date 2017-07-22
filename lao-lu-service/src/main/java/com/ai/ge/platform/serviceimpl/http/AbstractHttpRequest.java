package com.ai.ge.platform.serviceimpl.http;


import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.mapper.log.LogInterfaceCallMapper;
import com.ai.ge.platform.model.log.LogInterfaceCallWithBLOBs;
import com.ai.ge.platform.model.log.LoggerStorageObject;
import com.ai.ge.platform.service.http.HttpRequest;
import com.ai.ge.platform.service.log.LoggerStorage;
import com.ai.ge.platform.service.sys.SysDataService;
import com.ai.ge.util.DateUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;


/**
 * 接口默认实现
 */
public abstract class AbstractHttpRequest implements HttpRequest, LoggerStorage {

    private static final Logger logger = LoggerFactory.getLogger(AbstractHttpRequest.class);

    protected static boolean isDebug = logger.isDebugEnabled();

//    protected static Configuration cfg;

    protected static HttpClient httpClient;

    @Resource
    private LogInterfaceCallMapper logInterfaceCallMapper;

    @Resource
    protected SysDataService sysDataService;

    @PostConstruct
    protected void initialization() {
        /*if (null == cfg) {
            cfg = new Configuration();
            cfg.setDefaultEncoding("utf-8");
            try {
                cfg.setDirectoryForTemplateLoading(new File(Thread.currentThread().getContextClassLoader()
                        .getResource("template").getPath()));
            } catch (Exception e) {
                logger.error("freemarker模板目录未找到", e);
            }
        }*/

        if (null == httpClient) {
            MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();

            HttpConnectionManagerParams params = new HttpConnectionManagerParams();

            int soTimeout = sysDataService.getIntegerByKeyType("so_timeout", SysDataService.WEB_APP, "35000");
            int timeout = sysDataService.getIntegerByKeyType("timeout", SysDataService.WEB_APP, "15000");

            params.setConnectionTimeout(timeout);
            params.setSoTimeout(soTimeout);

            httpConnectionManager.setParams(params);

            httpClient = new HttpClient(httpConnectionManager);
        }
    }

    /**
     * 执行Http请求调用
     *
     * @param method
     */
    public void executeMethod(HttpMethodBase method, HttpRequestContext httpRequestContext) throws Exception {
        try {
            if (isDebug) {
                logger.debug("开始请求Http请求时间[" + DateUtil.getStrFromDate(new Date(), DateUtil.DATE_FORMATE_STRING_A) +
                        "]，地址[" + method.getURI() + "]......");
                if (method instanceof PostMethod) {
                    NameValuePair[] parameters = ((PostMethod) method).getParameters();
                    if (ArrayUtils.isNotEmpty(parameters)) {
                        logger.debug("请求参数 ");
                        for (NameValuePair parameter : parameters) {
                            logger.debug("name = " + parameter.getName() + " , value = " + parameter.getValue());
                        }
                    }
                }

                String queryString = method.getQueryString();
                if (StringUtils.isNotBlank(queryString)) {
                    logger.debug("URL请求参数 ");
                    logger.debug(queryString);
                }
                if (method instanceof PostMethod) {
                    RequestEntity requestEntity = ((PostMethod) method).getRequestEntity();
                    if (null != requestEntity) {
                        logger.debug("请求体 ");
                        logger.debug(requestEntity.toString());
                    }
                }
            }
            httpClient.executeMethod(method);
            int statusCode = method.getStatusCode();

            LogInterfaceCallWithBLOBs logInterfaceCall = httpRequestContext.getLogInterfaceCall();
            logInterfaceCall.setHttpCode((short) statusCode);

            if (HttpStatus.SC_OK != statusCode) {
                //返回码不是200
                String message = "服务器未能成功返回，状态码是" + statusCode;

                if (isDebug) {
                    logger.debug(message);
                }
                throw new IOException(message);
            }
            executeMethodPost(method, httpRequestContext);

            if (isDebug) {
                logger.debug("成功接收Http请求数据......");
            }
        } catch (IOException e) {
            executeMethodException(method, e, httpRequestContext);
        } finally {
            method.releaseConnection();
        }
    }

    @Override
    public void saveObject(LoggerStorageObject object) {
        if (object instanceof LogInterfaceCallWithBLOBs) {
            logInterfaceCallMapper.insertSelective((LogInterfaceCallWithBLOBs) object);
        } else {
            logger.error("object is not LogInterfaceCallWithBLOBs instance!");
        }
    }

    /**
     * 成功接收Http请求后处理
     *
     * @param method
     */
    protected abstract void executeMethodPost(HttpMethodBase method, HttpRequestContext httpRequestContext) throws Exception;

    /**
     * 接收Http请求异常处理
     */
    protected abstract void executeMethodException(HttpMethodBase method, Exception ex, HttpRequestContext httpRequestContext) throws Exception;


    /**
     * 对Http响应进行解析，默认直接按响应编码直接转String
     *
     * @param method
     * @return
     * @throws IOException
     */
    @Override
    public String getResponseBodyAsString(HttpMethodBase method) throws IOException {
        String response = new String(method.getResponseBody(), method.getResponseCharSet());
        response = StringEscapeUtils.unescapeXml(response);
        return response;
    }


    /**
     * 加载模板内容
     *
     * @param tempFile
     * @param params
     * @return
     */
    @Override
    public String getTemplateText(String tempFile, Map<String, Object> params) {
        try {
//            Template template = cfg.getTemplate(tempFile);
//            template.setEncoding("utf-8");
            String templateText = sysDataService.getByKeyType(tempFile, "template");

            Template template = new Template(null, new StringReader(templateText), null, CharEncoding.UTF_8);


            StringWriter sw = new StringWriter();
            template.process(params, sw);

            String s = sw.toString();

            if (isDebug) {
                logger.debug("Http请求包数据 " + s);
            }
            return s;
        } catch (IOException e) {
            String message = "freemarker模板文件未找到错误";
            logger.error(message, e);
            throw new DataException(message);
        } catch (TemplateException e) {
            String message = "加载freemarker模板文件错误";
            logger.error(message, e);
            throw new DataException(message);
        }
    }

    @Override
    public void addParameter(HttpMethodBase method, Map<String, String> parameter) {
        if (MapUtils.isNotEmpty(parameter) && method instanceof PostMethod) {
            PostMethod postMethod = (PostMethod) method;
            for (Map.Entry<String, String> stringEntry : parameter.entrySet()) {
                postMethod.addParameter(stringEntry.getKey(), stringEntry.getValue());
            }
        }
    }

    @Override
    public void addRequestHeader(HttpMethodBase method) {
        method.getParams().setContentCharset(CharEncoding.UTF_8);
    }
}

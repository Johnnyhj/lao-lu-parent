package com.ai.ge.common.wechat;

import com.ai.ge.platform.exception.DataException;
import com.ai.ge.platform.model.wx.AccessToken;
import com.ai.ge.platform.model.wx.WxResult;
import com.ai.ge.platform.model.wx.WxUserInfo;
import com.ai.ge.platform.service.sys.SysDataService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

//import com.al.ec.platform.model.common.WechatSign;

/**
 * 微信通用接口工具类
 *
 * @author caspar.chen
 * @version 1.0
 */
public class WechatHttpRequestUtil {

    private static final Logger logger = LoggerFactory.getLogger(WechatHttpRequestUtil.class);
    private static boolean isDebug = logger.isDebugEnabled();
    protected static HttpClient httpClient;
//    protected static Configuration cfg;


    static {
        if (null == httpClient) {
            SysDataService sysDataService = /*ShowRoomContextLoaderListener.getCurrentWebApplicationContext().getBean
                    ("sysDataServiceImpl", SysDataService.class)*/null;

            MultiThreadedHttpConnectionManager httpConnectionManager = new MultiThreadedHttpConnectionManager();

            HttpConnectionManagerParams params = new HttpConnectionManagerParams();

            int soTimeout = 35000, timeout = 5000;
            if (null != sysDataService) {
                soTimeout = sysDataService.getIntegerByKeyType("so_timeout", SysDataService.WEB_APP, "35000");
                timeout = sysDataService.getIntegerByKeyType("timeout", SysDataService.WEB_APP, "5000");
            }
            params.setConnectionTimeout(timeout);
            params.setSoTimeout(soTimeout);

            httpConnectionManager.setParams(params);

            httpClient = new HttpClient(httpConnectionManager);

            Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
            httpClient.getHostConfiguration().setHost("www.whatever.com", 443, myhttps);
        }


//        if (null == cfg) {
//            cfg = new Configuration();
//            cfg.setDefaultEncoding("utf-8");
//            try {
//                cfg.setDirectoryForTemplateLoading(new File(Thread.currentThread().getContextClassLoader()
//                        .getResource("template").getPath()));
//            } catch (Exception e) {
//                logger.error("freemarker模板目录未找到", e);
//            }
//        }
    }

    /**
     * 获取微信通用接口凭证
     *
     * @param appId
     * @param secret
     * @return
     */
    public static AccessToken getAccessToken(String appId, String secret) {
        String requestUrl = getAccessTokenUrl(appId, secret);
        GetMethod getMethod = new GetMethod(requestUrl);

        String response = getHttpResponse(getMethod);

        return requestSuccess(requestUrl, response) ? JSON.parseObject(response, AccessToken.class) : null;
    }

    /**
     * 获取网页授权通用接口凭证
     * @param appId
     * @param code
     * @return
     */
    public static AccessToken getHtmlAccessToken(String appId, String secret, String code) {
        String requestUrl = getHtmlAccessTokenUrl(appId, secret, code);
        GetMethod getMethod = new GetMethod(requestUrl);

        String response = getHttpResponse(getMethod);

        return requestSuccess(requestUrl, response) ? JSON.parseObject(response, AccessToken.class) : null;
    }

    /**
     * 刷新网页授权通用接口凭证
     * @param appId
     * @param refreshToken
     * @return
     */
    public static AccessToken getHtmlRefreshToken(String appId, String refreshToken) {
        String requestUrl = getHtmlRefreshTokenUrl(appId, refreshToken);
        GetMethod getMethod = new GetMethod(requestUrl);

        String response = getHttpResponse(getMethod);
        return requestSuccess(requestUrl, response) ? JSON.parseObject(response, AccessToken.class) : null;
    }



    /**
     * 获取用户信息
     *
     * @param accessToken
     * @param openId
     * @return
     */
    public static WxUserInfo getWxUserInfo(String accessToken, String openId) {
        String requestUrl = getUserInfoUrl(accessToken, openId);
        GetMethod getMethod = new GetMethod(requestUrl);

        String response = getHttpResponse(getMethod);

        return requestSuccess(requestUrl, response) ? JSON.parseObject(response, WxUserInfo.class) : null;
    }


    /**
     * 公众号主主动发送消息
     * @param templateUrl
     * @param params
     * @return
     */
    public static WxResult wxCustomSend(String accessToken, String templateUrl, Map<String, Object> params) {
        String templateText = getTemplateText(templateUrl, params);
        String requestUrl = getCustomSendMsgUrl(accessToken);

        PostMethod postMethod = new PostMethod(requestUrl);
        try {
            postMethod.setRequestEntity(new StringRequestEntity(templateText, "text/xml", CharEncoding
                    .UTF_8));
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        String response = getHttpResponse(postMethod);

        return StringUtils.isNotBlank(response) ? JSON.parseObject(response, WxResult.class) : null;
    }


    private static String getTemplateText(String templateText, Map<String, Object> params) {
        try {

            //String templateText = sysDataService.getByKeyType(tempFile, "template");

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


    /**
     * 获取Http请求响应
     *
     * @param method
     * @return
     */
    protected static String getHttpResponse(HttpMethod method) {
        try {
            httpClient.executeMethod(method);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }

        String responseCharSet = CharEncoding.UTF_8;
        /*if (method instanceof GetMethod) {
            responseCharSet = ((GetMethod) method).getResponseCharSet();
        } else if (method instanceof PostMethod) {
            responseCharSet = ((PostMethod) method).getResponseCharSet();
        }*/

        if (200 != method.getStatusCode()) {
            logger.error("HTTP请求返回状态码不正确[" + method.getStatusCode() + "]");
            return null;
        }


        String response = null;
        try {
            response = new String(method.getResponseBody(), responseCharSet);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return response;
    }


    /**
     * 判断请求微信接口返回是否正确
     *
     * @param requestUrl
     * @param response
     * @return
     */
    private static boolean requestSuccess(String requestUrl, String response) {
        if (StringUtils.isBlank(response)) {
            return false;
        }

        JSONObject parseObject = JSON.parseObject(response);
        if (parseObject.containsKey("errcode")) {
            logger.error("请求微信接口[" + requestUrl + "]错误，" + response);
            return false;
        }

        return true;
    }


    /**
     * 获取微信通用接口凭证请求地址
     *
     * @param appId
     * @param secret
     * @return
     */
    private static String getAccessTokenUrl(String appId, String secret) {
        return MessageFormat.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={0}" +
                "&secret={1}", appId, secret);
    }

    /**
     * 获取网页授权微信通用接口凭证请求地址
     *
     * @param appId
     * @param code
     * @return
     */
    private static String getHtmlAccessTokenUrl(String appId, String secret, String code) {
        return MessageFormat.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code", appId, secret, code);
    }

    /**
     * 获取网页授权微信通用接口凭证请求地址
     *
     * @param appId
     * @param refreshToken
     * @return
     */
    private static String getHtmlRefreshTokenUrl(String appId, String refreshToken) {
        return MessageFormat.format("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}&grant_type=refresh_token&refresh_token={1}", appId, refreshToken);
    }

    /**
     * 用户基础信息请求地址
     *
     * @param accessToken
     * @param openId
     * @return
     */
    private static String getUserInfoUrl(String accessToken, String openId) {
        return MessageFormat.format("https://api.weixin.qq.com/cgi-bin/user/info?access_token={0}&openid" +
                "={1}&lang=zh_CN", accessToken, openId);
    }


    /**
     * 微信授权接口获取用户信息地址
     * @param appId
     * @param code
     * @return
     */
    private static String getAuthorize(String appId, String code) {
        return MessageFormat.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret=SECRET&code={1}&grant_type=authorization_code", appId, code);
    }


    /**
     * 客户发送消息接口
     * @param accessToken
     * @return
     */
    private static String getCustomSendMsgUrl(String accessToken) {
        return MessageFormat.format("https://api.weixin.qq" +
                ".com/cgi-bin/message/custom/send?access_token={0}", accessToken);
    }


    //public static WechatSign			 wechatSign;

    /**
     * 获取access_token的接口地址（GET） 限200（次/天）
     */
    public final static String ACCESS_TOKEN = "https://api.weixin.qq" +
            ".com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 获取JS-SDK的签名
     */
    public final static String SIGNATURE = "https://api.weixin.qq" +
            ".com/cgi-bin/ticket/getticket?type=jsapi&access_token=ACCESS_TOKEN";
    /**
     * 菜单创建（POST） 限100（次/天）
     */
    public static String MENU_CREATE = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 通过code换取网页授权access_token url
     */
    public static String GET_WEB_ACCESS_TOKEN = "https://api.weixin.qq" +
            ".com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    /**
     * 获取用户地理位置
     */
    public static String GET_USER_LOCATION = "https://api.weixin.qq" +
            ".com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    /**
     * 获取用户信息
     */
    public static String GET_USER_GROUPID = "https://api.weixin.qq" +
            ".com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    public static String PUSH_MSG = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

    /**
     * 获取跳转地址
     * @param appId
     * @param redirectUrl
     * @return
     */
    public static String getRedirectUrl(String appId, String redirectUrl) {
        return MessageFormat.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect", appId, redirectUrl);
    }

    /**
     * 获取access_token对象
     *
     * @param appid     凭证
     * @param appsecret 密钥
     * @return AccessToken对象
     */
    /*public static AccessToken getAccessToken(String appid, String appsecret) {
        AccessToken accessToken = null;

        String requestUrl = ACCESS_TOKEN.replace("APPID", appid).replace(
                "APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            try {
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInteger("expires_in"));
            } catch (JSONException e) {
                accessToken = null;
                // 获取token失败
                logger.error("获取token失败 errcode:" + jsonObject.getInteger("errcode")
                        + "，errmsg:" + jsonObject.getString("errmsg"));
            }
        }
        return accessToken;
    }*/

    /**
     * 获取access_token对象
     *
     * @param appid     凭证
     * @param appsecret
     */
    public static String getAccessTokenString(String appid, String appsecret) {
        String requestUrl = ACCESS_TOKEN.replace("APPID", appid).replace(
                "APPSECRET", appsecret);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            return jsonObject.getString("access_token");
        } else {
            return null;
        }
    }

    /**
     * 获取Signature对象
     *
     * @param jsapi_ticket
     * @param noncestr
     * @param timestamp
     * @param url
     * @return
     */
    public static String getSignature(String jsapi_ticket, String noncestr,
                                      String timestamp, String url) {

        String string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr="
                + noncestr + "&timestamp=" + timestamp + "&url=" + url;
        MessageDigest md = null;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行sha1加密
            byte[] digest = md.digest(string1.getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return tmpStr;
    }

    /**
     * 获取signature对象
     *
     * @param accessToken
     * @return
     */
    public static String getJsapiTicket(String accessToken) {
        String requestUrl = SIGNATURE.replace("ACCESS_TOKEN", accessToken);
        logger.debug("[getJsapiTicket] youzm :{},,{}", accessToken, requestUrl);
        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
        // 如果请求成功
        if (null != jsonObject) {
            return jsonObject.getString("ticket");
        } else {
            return null;
        }
    }

    /**
     * 生成签名的随机串
     *
     * @return
     */
    public static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成签名的时间戳
     *
     * @return
     */
    public static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param byteArray
     * @return
     */
    private static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串
     *
     * @param mByte
     * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
                'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        String s = new String(tempArr);
        return s;
    }

    /**
     * 创建菜单
     *
     * @param jsonMenu    菜单的json格式
     * @param accessToken 有效的access_token
     * @return 0表示成功，其他值表示失败
     */
    public static int createMenu(String jsonMenu, String accessToken) {

        int result = 0;
        // 拼装创建菜单的url
        String url = MENU_CREATE.replace("ACCESS_TOKEN", accessToken);
        // 调用接口创建菜单
        JSONObject jsonObject = WechatHttpRequestUtil.httpRequest(url, "POST", jsonMenu);

        if (null != jsonObject) {
            if (0 != jsonObject.getInteger("errcode")) {
                result = jsonObject.getInteger("errcode");
                logger.error("创建菜单失败 errcode:" + jsonObject.getInteger("errcode")
                        + "，errmsg:" + jsonObject.getString("errmsg"));
            }
        }

        return result;
    }

    /**
     * 获取openId
     *
     * @param code
     * @return
     */
    public static String getUserOpenId(String code, String appId,String secret) {
        logger.debug("[getUserOpenId] begin......");
        String url = GET_WEB_ACCESS_TOKEN
                .replace("APPID", appId).replace("SECRET",
                        secret).replace("CODE", code);
        logger.debug("[getUserOpenId] url: " + url);
        JSONObject jsonObject = WechatHttpRequestUtil.httpRequest(url, "GET", null);
        logger.debug("[getUserOpenId] jsonObject: " + jsonObject);
        if (null != jsonObject) {
            if (jsonObject.toString().indexOf("openid") < 0) {
                return "";
            }
            String openid = jsonObject.getString("openid");
            logger.debug("[getUserOpenId] openid: " + openid);
            return openid;
        }
        return "";
    }

    /**
     * 获取用户地理位置
     *
     * @param accessToken
     * @return
     */
    public static String getUserLocation(String accessToken, String openid) {
        logger.debug("[getUserLocation] begin......");
        String url = GET_USER_LOCATION
                .replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
        JSONObject jsonObject = WechatHttpRequestUtil.httpRequest(url, "GET", null);
        logger.debug("[getUserLocation] jsonObject: " + jsonObject);
        if (null != jsonObject) {
            if (jsonObject.toString().indexOf("openid") < 0) {
                return "";
            }
            String city = jsonObject.getString("city");
            logger.debug("[getUserLocation] city: " + city);
            return city;
        }
        return "";
    }

    /**
     * 获取用户是否关注信息
     *
     * @param accessToken
     * @param openid
     * @return
     */
    public static boolean getGroupid(String accessToken, String openid) {
        logger.debug("[getGroupid] begin......");
        String url = GET_USER_GROUPID
                .replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
        JSONObject jsonObject = WechatHttpRequestUtil.httpRequest(url, "GET", null);
        logger.debug("[getGroupid] jsonObject: " + jsonObject);
        if (null != jsonObject) {
            if (jsonObject.toString().indexOf("openid") < 0) {
                return false;
            }
            return jsonObject.toString().indexOf("groupid") >= 0;
        }
        return false;
    }

    /**
     * 发起https请求并获取结果
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpsRequest(String requestUrl,
                                          String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
//			SSLContext sslContext = SSLContext.getInstance("SSL","IBMJSSE2");
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url
                    .openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("server connection timed out.");
        } catch (Exception e) {
            logger.error("https request error:", e);
        }
        return jsonObject;
    }

    /**
     * 发起http请求并获取结果
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl,
                                         String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod)) {
                httpUrlConn.connect();
            }

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (ConnectException ce) {
            logger.error("server connection timed out.");
        } catch (Exception e) {
            logger.error("http request error:", e);
        }
        return jsonObject;
    }

    /**
     * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param createTime 消息创建时间
     * @return String
     */
    public static String formatTime(String createTime) {
        // 将微信传入的CreateTime转换成long类型，再乘以1000
        long msgCreateTime = Long.parseLong(createTime) * 1000L;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(msgCreateTime));
    }

    /**
     * 解析微信发来的请求(XML)
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    /*public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();

        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();
        // 读取输入流  
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素  
        Element root = document.getRootElement();
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();

        // 遍历所有子节点  
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源  
        inputStream.close();
        inputStream = null;
        return map;

    }*/

    /**
     * 基本消息对象转换成xml
     *
     * @param message 消息对象
     * @return xml
     */
    public static String messageToXml(Object message) {
        xstream.alias("xml", message.getClass());
        return xstream.toXML(message);
    }

    /**
     * 文本消息对象转换成xml
     *
     * @param textMessage 文本消息对象
     * @return xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        xstream.alias("xml", textMessage.getClass());
        return xstream.toXML(textMessage);
    }

    /**
     * 图文消息对象转换成xml
     *
     * @param newsMessage 图文消息对象
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        xstream.alias("item", Article.class);
        xstream.alias("xml", newsMessage.getClass());
        return xstream.toXML(newsMessage);
    }

    /**
     * 扩展xstream，使其支持CDATA块
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    public static JSONObject httpsRequests(String requestUrl,
                                           String requestMethod, String outputStr) throws IOException {
        JSONObject jsonObject = null;
        GetMethod getMethod = new GetMethod(requestUrl);
        getMethod.getParams().setContentCharset("UTF-8");
        new HttpClient().executeMethod(getMethod);
        String response = getMethod.getResponseBodyAsString();
        logger.info("httpsRequests:{}", response);
        jsonObject = JSONObject.parseObject(response);
        return jsonObject;
    }

    /**
     * emoji表情转换(hex to utf-16)
     *
     * @param hexEmoji
     * @return String
     */
    public static String emoji(int hexEmoji) {
        return String.valueOf(Character.toChars(hexEmoji));
    }

    public static void main(String[] args) {
        String appid = "wxf7ae0d9350c4a574";
        String appsecret = "1c4ffe1ff01908430255fd6ead3364f9";
        AccessToken accessToken = getAccessToken(appid, appsecret);
        System.out.println(accessToken.getAccessToken());





    }
}


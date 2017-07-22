package com.ai.ge.common.wechat;

import com.ai.ge.platform.model.wx.WxEventText;
import com.ai.ge.util.XmlObjectTransformUtils;
import com.ai.ge.platform.model.wx.WxMessage;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//import com.al.ec.platform.model.common.WechatSign;

/**
 * 微信通用接口工具类
 *
 * @author caspar.chen
 * @version 1.0
 */
public class WechatUtil {

    private static final Logger logger = LoggerFactory.getLogger(WechatUtil.class);

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
     * 接收HTTP请求内容，转换成WxEvent对象
     * @param text
     * @return
     */
    public static WxEventText getWxEvent(String text) {
        return XmlObjectTransformUtils.transform(text, WxEventText.class);
    }



    /**
     * 接收HTTP请求内容，转换成WxMessage对象
     * @param text
     * @return
     */
    public static WxMessage getWxEvent(String text, Class<? extends WxMessage> clazz) {
        return XmlObjectTransformUtils.transform(text, clazz);
    }


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
        JSONObject jsonObject = WechatUtil.httpRequest(url, "POST", jsonMenu);

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
    public static String getUserOpenId(String code) {
        logger.debug("[getUserOpenId] begin......");
        String url = GET_WEB_ACCESS_TOKEN
                .replace("APPID", ConstantWeChat.APPID).replace("SECRET",
                        ConstantWeChat.APPSECRET).replace("CODE", code);
        logger.debug("[getUserOpenId] url: " + url);
        JSONObject jsonObject = WechatUtil.httpRequest(url, "GET", null);
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
     * @return
     */
    public static String getUserLocation(String accessToken, String openid) {
        logger.debug("[getUserLocation] begin......");
        String url = GET_USER_LOCATION
                .replace("ACCESS_TOKEN", accessToken).replace("OPENID", openid);
        JSONObject jsonObject = WechatUtil.httpRequest(url, "GET", null);
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
        JSONObject jsonObject = WechatUtil.httpRequest(url, "GET", null);
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
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
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

    }

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
        String json = "{\"button\": "
                + "[{\"name\": \"个人信息\","
                + "\"sub_button\": [{\"type\": \"view\",\"name\": \"微代理绑定\",\"url\": \"https://open.weixin.qq" +
                ".com/connect/oauth2/authorize?appid=wx1fcbbe252e5eb235&redirect_uri=http://svn.ailk" +
                ".org:8000/wechat-sup/wechat/accountbind" +
                ".do&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect\",\"key\": " +
                "\"rselfmenu_0_0\",\"sub_button\": []}, {\"type\": \"view\",\"name\": \"微代理注册\",\"url\": " +
                "\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1fcbbe252e5eb235&redirect_uri=http" +
                "://svn.ailk.org:8000/wechat-sup/wechat/accountregister" +
                ".do&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect\",\"key\": " +
                "\"rselfmenu_0_1\", \"sub_button\": []}]}]}";
        String bindUrlString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxb1e8886dee45769c&"
                + "redirect_uri=http://svn.ailk.org:8000/wechat-sup/accountbind.do&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

        String registerUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxb1e8886dee45769c&"
                + "redirect_uri=http://svn.ailk.org:8000/wechat-sup/accountregister.do&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

        String taskUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxb1e8886dee45769c&"
                + "redirect_uri=http://svn.ailk.org:8000/wechat-sup/dashbord.do&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
        String maimengUrlString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/login/gate&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
        String wealthString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/login/dev/wealth&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
        String ordersString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/login/dev/orders&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
        String devAuditString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/developer/audit/gate&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

        String storeString = "http://www.zcy365.com/platform/login/cust/gate";

        String identityString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/login/gate/identity&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

        String snackboxString = "http://www.zcy365.com/platform/app/snack-index.html";

        String awardString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/login/cust/gate/activity/award&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

        String wedDiscountString = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxf7ae0d9350c4a574&"
                + "redirect_uri=http://www.zcy365.com/platform/login/cust/gate/activity/wed-discount&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

//		String maimengUrlString2 = "https://open.weixin.qq.com/connect/oauth2/authorize?"
//				+ "appid=wxad5cef002b149662&"
//				+ "redirect_uri=http://www.189ytj.com/showroom/login/gate&"
//				+ "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";

        String bishetongStr = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=wxb1e8886dee45769c&"
                + "redirect_uri=http://bishetong.ngrok.natapp.cn/login/weixin&"
                + "response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect";
        String json2 = "{"
                + "\"button\":["
//					+"{\"name\":\"个人中心\","
//					+ "\"sub_button\":[{\"type\":\"view\",\"name\":\"绑定微代理\",\"url\":\"" + bindUrlString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"注册翼桶金\",\"url\":\"" + registerUrl + "\"},"
//									+ "{\"type\":\"click\",\"name\":\"个人信息\",\"key\":\"myMessage\"}"
//									+ "]"
//					+ "},"
//					+ "{\"name\":\"麦萌商城\","
//					+ " \"sub_button\":[{\"type\":\"view\",\"name\":\"商城\",\"url\":\"" + storeString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"实名制\",\"url\":\"" + identityString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"零食盒子\",\"url\":\"" + snackboxString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"周三折上折\",\"url\":\"" + wedDiscountString + "\"}"
//									+ "]"
//					+ "},"
//					+ "{\"name\":\"卖萌\","
//					+ " \"sub_button\":[{\"type\":\"view\",\"name\":\"卖盟测试\",\"url\":\"" + maimengUrlString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"我的财富\",\"url\":\"" + wealthString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"我的订单\",\"url\":\"" + ordersString + "\"},"
//									+ "{\"type\":\"click\",\"name\":\"麦萌指南\",\"key\":\"MY_INFO\"},"
//									+ "{\"type\":\"view\",\"name\":\"麦芽审核\",\"url\":\"" + devAuditString + "\"}"
//									+ "]"
//					+ "}]"
                + "{\"name\":\"毕设通\",\"type\":\"view\",\"url\":\"" + bishetongStr + "\"}]"
//					+ " \"sub_button\":[{\"type\":\"view\",\"name\":\"卖盟测试\",\"url\":\"" + maimengUrlString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"我的财富\",\"url\":\"" + wealthString + "\"},"
//									+ "{\"type\":\"view\",\"name\":\"我的订单\",\"url\":\"" + ordersString + "\"},"
//									+ "{\"type\":\"click\",\"name\":\"麦萌指南\",\"key\":\"MY_INFO\"},"
//									+ "{\"type\":\"view\",\"name\":\"麦芽审核\",\"url\":\"" + devAuditString + "\"}"
//									+ "]"
//					+ "}]"
                + "}";
//		String token = getAccessTokenString("wxb1e8886dee45769c","473f050acb42a20d57f7d7bafbfd038f");
        String token =
                "RFXxtFi4Q-rU5KjCl2OMBnzLcdDgz" +
                        "-iGARxnin8iZ8lQyVEPGoqweRG9yzHE9tzc5Jr3AHltshrFkvcS5Jtw061NRtIQz82bwU293C1OtBcTQHhAFAPMD";
//		System.out.println(token);
        int i = createMenu(json2.trim(), token);
        System.out.println(i);
//		String userOpenId = getUserOpenId("011a33a1f0621ed9902475235b0c614G");
//		System.out.println(new Date().getTime());

//		System.out.println(userOpenId);
        //		JSONObject jsonObject = WeixinUtil
//				.httpsRequest(
//						"https://api.weixin.qq.com/cgi-bin/menu/create?access_token=bX7shc45qhY0PnJMuRA_B1
// -KzZlkFm62vSldggOQml_qS45WIxW-qSSAhPl7AKJBkIt4rWavY5dBjcdFx_otMPjL9XtgRgLVDomMrqufXok",
//						"POST", json);

//		if (null != jsonObject) {
//			String openid = jsonObject.getString("openid");
//			log.debug("[getUserOpenId] openid: " + openid);
//		}
//		System.out.println(i);
    }
}


//{
//    "button": [
//        {
//            "name": "麦查查", 
//            "sub_button": [
//				{
//				    "type": "view", 
//				    "name": "实名认证", 
//				    "url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxad5cef002b149662&redirect_uri
// =http://www.189ytj.com/showroom/login/gate/identity&response_type=code&scope=snsapi_base&state=STATE
// &connect_redirect=1#wechat_redirect",
//				    "sub_button": [ ]
//				}, 
//                {
//                    "type": "view", 
//                    "name": "话费查询", 
//                    "url": "http://wapjs.189.cn/tysh/pages/main/home.html#/tysh/pages/bhBusiness/balanceOfAccount
// .html?ztInterSource=100003&platform=wap",
//                    "sub_button": [ ]
//                }, 
//                {
//                    "type": "view", 
//                    "name": "流量查询", 
//                    "url": "http://wapjs.189.cn/tysh/pages/main/home.html#/tysh/pages/bhFlow/index.html?ztInterSource=100003&platform=wap", 
//                    "sub_button": [ ]
//                }, 
//                {
//                    "type": "view", 
//                    "name": "流量礼包", 
//                    "url": "http://202.102.116.105:9080/portal_jqm_estore/campus/welcomeNew?channelId=50000015&staffCode=YUKAN&campusType=10005", 
//                    "sub_button": [ ]
//                },{
//                    "type": "view", 
//                    "name": "订单查询", 
//                    "url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxad5cef002b149662&redirect_uri=http://www.189ytj.com/showroom/login/cust/orders&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect",
//                    "sub_button": [ ]
//                },
//            ]
//        }, 
//        {
//            "name": "麦淘淘", 
//            "sub_button": [
//                {
//                    "type": "view", 
//                    "name": "校园旗舰店", 
//                    "url": "http://www.189ytj.com/showroom/login/cust/gate",
//                    "sub_button": [ ]
//                },
//                {
//                    "type": "view", 
//                    "name": "福利广场", 
//                    "url": "http://www.189ytj.com/showroom/app/activity-list.html",
//                    "sub_button": [ ]
//                },
//				{
//					"type": "view", 
//					"name": "零食盒子", 
//					"url": "http://www.189ytj.com/showroom/app/snack-index.html",
//					"sub_button": [ ]
//				},
//				{
//					"type": "view", 
//					"name": "奖品领取", 
//					"url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxad5cef002b149662&redirect_uri=http://www.189ytj.com/showroom/login/cust/gate/activity/award&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect",
//					"sub_button": [ ]
//				}
//            ]
//        },
//        {
//            "name": "麦圈圈", 
//            "sub_button": [
//				  {
//					"type": "click", 
//					"name": "加盟指南", 
//					"key": "MY_INFO", 
//					"sub_button": [ ]
//				},
//                {
//                    "type": "view", 
//                    "name": "我的小麦铺", 
//                    "url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxad5cef002b149662&redirect_uri=http://www.189ytj.com/showroom/login/gate&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect",
//                    "sub_button": [ ]
//                },
//                {
//                    "type": "view", 
//                    "name": "麦芽审核", 
//                    "url": "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxad5cef002b149662&redirect_uri=http://www.189ytj.com/showroom/developer/audit/gate&response_type=code&scope=snsapi_base&state=STATE&connect_redirect=1#wechat_redirect",
//                    "sub_button": [ ]
//                }
//            ]
//        }
//    ]
//}


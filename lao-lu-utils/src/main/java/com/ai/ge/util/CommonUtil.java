package com.ai.ge.util;


import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.xmlbeans.XmlException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 公共工具类，主要保存一些公共的方法或者获取公共的变量
 *
 * @author tongfang
 */
public class CommonUtil {

    // spring上下文,公共变量
    public static ApplicationContext APPLICATION_CONTEXT = null;

    public static ResourceBundle rsb = ResourceBundle.getBundle("jdbc");

    public static ThreadPoolExecutor threadPool;


    // spring上下文在quartz上下文中保存时使用的键
    public static final String APPLICATION_CONTEXT_STR = "applicationContext";


    // 日志记录器
    private static Logger log = Logger.getLogger(CommonUtil.class);

    static {

    }

    /**
     * 生成UUID字符串
     *
     * @return UUID字符串
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    /**
     * 获取其他配置信息
     *
     * @param configKey 要获取的配置数据的键
     * @return 要获取的配置数据的值
     */
    public static String getConfigValue(String configKey) {
        return rsb.getString(configKey);
    }

    /**
     * 将源字符串加上单引号，如果源字符串是以逗号分隔，则将每个逗号内部的字符串都加上单引号,<br/>
     * 并且会去掉每个字符串左右的空格, 如果两个逗号之间的字符串为空，则该字符串将被抛弃, 该方法<br/>
     * 用于删除多条记录时，给ID字符串中的每个ID添加单引号
     *
     * @param origin 源字符串
     * @return 带单引号的字符串
     */
    public static String getSingleQuotesStr(String origin) {
        // 返回结果
        String results = "";

        if (origin == null || origin.trim().length() == 0) {
            return "";
        }

        // 没有逗号分隔的单个字符串，直接在左右添加单引号后返回结果
        if (origin.indexOf(",") < 0) {
            return "'" + origin.trim() + "'";
        }

        // 有逗号分隔的多个字符串，先根据逗号分隔，得到对应的数组
        String[] temp = origin.split(",");

        // 循环该数组，得到其中的每一个字符串，并且添加单引号
        for (int i = 0; temp != null && i < temp.length; i++) {
            // 中间的字符串为null或者为空，将被抛弃
            if (temp[i] == null || temp[i].trim().length() == 0) {
                continue;
            }

            if (results.trim().length() > 0) {
                results += ",";
            }

            // 添加单引号
            results += "'" + temp[i].trim() + "'";
        }

        return results;
    }

    /**
     * 获取本项目根目录的绝对路径
     *
     * @return 根目录的绝对路径
     * <p/>
     * 2012-10-15
     */
    public static String getWebRootPath() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String rootPath = request.getSession().getServletContext().getRealPath("/");

        return rootPath;
    }

    /**
     * 获取本项目下某个指定文件夹的绝对路径
     *
     * @param path 文件夹名称
     * @return 该文件夹对应的绝对路径
     * <p/>
     * 2012-10-15
     */
    public static String getWebDirPath(String path) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        String dirPath = request.getSession().getServletContext().getRealPath(path);

        return dirPath;
    }

    /**
     * 根据参数长度，产生数字验证码
     *
     * @param length
     * @return
     */
    public static String getIntCode(int length) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append((random.nextInt() % 10 + 10) % 10);
            //sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    /**
     * 生成Size大小的随机数据
     *
     * @param size 大小
     * @return 随机字符串
     */
    public static String getCode(int size) {
        String str = "abcdefghigklmnopkrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < size; i++) {
            sf.append(str.charAt(random.nextInt(62)));
        }
        return sf.toString();
    }

    /**
     * 生成Size大小的随机数据
     *
     * @param size 大小
     * @return 随机字符串
     */
    public static String genRandomNum(int size) {
        //10个数字
        final int maxNum = 10;
        int i; //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < size) {
            //生成随机数，取绝对值，防止生成负数，
            i = Math.abs(r.nextInt(maxNum)); //生成的数最大为10

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    /**
     * 将文件流加密后写入到目标文件中
     *
     * @param in   文件流
     * @param file 目标文件
     * @param key  密码, 默认为123456
     */
    public static void fileEncrypt(InputStream in, File file, String key) {
        log.debug("[fileEncrypt] --- 开始 --- 将文件流加密后写入到目标文件中");
        if (in == null) {
            log.debug("[fileEncrypt] 文件输入流in为null");
            return;
        }
        if (file == null) {
            log.debug("[fileEncrypt] 目标文件file为null");
            return;
        }
        if (key == null || key.trim().length() == 0) {
            log.debug("[fileEncrypt] 密码为空, 设为默认密码: 123456");
            key = "123456";
        }

        Cipher cipher = null;
        OutputStream out = null;
        CipherInputStream cis = null;

        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, CommonUtil.getKey(key));
            out = new FileOutputStream(file);
            cis = new CipherInputStream(in, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("[fileEncrypt] 将文件流加密后写入到目标文件中时出现异常, 异常信息: " + e.toString());
        } finally {
            try {
                if (cis != null) cis.close();
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("[fileEncrypt] 关闭文件流时出现异常, 异常信息: " + e.toString());
            }
        }

        log.debug("[fileEncrypt] --- 结束 --- 将文件流加密后写入到目标文件中");
    }

    /**
     * 根据参数生成KEY
     */
    private static SecretKey getKey(String strKey) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(strKey.getBytes()));
            return generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        }
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return true;
        }
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param formula
     * @return Object
     * @throws ScriptException
     * @throws
     * @Title: formulaComputer
     * @author youzm  
     * @Description: 公式计算
     */
    public static Object formulaComputer(String formula) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(formula);

        System.out.println("结果类型：" + result.getClass().getName() + ",计算结果:" + result);
        return result;
    }

    public static BigDecimal getBigDecimal(Object value) {
        BigDecimal ret = null;
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass()
                        + " into a BigDecimal.");
            }
        }
        return ret;
    }

    public static boolean isRequestFromWexin(String userAgent) {
        String ua = userAgent.toLowerCase();
        return ua.indexOf("micromessenger") > 0;
    }

    /**
     * 获取远程I访问地址
     *
     * @param request
     * @return
     */
    public static String getRemortIp(HttpServletRequest request) {

        String ip = request.getHeader("ORIG_CLIENT_IP");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (StringUtils.isNotEmpty(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }

        ip = request.getRemoteAddr();

        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * @param response
     * @param key
     * @param value
     */
    public static void setCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * @param response
     * @param key
     * @param value
     */
    public static void delCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static String getTextFromWord(String url){
        String str = new String();

        if (url.endsWith(".doc")) {

            try {
                InputStream is = new FileInputStream(new File(url));
                WordExtractor ex = new WordExtractor(is);
                str = ex.getText();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (url.endsWith(".docx")) {
            OPCPackage opcPackage = null;
            try {
                opcPackage = POIXMLDocument.openPackage(url);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                str = extractor.getText();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlException e) {
                e.printStackTrace();
            } catch (OpenXML4JException e) {
                e.printStackTrace();
            }

        }

        return str;
    }

    /**
     * @param request
     * @param key
     * @return
     */
    public static String getCookie(HttpServletRequest request, String key) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie c : cookies) {
                if (c.getName().equals(key)) {
                    return c.getValue();
                }
            }
        }

        return null;
    }

    public static BigDecimal format(BigDecimal bigDecimal) {
        return format(bigDecimal, "#.00");
    }

    public static BigDecimal format(BigDecimal bigDecimal, String format) {
        return new BigDecimal(new DecimalFormat(format).format(bigDecimal));
    }

    /**
     * 通过MD5 16位根据 source 的值加密后赋值给 target 属性
     *
     * @param object
     * @param source
     * @param target
     */
    public static void md516DecodeObjectField(Object object, String source, String target) {
        if (null == object || StringUtils.isBlank(source) || StringUtils.isBlank(target)) {
            return;
        }

//        Field sourceField = FieldUtils.getDeclaredField(object.getClass(), source);
//        Field targetField = FieldUtils.getDeclaredField(object.getClass(), target);

        Class<?> objectClass = object.getClass();
        Field sourceField = null;
        Field targetField = null;
        Object sourceVal = null;
        do {
            try {
                if (sourceField == null) {
                    sourceField = objectClass.getDeclaredField(source);
                    sourceField.setAccessible(true);
                    sourceVal = sourceField.get(object);
                }
                if (targetField == null) {
                    targetField = objectClass.getDeclaredField(target);
                }
            } catch(Exception e) {}
        } while((objectClass = objectClass.getSuperclass()) != null);
        if (null == sourceField || null == targetField || null == sourceVal) {
            return;
        }

        try {
//            Object sourceVal = FieldUtils.readDeclaredField(object, source, true);
//            if (null == sourceVal) {
//                return;
//            }

            String targetVal = MD5Util.get16BitMD5String(String.valueOf(sourceVal), String.valueOf(sourceVal));

//            FieldUtils.writeDeclaredField(object, target, targetVal);
            targetField.setAccessible(true);
            targetField.set(object, targetVal);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

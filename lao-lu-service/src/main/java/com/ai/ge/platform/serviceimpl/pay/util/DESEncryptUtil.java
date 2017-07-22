package com.ai.ge.platform.serviceimpl.pay.util;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;

/**
 * DES对称加密算法
 * <p/>
 * 加密:encrypt(String srcStr, String key) 解密:descrypt(String encryptStr,String
 * key ) 加密解密过程中采用的key是一样的
 *
 * @author zhaoxin
 */
public class DESEncryptUtil {
    private static Logger logger = Logger.getLogger(DESEncryptUtil.class);

    /**
     * 日志记录器
     */
    private final static String CHARSET = "UTF-8";

    /**
     * 所用算法
     */
    private final static String ALGORITHM = "DES";

    private final static String key = "!Q@W#E$R%T^Y&U*I(O)P";


    public static final String PAY_DESKEY = "!Q@W#E$R%T^Y&U*I(!@#$%^";

    /**
     *
     *
     * @param srcStr 明文
     * @param key    密钥
     * @return 密文
     */
    public static String encrypt(String srcStr) {
        String strEncrypt = null;
        try {
            strEncrypt = Base32.encode(encryptByte(srcStr.getBytes(CHARSET), key));
        } catch (Exception e) {
            logger.error("加密异常:", e);
            throw new RuntimeException("加密异常", e);
        }
        return strEncrypt;
    }

    /**
     * 加密
     *
     * @param srcStr 明文
     * @param key    密钥
     * @return 密文
     */
    public static String encrypt(String srcStr, String key) {
        String strEncrypt = null;
        try {
            strEncrypt = Base32.encode(encryptByte(srcStr.getBytes(CHARSET), key));
        } catch (Exception e) {
            logger.error("加密异常:", e);
            throw new RuntimeException("加密异常", e);
        }
        return strEncrypt;
    }

    /**
     * 解密
     *
     * @param encryptStr 密文
     * @param key        密钥
     * @return 明文
     */
    public static String decrypt(String encryptStr) {
        String strDecrypt = null;
        try {
            strDecrypt = new String(decryptByte(Base32.decode(encryptStr), key), CHARSET);
        } catch (Exception e) {
            logger.error("解密异常[" + encryptStr + "]:", e);
            throw new RuntimeException("解密异常[" + encryptStr + "]:", e);
        } finally {
        }
        return strDecrypt;
    }  /**
     * 解密
     *
     * @param encryptStr 密文
     * @param key        密钥
     * @return 明文
     */
    public static String decrypt(String encryptStr, String key) {
        String strDecrypt = null;
        try {
            strDecrypt = new String(decryptByte(Base32.decode(encryptStr), key), CHARSET);
        } catch (Exception e) {
            logger.error("解密异常[" + encryptStr + "]:", e);
            throw new RuntimeException("解密异常[" + encryptStr + "]:", e);
        } finally {
        }
        return strDecrypt;
    }

    /**
     * 字节加密
     *
     * @param srcByte 明文
     * @param key     密钥
     * @return 密文
     */
    public static byte[] encryptByte(byte[] srcByte, String key) {
        byte[] byteFina = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey(key));
            byteFina = cipher.doFinal(srcByte);
        } catch (Exception e) {
            logger.error("字节加密异常:", e);
            throw new RuntimeException("字节加密异常", e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 字节解密
     *
     * @param encryptByte 密文
     * @param key         密钥
     * @return 明文
     */
    public static byte[] decryptByte(byte[] encryptByte, String key) {
        Cipher cipher;
        byte[] decryptByte = null;
        try {
            cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, generateKey(key));
            decryptByte = cipher.doFinal(encryptByte);
        } catch (Exception e) {
            logger.error("字节解密异常:", e);
            throw new RuntimeException("字节解密异常", e);
        } finally {
            cipher = null;
        }
        return decryptByte;

    }

    /**
     * 根据传入的字符串的key生成key对象
     *
     * @param strKey
     */
    public static Key generateKey(String strKey) {
        try {
            DESKeySpec desKeySpec = new DESKeySpec(strKey.getBytes(CHARSET));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            return keyFactory.generateSecret(desKeySpec);
        } catch (Exception e) {
            throw new RuntimeException("生成密钥异常", e);
        }

    }

    /**
     * 测试函数
     *
     * @param args
     */
    public static void main(String[] args) {

        String strEnc = DESEncryptUtil.encrypt("10001");
        System.out.println("加密后,密文:" + strEnc);

        String strDes = DESEncryptUtil.decrypt(strEnc);
        System.out.println("解密后,明文:" + strDes);

    }

}

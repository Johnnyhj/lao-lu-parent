package com.ai.ge.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger log = LoggerFactory.getLogger(DESEncryptUtil.class);

    /**
     * 日志记录器
     */
    public final static String CHARSET = "UTF-8";

    /**
     * 所用算法
     */
    private final static String ALGORITHM = "DES";

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
            log.error("加密异常:" + srcStr);
            throw new RuntimeException("加密异常", e);
        }
        strEncrypt = strEncrypt.replaceAll("\\r", "=r");
        strEncrypt = strEncrypt.replaceAll("\\n", "=n");
        return strEncrypt;
    }

    /**
     * 解密
     *
     * @param encryptStr 密文
     * @param key        密钥
     * @return 明文
     */
    public static String decrypt(String encryptStr, String key) {

        String strDecrypt = null;
        try {
            encryptStr = encryptStr.replaceAll("=r", "\r");
            encryptStr = encryptStr.replaceAll("=n", "\n");
            strDecrypt = new String(decryptByte(Base32.decode(encryptStr), key), CHARSET);
        } catch (Exception e) {
            log.error("解密异常[" + encryptStr + "]:");
            throw new RuntimeException("解密异常[" + encryptStr + "]:", e);
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
            log.error("字节加密异常:" + srcByte);
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
            log.error("字节解密异常:" + encryptByte);
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

        String key = "201500010104";
        String src = "crm_app";

        log.debug("密钥:" + key);
        log.debug("明文:" + src);
        //System.out.println("密钥:" + key);
        //  System.out.println("明文:" + src);

        String strEnc = DESEncryptUtil.encrypt("201500010104",
                key);
        log.debug("加密后,密文:" + strEnc);
        System.out.println("加密后,密文:" + strEnc);

        String strDes = DESEncryptUtil.decrypt(strEnc, key);
        log.debug("解密后,明文:" + strDes);
        System.out.println("解密后,明文:" + strDes);

    }
}

/**
 * Base32加解密
 *
 * @author Zhaocy3
 */
class Base32 {
    private static final char[] ALPHABET =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
                    'V',
                    'W', 'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7'};

    private static final byte[] DECODE_TABLE;

    static {
        DECODE_TABLE = new byte[128];

        for (int i = 0; i < DECODE_TABLE.length; i++) {
            DECODE_TABLE[i] = (byte) 0xFF;
        }
        for (int i = 0; i < ALPHABET.length; i++) {
            DECODE_TABLE[(int) ALPHABET[i]] = (byte) i;
            if (i < 24) {
                DECODE_TABLE[(int) Character.toLowerCase(ALPHABET[i])] = (byte) i;
            }
        }
    }

    /**
     * Base32的编码;
     *
     * @param value
     * @return
     * @throws Exception
     */
    public static String encode(String value) throws Exception {
        return encode(value.getBytes(DESEncryptUtil.CHARSET));
    }

    /**
     * Base32的编码;
     *
     * @param data
     * @return
     */
    public static String encode(byte[] data) {

        char[] chars = new char[((data.length * 8) / 5) + ((data.length % 5) != 0 ? 1 : 0)];

        for (int i = 0, j = 0, index = 0; i < chars.length; i++) {
            if (index > 3) {
                int b = data[j] & (0xFF >> index);
                index = (index + 5) % 8;
                b <<= index;
                if (j < data.length - 1) {
                    b |= (data[j + 1] & 0xFF) >> (8 - index);
                }
                chars[i] = ALPHABET[b];
                j++;
            } else {
                chars[i] = ALPHABET[((data[j] >> (8 - (index + 5))) & 0x1F)];
                index = (index + 5) % 8;
                if (index == 0) {
                    j++;
                }
            }
        }

        return new String(chars);
    }

    /**
     * Base32的解码;
     *
     * @param value
     * @return
     * @throws Exception
     */
    public static byte[] decode(String value) throws Exception {

        char[] stringData = value.toCharArray();
        byte[] data = new byte[(stringData.length * 5) / 8];

        for (int i = 0, j = 0, index = 0; i < stringData.length; i++) {
            int val;

            try {
                val = DECODE_TABLE[stringData[i]];
            } catch (ArrayIndexOutOfBoundsException e) {
                return value.getBytes(DESEncryptUtil.CHARSET);
            }

            if (val == 0xFF) {
                //
                return value.getBytes(DESEncryptUtil.CHARSET);
            }

            if (index <= 3) {
                index = (index + 5) % 8;
                if (index == 0) {
                    data[j++] |= val;
                } else {
                    data[j] |= val << (8 - index);
                }
            } else {
                index = (index + 5) % 8;
                data[j++] |= (val >> index);
                if (j < data.length) {
                    data[j] |= val << (8 - index);
                }
            }
        }
        return data;
    }
}


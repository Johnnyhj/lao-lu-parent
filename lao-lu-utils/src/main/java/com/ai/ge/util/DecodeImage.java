package com.ai.ge.util;

import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

/**
 * base64 转图片方法
 *
 * @author wangjian
 */
public class DecodeImage {

    public static String generateImage(String imgStr, String imgtype, String basepath) {
        // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return null;
        // Base64 decoder = new Base64();
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成指定路径和指定名称的文件
            // 获取年月
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            String path = basepath + "/" + year + "" + month;
            File parentPath = new File(path);
            // 如果指定路径不存在，生成指定路径
            if (!parentPath.exists()) {
                parentPath.mkdirs();
            }

            long countNumber = System.currentTimeMillis();

            File file = new File(parentPath, countNumber + "." + imgtype);
            // 文件名
            /* 文件名 */
            String rpath = year + "" + month + "/" + countNumber + "."
                    + imgtype;
            String fileName = file.getPath();
            OutputStream out = new FileOutputStream(fileName);
            out.write(b);
            out.flush();
            out.close();
            return rpath;
        } catch (Exception e) {
            return null;
        }
    }

}

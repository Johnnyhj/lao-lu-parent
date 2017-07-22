package com.ai.ge.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wj on 15/10/20.
 */
public class Kuaidi100Util {


    public static Logger logger = Logger.getLogger(Kuaidi100Util.class);

    /**
     *
     * @param type
     * @param postid
     */
    public static String query(String type, String postid)
    {
        String content = "";
        try
        {
            URL url = new URL("http://www.kuaidi100.com/query?type=" + type + "&postid=" + postid);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.connect();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), "utf-8"));// 设置编码,否则中文乱码
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line;
            }

            reader.close();
            connection.disconnect();

        }
        catch (Exception e)
        {
            content = "";
            logger.error(e.getMessage(), e);
        }

        return content;
    }
}

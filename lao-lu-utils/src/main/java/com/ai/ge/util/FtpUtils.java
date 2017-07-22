package com.ai.ge.util;

/**
 * Created by Sam on 17/5/23.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
public class FtpUtils {
    private FTPClient ftpClient;
    private String fileName, strencoding;
    private String ip = "10.20.16.172";        // 服务器IP地址
    private String userName = "smeftp";        // 用户名
    private String userPwd = "XCjApiWdDmPnd8cb";        // 密码
    private int port = 21;      // 端口号
    private String path = "/QFQD/";        // 读取文件的存放目录

    /**
     * init ftp servere
     */
    public FtpUtils() {
        this.reSet();
    }

    public FtpUtils( String ip, String userName, String userPwd, int port, String path) {
        this.ip = ip;
        this.userName = userName;
        this.userPwd = userPwd;
        this.port = port;
        this.path = path;
        this.reSet();
    }

    public void reSet() {
        // 以当前系统时间拼接文件名
        fileName = "arrear_user_201705.txt";
        strencoding = "UTF-8";
        this.connectServer(ip, port, userName, userPwd, path);
    }



    /**
     * @param ip
     * @param port
     * @param userName
     * @param userPwd
     * @param path
     * @throws SocketException
     * @throws IOException function:连接到服务器
     */
    public void connectServer(String ip, int port, String userName, String userPwd, String path) {
        ftpClient = new FTPClient();
        try {
            // 连接
            ftpClient.connect(ip, port);
            // 登录
            ftpClient.login(userName, userPwd);
            if (path != null && path.length() > 0) {
                // 跳转到指定目录
                ftpClient.changeWorkingDirectory(path);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException function:关闭连接
     */
    public void closeServer() {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param path
     * @return function:读取指定目录下的文件名
     * @throws IOException
     */
    public List<String> getFileList(String path) {
        List<String> fileLists = new ArrayList<String>();
        // 获得指定目录下所有文件名
        FTPFile[] ftpFiles = null;
        try {
            ftpFiles = ftpClient.listFiles(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++) {
            FTPFile file = ftpFiles[i];
            if (file.isFile()) {
                fileLists.add(file.getName());
            }
        }
        return fileLists;
    }

    /**
     * @return function:从服务器上读取指定的文件
     * @throws ParseException
     * @throws IOException
     */
    public String readFile(String fileName) throws ParseException {
        InputStream ins = null;
        StringBuilder builder = null;
        try {
            // 从服务器上读取指定的文件
            ins = ftpClient.retrieveFileStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
            String line;
            builder = new StringBuilder(150);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                builder.append(line);
            }
            reader.close();
            if (ins != null) {
                ins.close();
            }
            // 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题
            ftpClient.getReply();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * @param fileName function:删除文件
     */
    public void deleteFile(String fileName) {
        try {
            ftpClient.deleteFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * @return function:从服务器上读取指定的文件
     * @throws ParseException
     * @throws IOException
     */
    public List<String> readsFile(String fileName) throws ParseException {
        List<String> stringList = new ArrayList<String>();
        InputStream ins = null;
        StringBuilder builder = null;
        try {
            // 从服务器上读取指定的文件
            ins = ftpClient.retrieveFileStream(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
            String line;
//            builder = new StringBuilder(150);
            while ((line = reader.readLine()) != null) {
                if(!removeTitle(line)&& !StringUtils.isEmpty(line))
                    stringList.add(line);
            }
            reader.close();
            if (ins != null) {
                ins.close();
            }
            // 主动调用一次getReply()把接下来的226消费掉. 这样做是可以解决这个返回null问题
            ftpClient.getReply();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


    public  boolean removeTitle(String line){
        return  line.indexOf("实名制证件类型")>-1;
    }

}

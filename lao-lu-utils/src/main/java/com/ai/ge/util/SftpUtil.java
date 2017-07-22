package com.ai.ge.util;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import java.text.ParseException;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
/**
 * Created by Sam on 17/5/23.
 */
public class SftpUtil {
    /**
     * 文件路径前缀. /ddit-remote
     */
    private static final String PRE_FIX = "/test-noryar";

    /**
     * 获取sftp协议连接.
     * @param host 主机名
     * @param port 端口
     * @param username 用户名
     * @param password 密码
     * @return 连接对象
     * @throws JSchException 异常
     */
    public static ChannelSftp getSftpConnect(final String host, final int port, final String username,
                                             final String password) throws JSchException {
        ChannelSftp sftp = null;
        JSch jsch = new JSch();
        jsch.getSession(username, host, port);
        Session sshSession = jsch.getSession(username, host, port);
        sshSession.setPassword(password);
        Properties sshConfig = new Properties();
        sshConfig.put("StrictHostKeyChecking", "no");
        sshSession.setConfig(sshConfig);
        sshSession.connect();
        Channel channel = sshSession.openChannel("sftp");
        channel.connect();
        sftp = (ChannelSftp) channel;
        return sftp;
    }

    /**
     * 下载文件-sftp协议.
     * @param downloadFile 下载的文件
     * @param saveFile 存在本地的路径
     * @param sftp sftp连接
     * @return 文件
     * @throws Exception 异常
     */
    public static File download(final String downloadFile, final String saveFile, final ChannelSftp sftp)
            throws Exception {
        FileOutputStream os = null;
        File file = new File(saveFile);
        try {
            if (!file.exists()) {
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            os = new FileOutputStream(file);
            List<String> list = formatPath(downloadFile);
            sftp.get(list.get(0) + list.get(1), os);
        } catch (Exception e) {
            exit(sftp);
            throw e;
        } finally {
            if (null != os)
            {
                os.close();
            }
        }
        return file;
    }

    /**
     * 下载文件-sftp协议.
     * @param downloadFile 下载的文件
     * @param saveFile 存在本地的路径
     * @param sftp sftp连接
     * @return 文件 byte[]
     * @throws Exception 异常
     */
    public static byte[] downloadAsByte(final String downloadFile, final ChannelSftp sftp) throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            List<String> list = formatPath(downloadFile);
            sftp.get(list.get(0) + list.get(1), os);
        } catch (Exception e) {
            exit(sftp);
            throw e;
        } finally {
            os.close();
        }
        return os.toByteArray();
    }

    /**
     * 删除文件-sftp协议.
     * @param deleteFile 要删除的文件
     * @param sftp sftp连接
     * @throws Exception 异常
     */
    public static void rmFile(final String deleteFile, final ChannelSftp sftp) throws Exception {
        try {
            sftp.rm(deleteFile);
        } catch (Exception e) {
            exit(sftp);
            throw e;
        }
    }

    /**
     * 删除文件夹-sftp协议.
     * @param deleteFile 文件夹路径
     * @param sftp sftp连接
     * @throws Exception 异常
     */
    public static void rmDir(final String pathString, final ChannelSftp sftp) throws Exception {
        try {
            sftp.rmdir(pathString);
        } catch (Exception e) {
            exit(sftp);
            throw e;
        }
    }

    /**
     * 上传文件-sftp协议.
     * @param srcFile 源文件
     * @param dir 保存路径
     * @param fileName 保存文件名
     * @param sftp sftp连接
     * @throws Exception 异常
     */
    private static void uploadFile(final String srcFile, final String dir, final String fileName, final ChannelSftp sftp)
            throws Exception {
        mkdir(dir, sftp);
        sftp.cd(dir);
        sftp.put(srcFile, fileName);
    }

    /**
     * 上传文件-sftp协议.
     * @param srcFile 源文件路径，/xxx/xxx.zip 或 x:/xxx/xxx.zip;
     * @param sftp sftp连接
     * @throws Exception 异常
     */
    public static void uploadFile(final String srcFile, final ChannelSftp sftp) throws Exception {
        try {
            File file = new File(srcFile);
            if (file.exists()) {
                List<String> list = formatPath(srcFile);
                uploadFile(srcFile, list.get(0), list.get(1), sftp);
            }
        } catch (Exception e) {
            exit(sftp);
            throw e;
        }
    }

    /**
     * 根据路径创建文件夹.
     * @param dir 路径 必须是 /xxx/xxx/xxx/ 不能就单独一个/
     * @param sftp sftp连接
     * @throws Exception 异常
     */
    public static boolean mkdir(final String dir, final ChannelSftp sftp) throws Exception {
        try {
            if (StringUtils.isBlank(dir))
                return false;
            String md = dir.replaceAll("\\\\", "/");
            if (md.indexOf("/") != 0 || md.length() == 1)
                return false;
            return mkdirs(md, sftp);
        } catch (Exception e) {
            exit(sftp);
            throw e;
        }
    }

    /**
     * 递归创建文件夹.
     * @param dir 路径
     * @param sftp sftp连接
     * @return 是否创建成功
     * @throws SftpException 异常
     */
    private static boolean mkdirs(final String dir, final ChannelSftp sftp) throws SftpException {
        String dirs = dir.substring(1, dir.length() - 1);
        String[] dirArr = dirs.split("/");
        String base = "";
        for (String d : dirArr) {
            base += "/" + d;
            if (dirExist(base + "/", sftp)) {
                continue;
            } else {
                sftp.mkdir(base + "/");
            }
        }
        return true;
    }

    /**
     * 判断文件夹是否存在.
     * @param dir 文件夹路径， /xxx/xxx/
     * @param sftp sftp协议
     * @return 是否存在
     */
    public static boolean dirExist(final String dir, final ChannelSftp sftp) {
        try {
            Vector<?> vector = sftp.ls(dir);
            if (null == vector)
                return false;
            else
                return true;
        } catch (SftpException e) {
            return false;
        }
    }

    /**
     * 格式化路径.
     * @param srcPath 原路径. /xxx/xxx/xxx.yyy 或 X:/xxx/xxx/xxx.yy
     * @return list, 第一个是路径（/xxx/xxx/）,第二个是文件名（xxx.yy）
     */
    public static List<String> formatPath(final String srcPath) {
        List<String> list = new ArrayList<String>(2);
        String dir = "";
        String fileName = "";
        String repSrc = srcPath.replaceAll("\\\\", "/");
        int firstP = repSrc.indexOf("/");
        int lastP = repSrc.lastIndexOf("/");
        fileName = repSrc.substring(lastP + 1);
        dir = repSrc.substring(firstP, lastP);
        dir = PRE_FIX + (dir.length() == 1 ? dir : (dir + "/"));
        list.add(dir);
        list.add(fileName);
        return list;
    }

    /**
     * 关闭协议-sftp协议.
     * @param sftp sftp连接
     */
    public static void exit(final ChannelSftp sftp) {
        sftp.exit();
    }



    public static void main(String[] args) throws Exception {
        ChannelSftp sftp = getSftpConnect("47.92.73.28", 22, "root", "Wangjun123");

        //判断文件是否存在
        if(dirExist("/tmp/test/123.txt",sftp))





//        String pathString = "C:\\test\\aaa\\Foxmail7.zip";
//        File file = new File(pathString);
//        System.out.println("上传文件开始...");
//        uploadFile(pathString, sftp);
//        System.out.println("上传成功，开始删除本地文件...");
//        file.delete();
//        System.out.println("删除完成，开始校验本地文件...");
//        if (!file.exists()) {
//            System.out.println("文件不存在，开始从远程服务器获取...");
//            download(pathString, pathString, sftp);
//            System.out.println("下载完成");
//        } else {
//            System.out.println("在本地找到文件");
//        }
        exit(sftp);
        System.exit(0);
    }
}

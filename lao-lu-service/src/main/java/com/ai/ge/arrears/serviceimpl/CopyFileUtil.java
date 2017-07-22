package com.ai.ge.arrears.serviceimpl;

import com.ai.ge.platform.service.redis.RedisSpringProxy;
import com.ai.ge.util.CommonUtil;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 17/5/26.
 */
public class CopyFileUtil {

    //枚举类DownloadStatus代码
    public enum DownloadStatus {
        Remote_File_Noexist, //远程文件不存在
        Local_Bigger_Remote, //本地文件大于远程文件
        Download_From_Break_Success, //断点下载文件成功
        Download_From_Break_Failed,   //断点下载文件失败
        Download_New_Success,    //全新下载文件成功
        Download_New_Failed;    //全新下载文件失败
    }
    public FTPClient ftpClient = new FTPClient();


    private String ftpURL,username,pwd,ftpport,remoteFile,localFile;
    private RedisSpringProxy redisSpringProxy;

    public CopyFileUtil(FTPClient ftpClient, String ftpURL, String username, String pwd, String ftpport, String remoteFile, String localFile, RedisSpringProxy redisSpringProxy) {
        this.ftpClient = ftpClient;
        this.ftpURL = ftpURL;
        this.username = username;
        this.pwd = pwd;
        this.ftpport = ftpport;
        this.remoteFile = remoteFile;
        this.localFile = localFile;
        this.redisSpringProxy = redisSpringProxy;
    }

    public boolean connect(String hostname,int port,String username,String password) throws IOException {
        ftpClient.connect(hostname, port);
        ftpClient.setControlEncoding("GBK");
        if(FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){
            if(ftpClient.login(username, password)){
                return true;
            }
        }
        disconnect();
        return false;
    }

    public DownloadStatus download(String remote,String local) throws IOException{
        //设置被动模式
        ftpClient.enterLocalPassiveMode();
        //设置以二进制方式传输
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        DownloadStatus result;

        //检查远程文件是否存在
        FTPFile[] files = ftpClient.listFiles(new String(remote.getBytes("GBK"),"iso-8859-1"));
        if(files.length != 1){
            System.out.println("远程文件不存在");
            return DownloadStatus.Remote_File_Noexist;
        }
        long lRemoteSize = files[0].getSize();
        File f = new File(local);
        //本地存在文件，进行断点下载
        if(f.exists()){
            long localSize = f.length();
            //判断本地文件大小是否大于远程文件大小
            if(localSize >= lRemoteSize){
                System.out.println("本地文件大于远程文件，下载中止");
                return DownloadStatus.Local_Bigger_Remote;
            }
            //进行断点续传，并记录状态
            FileOutputStream out = new FileOutputStream(f,true);
            ftpClient.setRestartOffset(localSize);
            InputStream in = ftpClient.retrieveFileStream(new String(remote.getBytes("GBK"),"iso-8859-1"));
            byte[] bytes = new byte[1024];
            long step = lRemoteSize /100;
            long process=localSize /step;
            int c;
            while((c = in.read(bytes))!= -1){
                out.write(bytes,0,c);
                localSize+=c;
                long nowProcess = localSize /step;
                if(nowProcess > process){
                    process = nowProcess;
                    if(process % 10 == 0)
                        System.out.println("下载进度："+process);
                    //TODO 更新文件下载进度,值存放在process变量中
                }
            }
            in.close();
            out.close();
            boolean isDo = ftpClient.completePendingCommand();
            if(isDo){
                result = DownloadStatus.Download_From_Break_Success;
            }else {
                result = DownloadStatus.Download_From_Break_Failed;
            }
        }else {
            OutputStream out = new FileOutputStream(f);
            InputStream in= ftpClient.retrieveFileStream(new String(remote.getBytes("GBK"),"iso-8859-1"));
            byte[] bytes = new byte[1024];
            long step = lRemoteSize /100;
            long process=0;
            long localSize = 0L;
            int c;
            while((c = in.read(bytes))!= -1){
                out.write(bytes, 0, c);
                localSize+=c;
                long nowProcess = localSize /step;
                if(nowProcess > process){
                    process = nowProcess;
                    if(process % 10 == 0)
                        System.out.println("下载进度："+process);
                    //TODO 更新文件下载进度,值存放在process变量中
                }
            }
            in.close();
            out.close();
            boolean upNewStatus = ftpClient.completePendingCommand();
            if(upNewStatus){
                result = DownloadStatus.Download_New_Success;
            }else {
                result = DownloadStatus.Download_New_Failed;
            }
        }
        return result;
    }

    public void disconnect() throws IOException{
        if(ftpClient.isConnected()){
            ftpClient.disconnect();
        }
    }


    public void continueDownload() throws Exception{
       connect(ftpURL, Integer.parseInt(ftpport), username, pwd);
       download(remoteFile, localFile);
       disconnect();
    }



    /**
     * @param path
     * @return function:读取指定目录下的文件名
     * @throws IOException
     */
    public List<String> getFileList(String path) throws Exception{
        connect(ftpURL, Integer.parseInt(ftpport), username, pwd);
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
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
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
}

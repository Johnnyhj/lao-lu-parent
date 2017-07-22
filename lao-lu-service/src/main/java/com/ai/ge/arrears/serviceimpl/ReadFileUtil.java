package com.ai.ge.arrears.serviceimpl;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Sam on 17/5/27.
 */
public class ReadFileUtil {

    public static void main(String[] args) throws IOException {
        int f = 1000%90==0?1000/90:1+1000/90;
//        splitTxtLagre(90,f,"/Users/Sam/Downloads/tttt/20170528.txt","/Users/Sam/Downloads/tttt/20170528-");
    }


    // 当逐行读写大于2G的文本文件时推荐使用以下代码
    public static void largeFileIO(String inputFile, String outputFile) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(inputFile)));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);// 10M缓存
            FileWriter fw = new FileWriter(outputFile);
            while (in.ready()) {
                String line = in.readLine();
                fw.append(line + " ");
            }
            in.close();
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void splitTxtLagre(int count,String splitFile,String filepath,String filename) {
        long start = System.currentTimeMillis();
        try {
            File file =  new File(filepath);
            if(!file.exists()){
                file.mkdir();
            }

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(splitFile)));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);// 10M缓存
//            FileReader read = new FileReader(splitFile);
//            BufferedReader br = new BufferedReader(read);
            String row;

            List<FileWriter> flist = new ArrayList<FileWriter>();
//            for (int i = 0; i <filecount; i++) {
//                flist.add(new FileWriter(filepath +filename+ i + ".txt"));
//            }
            int rownum = 1;
            while ((row = in.readLine()) != null) {
                int  f=rownum%count==0?rownum/count:1+rownum/count;
                if(rownum%count==1){
                    flist.add(new FileWriter(filepath +filename+ rownum/count + ".txt"));
                }
                flist.get(f-1).append(row + "\r\n");
                if(rownum%count==0){
                    flist.get(f-1).close();
                }
                rownum++;
            }

//            int rownum = 1;// 计数器
//            while ((row = in.readLine()) != null) {
//                flist.get(rownum % count).append(row + "\r\n");
//                rownum++;
//            }
//            for (int i = 0; i < flist.size(); i++) {
//                flist.get(i).close();
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long c = end-start;
        System.out.println("耗时："+c+"ms");
    }


    public static int getFileLineCounts(String filename) {
        int cnt = 0;
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(filename));
            byte[] c = new byte[1024];
            int readChars = 0;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++cnt;
                    }
                }
            }
        } catch (Exception ex) {
            cnt = -1;
            ex.printStackTrace();
        } finally {
            try {
                if (null != is)
                {
                    is.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    }

    public static void splitTxt(int count,String splitFile,String filepath) {
        long start = System.currentTimeMillis();
        try {
            FileReader read = new FileReader(splitFile);
            BufferedReader br = new BufferedReader(read);
            String row;
            List<FileWriter> flist = new ArrayList<FileWriter>();
            for (int i = 0; i < count; i++) {
                flist.add(new FileWriter(filepath + i + ".txt"));
            }
            int rownum = 1;// 计数器
            while ((row = br.readLine()) != null) {
                flist.get(rownum % count).append(row + "\r\n");
                rownum++;
            }
            for (int i = 0; i < flist.size(); i++) {
                flist.get(i).close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long c = (start-end)/1000;
        System.out.println("耗时："+c);
    }


    public static void test(int nums){
        //
        Integer batchCount = 10000;



    }


}

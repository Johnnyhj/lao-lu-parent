package com.test;

import com.ai.ge.platform.serviceimpl.http.bill.BillPerformanceHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.crm.CrmOrderCompleteHttpResponseObject;
import com.ai.ge.platform.serviceimpl.http.zhima.request.BatchFeedback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import junit.framework.TestCase;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by suixuan on 17/5/26.
 */
public class MyTest extends TestCase {

    public void testRandom() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(2));
        }
    }


    public void testCRMCompleteJson() {
        String json = "{\n" +
                "\t\"result_code\":\"0\",\n" +
                "\t\"object\" : [\n" +
                "\t\t{\n" +
                "\t\t\t\"phone_number\":\"18000000000\",\n" +
                "\t\t\t\"ol_nbr\":\"88888888\",\n" +
                "\t\t\t\"complate_time\":\"2017-05-05 12:12:12\",\n" +
                "\t\t\t\"valid_time\":\"2017-05-05 12:12:12\",\n" +
                "\t\t\t\"create_time\":\"2017-05-05 12:12:12\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"phone_number\":\"18100011000\",\n" +
                "\t\t\t\"ol_nbr\":\"99999999\",\n" +
                "\t\t\t\"complate_time\":\"2017-05-05 12:12:12\",\n" +
                "\t\t\t\"valid_time\":\"2017-05-05 12:12:12\",\n" +
                "\t\t\t\"create_time\":\"2017-05-05 12:12:12\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        CrmOrderCompleteHttpResponseObject httpResponseObject = JSON.parseObject(json, CrmOrderCompleteHttpResponseObject.class);

        System.out.println(httpResponseObject);
    }

    public void testBillPerformanceJson() {
        String json = "{\n" +
                "\t\"result_code\":\"0\",\n" +
                "\t\"object\" : [\n" +
                "\t\t{\n" +
                "\t\t\t\"phone_number\":\"18000000000\",\n" +
                "\t\t\t\"is_credit\":\"Y\",\n" +
                "\t\t\t\"cost\":\"299\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"phone_number\":\"18100011000\",\n" +
                "\t\t\t\"is_credit\":\"N\",\n" +
                "\t\t\t\"cost\":\"299\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        BillPerformanceHttpResponseObject httpResponseObject = JSON.parseObject(json, BillPerformanceHttpResponseObject.class);

        System.out.println(httpResponseObject);
    }


    public void testReadZhimaOrderConfirmHttpResponseObject() throws IOException {
        String filePath = "/Users/suixuan/Downloads/src/芝麻信用商家服务平台副本.txt";

        List<String> texts = IOUtils.readLines(new FileInputStream(filePath), CharEncoding.UTF_8);
        for (String text : texts) {
            text = text.trim();
            if (StringUtils.isBlank(text)) {
                continue;
            }
            String[] textArray = text.split(" ");

            StringBuilder outputText = new StringBuilder("/**\n");
            outputText.append("*" + textArray[3] + "\n");
            outputText.append("*/");
            outputText.append("\n");
            outputText.append("private String " + textArray[0] + ";");

            System.out.println(outputText);

        }

    }


    /**
     * 拆分同样大小的文件
     */
    public void testSplitLengthFiles() throws IOException {
        List<BatchFeedback> batchFeedbacks = new ArrayList<BatchFeedback>();

        for (int i = 0; i < 10000; i++) {
            BatchFeedback bf = new BatchFeedback();
            bf.setBizDate("2016-02-06");
            bf.setUserCredentialsType("0");
            bf.setUserCredentialsNo("283992829383728372");
            bf.setUserName("张三");
            bf.setOrderNo("201602050099");
            bf.setPhoneNo("1XX12345678");
            bf.setOrderStartDate("2016-01-01");
            bf.setOrderEndDate("2016-01-01");
            bf.setOrderStatus("1");
            bf.setBillNo("3");
            bf.setBillInstallment("201603");
            bf.setBillDesc("账单");
            bf.setBillType("111");
            bf.setBillAmt("200");
            bf.setBillLastDate("2016-04-25");
            bf.setBillStatus("0");
            bf.setBillPayoffDate("2016-04-19");
            bf.setBillTypeOvdAmt("38");
            bf.setBillTypeOvdDate("2016-02-25");

            batchFeedbacks.add(bf);
        }


        BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("/Users/suixuan/Downloads/src/1.json"));
        for (BatchFeedback batchFeedback : batchFeedbacks) {
            IOUtils.write(JSON.toJSONString(batchFeedback, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty), bw, CharEncoding.UTF_8);
            IOUtils.write("\n", bw);
        }

        IOUtils.closeQuietly(bw);


    }


    public void testFileToMultiple() throws IOException {
        //分割成1M
        int length = 0, maxlength = 1024 * 1024 * 1;
        String directory = "/Users/suixuan/Downloads/src";
        int multiple = 1;


        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(directory + "/1.json"));
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(directory + "/1.1.json"));
        LineIterator iterator = IOUtils.lineIterator(inputStream, CharEncoding.UTF_8);

        String header = "{\n" +
                "    \"records\": [";
        String foot = "]\n" +
                "}";

        IOUtils.write(header, outputStream, CharEncoding.UTF_8);

        while (iterator.hasNext()) {
            String lineText = iterator.nextLine();
            length += lineText.length();
            if (length >= maxlength) {
                IOUtils.write("\n", outputStream, CharEncoding.UTF_8);
                IOUtils.write(foot, outputStream, CharEncoding.UTF_8);
                outputStream.flush();

                length = 0;
                multiple++;
                outputStream = new BufferedOutputStream(new FileOutputStream(directory + "/1." + multiple + ".json"));
                IOUtils.write(header, outputStream, CharEncoding.UTF_8);
            }

            if (0 != length) {
                IOUtils.write(",", outputStream, CharEncoding.UTF_8);
            }
            IOUtils.write(lineText, outputStream, CharEncoding.UTF_8);
            IOUtils.write("\n", outputStream, CharEncoding.UTF_8);
        }

        IOUtils.write("\n", outputStream, CharEncoding.UTF_8);
        IOUtils.write(foot, outputStream, CharEncoding.UTF_8);

        IOUtils.closeQuietly(outputStream);
        IOUtils.closeQuietly(inputStream);


    }


    public void testSeparator() {
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }


    public void test16Hax() {
        System.out.println(0x300000);
        System.out.println(0x3000);
    }

}

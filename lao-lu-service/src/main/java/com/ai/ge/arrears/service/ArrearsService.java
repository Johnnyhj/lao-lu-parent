package com.ai.ge.arrears.service;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by Sam on 17/5/24.
 */
public interface ArrearsService {

    void scanArrearslist(String s) throws IOException, ParseException,Exception;

    void actuator(String arrearsString,String redisFlag);

    void resetArrears(Integer status);

    int getFileNumbers(String filepath);

    int splitLargeFile(String filepath,Integer lineNumbers,String filename);

    void transfer();
}

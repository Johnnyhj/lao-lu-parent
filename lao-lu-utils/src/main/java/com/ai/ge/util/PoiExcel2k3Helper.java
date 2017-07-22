package com.ai.ge.util;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Excel 读取（97-2003格式）
 *
 * @author chengesheng
 * @date 2012-4-27 下午03:39:01
 * @note PoiExcel2k3Helper
 */
public class PoiExcel2k3Helper extends PoiExcelHelper {
    /**
     * 获取sheet列表
     */
    public ArrayList<String> getSheetList(InputStream inputStream) throws IOException {
        ArrayList<String> sheetList = new ArrayList<String>(0);

        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        int i = 0;
        while (true) {
            try {
                String name = wb.getSheetName(i);
                sheetList.add(name);
                i++;
            } catch (Exception e) {
                break;
            }
        }

        return sheetList;
    }

    /**
     * 读取Excel文件内容
     */
    public ArrayList<ArrayList<String>> readExcel(InputStream inputStream, int sheetIndex, String rows, String
            columns) throws IOException {
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();

        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheetAt(sheetIndex);

        dataList = readExcel(sheet, rows, getColumnNumber(sheet, columns));

        return dataList;
    }

    /**
     * 读取Excel文件内容
     */
    public ArrayList<ArrayList<String>> readExcel(InputStream inputStream, int sheetIndex, String rows, int[] cols)
            throws IOException {
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();

        HSSFWorkbook wb = new HSSFWorkbook(inputStream);
        HSSFSheet sheet = wb.getSheetAt(sheetIndex);

        dataList = readExcel(sheet, rows, cols);

        return dataList;
    }
} 
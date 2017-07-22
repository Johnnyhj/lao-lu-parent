package com.ai.ge.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Excel 读取（2007+新格式）
 *
 * @author chengesheng
 * @date 2012-4-27 下午03:39:01
 * @note PoiExcel2k7Helper
 */
public class PoiExcel2k7Helper extends PoiExcelHelper {
    /**
     * 获取sheet列表
     */
    public ArrayList<String> getSheetList(InputStream inputStream) throws IOException {
        ArrayList<String> sheetList = new ArrayList<String>(0);

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        Iterator<XSSFSheet> iterator = wb.iterator();
        while (iterator.hasNext()) {
            sheetList.add(iterator.next().getSheetName());
        }

        return sheetList;
    }

    /**
     * 读取Excel文件内容
     */
    public ArrayList<ArrayList<String>> readExcel(InputStream inputStream, int sheetIndex, String rows, String
            columns) throws IOException {
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheetAt(sheetIndex);

        dataList = readExcel(sheet, rows, getColumnNumber(sheet, columns));

        return dataList;
    }

    /**
     * 读取Excel文件内容
     */
    public ArrayList<ArrayList<String>> readExcel(InputStream inputStream, int sheetIndex, String rows, int[] cols)
            throws IOException {
        ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();

        XSSFWorkbook wb = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = wb.getSheetAt(sheetIndex);

        dataList = readExcel(sheet, rows, cols);

        return dataList;
    }
}
package com.ai.ge.util;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.PicturesTable;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.xmlbeans.impl.piccolo.io.FileFormatException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * @version v1.0
 * @Description: 利用poi将word简单的转换成html文件
 */
public class word2Html {
    /**
     * 回车符ASCII码
     */
    private static final short ENTER_ASCII = 13;

    /**
     * 空格符ASCII码
     */
    private static final short SPACE_ASCII = 32;

    /**
     * 水平制表符ASCII码
     */
    private static final short TABULATION_ASCII = 9;

    private static String htmlText = "";
    private static String htmlTextTbl = "";
    private static int counter = 0;
    private static int beginPosi = 0;
    private static int endPosi = 0;
    private static int beginArray[];
    private static int endArray[];
    private static String htmlTextArray[];
    private static boolean tblExist = false;

    /**
     * 项目路径
     */
    private static String projectRealPath = "";
    /**
     * 临时文件路径
     */
    private static String tempPath = "E:\\" + File.separator + "testWordHtml" + File.separator;
    /**
     * word文档名称
     */
    private static String wordName = "";

    public static void main(String argv[]) {
        try {
            wordToHtml("E:\\详细设计说明书v1.1.doc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取每个文字样式
     *
     * @param fileName
     * @throws Exception
     */

    private static void getWordAndStyle(String fileName) throws Exception {
        FileInputStream in = new FileInputStream(new File(fileName));
        HWPFDocument doc = new HWPFDocument(in);

        Range rangetbl = doc.getRange();// 得到文档的读取范围
        TableIterator it = new TableIterator(rangetbl);

        int num = 100;

        beginArray = new int[num];
        endArray = new int[num];
        htmlTextArray = new String[num];
        tblExist = false;

        // 取得文档中字符的总数
        int length = doc.characterLength();
        // 创建图片容器
        PicturesTable pTable = doc.getPicturesTable();
        // 创建段落容器

        htmlText = "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><title>"
                + doc.getSummaryInformation().getTitle()
                + "</title></head><body><div style='margin:60px;text-align:center;'><div style='width:620px;text-align:left;line-height:24px;'>";
        // 创建临时字符串,好加以判断一串字符是否存在相同格式

        if (it.hasNext()) {
            readTable(it, rangetbl);
        }

        int cur = 0;
        String tempString = "";
        for (int i = 0; i < length - 1; i++) {
            // 整篇<span class="wp_keywordlink"><a target=_blank href="http://www.it-crazy.com/" title="文章" target="_blank">文章</a></span>的字符通过一个个字符的来判断,range为得到文档的范围
            Range range = new Range(i, i + 1, doc);
            CharacterRun cr = range.getCharacterRun(0);
            // beginArray=new int[num];
            // endArray=new int[num];
            // htmlTextArray=new String[num];
            if (tblExist) {
                if (i == beginArray[cur]) {
                    htmlText += tempString + htmlTextArray[cur];
                    tempString = "";
                    i = endArray[cur] - 1;
                    cur++;
                    continue;
                }
            }
            if (pTable.hasPicture(cr)) {
                htmlText += tempString;
                // 读写图片
                try {
                    readPicture(pTable, cr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                tempString = "";
            } else {

                Range range2 = new Range(i + 1, i + 2, doc);
                // 第二个字符
                CharacterRun cr2 = range2.getCharacterRun(0);
                char c = cr.text().charAt(0);
                // System.out.println(c);
                // /System.out.println(i+"::"+range.getEndOffset()+"::"+range.getStartOffset()+"::"+c);

                // 判断是否为回车符
                if (c == ENTER_ASCII) {
                    tempString += "<br/>";
                }
                // 判断是否为空格符
                else if (c == SPACE_ASCII)
                    tempString += " ";
                    // 判断是否为水平制表符
                else if (c == TABULATION_ASCII)
                    tempString += "    ";
                // 比较前后2个字符是否具有相同的格式
                boolean flag = compareCharStyle(cr, cr2);
                if (flag)
                    tempString += cr.text();
                else {
                    String fontStyle = "<span style=\"font-family:" + cr.getFontName() + ";font-size:"
                            + cr.getFontSize() / 2 + "pt;";

                    if (cr.isBold())
                        fontStyle += "font-weight:bold;";
                    if (cr.isItalic())
                        fontStyle += "font-style:italic;";
                    if (cr.isStrikeThrough())
                        fontStyle += "text-decoration:line-through;";

                    int fontcolor = cr.getIco24();
                    int[] rgb = new int[3];
                    if (fontcolor != -1) {
                        rgb[0] = (fontcolor >> 0) & 0xff; // red;
                        rgb[1] = (fontcolor >> 8) & 0xff; // green
                        rgb[2] = (fontcolor >> 16) & 0xff; // blue
                    }
                    fontStyle += "color: rgb(" + rgb[0] + "," + rgb[1] + "," + rgb[2] + ");";
                    htmlText += fontStyle + "\">" + tempString + cr.text() + "</span>";
                    tempString = "";
                }
            }
        }

        htmlText += tempString + "</div></div></body></html>";
        // System.out.println(htmlText);
    }

    /**
     * 读写文档中的表格
     *
     * @throws Exception
     */
    private static void readTable(TableIterator it, Range rangetbl) throws Exception {

        htmlTextTbl = "";
        // 迭代文档中的表格

        counter = -1;
        while (it.hasNext()) {
            tblExist = true;
            htmlTextTbl = "";
            Table tb = (Table) it.next();
            beginPosi = tb.getStartOffset();
            endPosi = tb.getEndOffset();

            // System.out.println("............"+beginPosi+"...."+endPosi);
            counter = counter + 1;
            // 迭代行，默认从0开始
            beginArray[counter] = beginPosi;
            endArray[counter] = endPosi;

            htmlTextTbl += "<table border='1' cellpadding='0' cellspacing='0' >";
            for (int i = 0; i < tb.numRows(); i++) {
                TableRow tr = tb.getRow(i);

                htmlTextTbl += "<tr align='center'>";
                // 迭代列，默认从0开始
                for (int j = 0; j < tr.numCells(); j++) {
                    TableCell td = tr.getCell(j);// 取得单元格
                    int cellWidth = td.getWidth();

                    // 取得单元格的内容
                    for (int k = 0; k < td.numParagraphs(); k++) {
                        Paragraph para = td.getParagraph(k);
                        CharacterRun crTemp = para.getCharacterRun(0);
                        String fontStyle = "<span style=\"font-family:" + crTemp.getFontName() + ";font-size:"
                                + crTemp.getFontSize() / 2 + "pt;color:" + crTemp.getColor() + ";";

                        if (crTemp.isBold())
                            fontStyle += "font-weight:bold;";
                        if (crTemp.isItalic())
                            fontStyle += "font-style:italic;";

                        String s = fontStyle + "\">" + para.text().toString().trim() + "</span>";
                        if (s == "") {
                            s = " ";
                        }
                        // System.out.println(s);
                        htmlTextTbl += "<td width=" + cellWidth + ">" + s + "</td>";
                        // System.out.println(i + ":" + j + ":" + cellWidth + ":" + s);
                    } // end for
                } // end for
            } // end for
            htmlTextTbl += "</table>";
            htmlTextArray[counter] = htmlTextTbl;

        } // end while
    }

    /**
     * 读写文档中的图片
     *
     * @param pTable
     * @param cr
     * @throws Exception
     */
    private static void readPicture(PicturesTable pTable, CharacterRun cr) throws Exception {
        // 提取图片
        Picture pic = pTable.extractPicture(cr, false);
        BufferedImage image = null;// 图片对象
        // 获取图片样式
        int picHeight = pic.getHeight() * pic.getAspectRatioY() / 100;
        int picWidth = pic.getAspectRatioX() * pic.getWidth() / 100;
        if (picWidth > 500) {
            picHeight = 500 * picHeight / picWidth;
            picWidth = 500;
        }
        String style = " style='height:" + picHeight + "px;width:" + picWidth + "px'";

        // 返回POI建议的图片文件名
        String afileName = pic.suggestFullFileName();
        //单元测试路径
        String directory = "images/" + wordName + "/";
        //项目路径
        //String directory = tempPath + "images/" + wordName + "/";
        makeDir(tempPath, directory);// 创建文件夹

        int picSize = cr.getFontSize();
        int myHeight = 0;

        if (afileName.indexOf(".wmf") > 0) {
            OutputStream out = new FileOutputStream(new File(tempPath + directory + afileName));
            out.write(pic.getContent());
            out.close();
            afileName = Wmf2Png.convert(tempPath + directory + afileName);

            File file = new File(tempPath + directory + afileName);

            try {
                image = ImageIO.read(file);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int pheight = image.getHeight();
            int pwidth = image.getWidth();
            if (pwidth > 500) {
                htmlText += "<img style='width:" + pwidth + "px;height:" + myHeight + "px'" + " src=\"" + directory
                        + afileName + "\"/>";
            } else {
                myHeight = (int) (pheight / (pwidth / (picSize * 1.0)) * 1.5);
                htmlText += "<img style='vertical-align:middle;width:" + picSize * 1.5 + "px;height:" + myHeight
                        + "px'" + " src=\"" + directory + afileName + "\"/>";
            }

        } else {
            OutputStream out = new FileOutputStream(new File(tempPath + directory + afileName));
            // pic.writeImageContent(out);
            out.write(pic.getContent());
            out.close();
            // 处理jpg或其他（即除png外）
            if (afileName.indexOf(".png") == -1) {
                try {
                    File file = new File(tempPath + directory + afileName);
                    image = ImageIO.read(file);
                    picHeight = image.getHeight();
                    picWidth = image.getWidth();
                    if (picWidth > 500) {
                        picHeight = 500 * picHeight / picWidth;
                        picWidth = 500;
                    }
                    style = " style='height:" + picHeight + "px;width:" + picWidth + "px'";
                } catch (Exception e) {
                    // e.printStackTrace();
                }
            }
            htmlText += "<img " + style + " src=\"" + directory + afileName + "\"/>";
        }
        if (pic.getWidth() > 450) {
            htmlText += "<br/>";
        }
    }

    private static boolean compareCharStyle(CharacterRun cr1, CharacterRun cr2) {
        boolean flag = false;
        if (cr1.isBold() == cr2.isBold() && cr1.isItalic() == cr2.isItalic()
                && cr1.getFontName().equals(cr2.getFontName()) && cr1.getFontSize() == cr2.getFontSize()) {
            flag = true;
        }
        return flag;
    }

    /**
     * 写文件（成功返回true，失败则返回false）
     *
     * @param s        要写入的内容
     * @param filePath 文件
     */
    private static boolean writeFile(String s, String filePath) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        s = s.replaceAll("EMBED", "").replaceAll("Equation.DSMT4", "");
        try {
            makeDir(projectRealPath, tempPath);// 创建文件夹
            File file = new File(filePath);
            if (file.exists()) {
                return false;
            }
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
            bw.write(s);
            // System.out.println(filePath + "文件写入成功！");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fos != null)
                    fos.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        return true;
    }

    /**
     * 根据路径名生成多级路径
     *
     * @param url 参数要以"\classes\cn\qtone\"或者"/classes/cn/qtone/"
     */
    private static String makeDir(String root, String url) {
        String[] sub;
        url = url.replaceAll("\\/", "\\\\");
        if (url.indexOf("\\") > -1) {
            sub = url.split("\\\\");
        } else {
            return "-1";
        }

        File dir = null;
        try {
            dir = new File(root);
            for (int i = 0; i < sub.length; i++) {
                if (!dir.exists() && !sub[i].equals("")) {
                    dir.mkdir();
                }
                File dir2 = new File(dir + File.separator + sub[i]);
                if (!dir2.exists()) {
                    dir2.mkdir();
                }
                dir = dir2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "-1";
        }
        return dir.toString();
    }


    public static String wordToHtml(String url) {
        // projectRealPath = projectPath;// 项目路径
        // String filePath = "";
        // System.out.println(projectRealPath + tempPath);
        // System.out.println(makeDir(projectRealPath, tempPath));
        try {
            File file = new File(url);
            if (file.exists()) {
                if (file.getName().indexOf(".doc") == -1 || file.getName().indexOf(".docx") > 0) {
                    throw new FileFormatException("请确认文件格式为doc!");
                } else {
                    /*synchronized (url) {// 处理线程同步问题
                    }*/
                    getWordAndStyle(url);
                }
            } else {
                throw new FileNotFoundException("没找到相关文件！");
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writeFile(htmlText,"E:\\test.html");
        return htmlText;
    }
}

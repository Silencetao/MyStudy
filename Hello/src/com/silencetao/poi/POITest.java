package com.silencetao.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * POI测试
 * @author Silence
 * create time 2017年12月8日 下午2:36:07
 * @version 1.0.1
 */
public class POITest {

    public static void main(String[] args) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("成绩单");
        
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell = row0.createCell(0);
        cell.setCellValue("学员成绩一览表");
        
        //表格样式
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //设置为居中
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell.setCellStyle(cellStyle);
        
        /*
         * 合并单元格
         * CellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol);
         */
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("姓名");
        row1.createCell(1).setCellValue("班级");
        row1.createCell(2).setCellValue("笔试成绩");
        row1.createCell(3).setCellValue("机试成绩");
        
        HSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("张三");
        row2.createCell(1).setCellValue("网工4班");
        row2.createCell(2).setCellValue("89");
        row2.createCell(3).setCellValue("90");
        
        HSSFRow row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("李四");
        row3.createCell(1).setCellValue("网工4班");
        row3.createCell(2).setCellValue("79");
        row3.createCell(3).setCellValue("80");
        
        FileOutputStream output = new FileOutputStream("poi/score.xls");
        wb.write(output);
    }
}

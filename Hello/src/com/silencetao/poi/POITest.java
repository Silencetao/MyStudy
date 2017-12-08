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
 * POI����
 * @author Silence
 * create time 2017��12��8�� ����2:36:07
 * @version 1.0.1
 */
public class POITest {

    public static void main(String[] args) throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("�ɼ���");
        
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell cell = row0.createCell(0);
        cell.setCellValue("ѧԱ�ɼ�һ����");
        
        //�����ʽ
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //����Ϊ����
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cell.setCellStyle(cellStyle);
        
        /*
         * �ϲ���Ԫ��
         * CellRangeAddress(int firstRow, int lastRow, int firstCol, int lastCol);
         */
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
        
        HSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("����");
        row1.createCell(1).setCellValue("�༶");
        row1.createCell(2).setCellValue("���Գɼ�");
        row1.createCell(3).setCellValue("���Գɼ�");
        
        HSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("����");
        row2.createCell(1).setCellValue("����4��");
        row2.createCell(2).setCellValue("89");
        row2.createCell(3).setCellValue("90");
        
        HSSFRow row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue("����");
        row3.createCell(1).setCellValue("����4��");
        row3.createCell(2).setCellValue("79");
        row3.createCell(3).setCellValue("80");
        
        FileOutputStream output = new FileOutputStream("poi/score.xls");
        wb.write(output);
    }
}

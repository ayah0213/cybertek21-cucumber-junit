package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    XSSFRow row;


    @Test
    public void excel_write() throws IOException {

        String path = "SampleDate.xlsx";
        FileInputStream fileInputStream= new FileInputStream(path);

        // HYRIERACHHY  = workbook -> sheet -> sheet-> cell

        // to be able to reach CELL we need to start with Workbook
        workbook = new XSSFWorkbook(fileInputStream);

        // open the sheet using workbook object
        sheet = workbook.getSheet("Employees");

        // king's row
        row = sheet.getRow(1); // return me whole row

        // king's cell
        cell = row.getCell(1); // returns me King


        // Ex: String Adam's name cell if we were to be re-using it
        XSSFCell adamCell=sheet.getRow(2).getCell(0);
        System.out.println(" adamCell Before = " + adamCell.toString());
        // now we're changing Adam to Madam
        adamCell.setCellValue("Madam");
        System.out.println("adamCell after = " + adamCell);
        System.out.println("============================================");

        // TODO : Chnage Steven's name into to TOM
        /*
        STATIC  way of the solution
        exactly cell and directly pass into the cell
         */
         // XSSFCell stevensCell = sheet.getRow(1).getCell(0);
        // stevensCell.setCellValue("Tom");
         // System.out.println("stevensCell = " + stevensCell);

/*
              DYNAMIC way of solution how to change TOM TO STEVEN
 */
        for (int rowNum = 0; rowNum < sheet.getPhysicalNumberOfRows() ; rowNum++) {
                if (sheet.getRow(rowNum).getCell(0).toString().equalsIgnoreCase("steven")){
                    sheet.getRow(rowNum).getCell(0).setCellValue("TOM");
                }
        }



        //=======================================================
        //Load the file to outputStream
        FileOutputStream fileOutputStream= new FileOutputStream(path);
        // write to the file using workbook object
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();



    }
}

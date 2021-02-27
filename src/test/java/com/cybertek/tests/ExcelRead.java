package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {


    /*
    In this test we will be reading from excell file
     */
    @Test
    public void excel_read_test() throws IOException {




        // STRUCTURE HOW TO READ FROM EXCEL SHEET WITH APACHE-POI




        // copying Content Root of our ExcelFile from path and paste it into String
        String path = "SampleDate.xlsx" ;

        // to be able to read from excell file w need to load the file
        FileInputStream fileInputStream = new FileInputStream(path);

        // We re gonna get our --> workbook sheet > row > cell--> by using ApachePoi
        //We created Workbook nstance and loaded with Sample DAta file
        XSSFWorkbook workbook= new XSSFWorkbook(fileInputStream);

        // create the sheet and paste the name of sheet we want to work on
        XSSFSheet sheet = workbook.getSheet("Employees");

        // Row-->Sheet
        // Print out "Steve" from ExcelSheet
        System.out.println( sheet.getRow(1).getCell(0));

        // print out "Singer"
        System.out.println(sheet.getRow(3).getCell(2));


        // new Method which returns the counts of used cell only
        // if there are cells not used they will not be counted
        // Starts from counting 1
        // this method used for get the collumns cell which only used once, it wil skip the ones that EMPTY on Excel Sheet
        int usedRows  = sheet.getPhysicalNumberOfRows();



        // this one returns the counts from top to bottom
        // Even counts if there are empty cell
        // start counting from 0
        int lastUsedRow= sheet.getLastRowNum();


        //TODO: Create a logic to print out NEENA'S NAME Dynamically
         //   1)-iterating through EachRAw = i(EachRAw)

        //    2)- initializing my boundaries which comes after < (usedRows)
         //      int usedRows  = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            //usualy it return cell value, to be able to return String and compare we .toString(). method
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println("Current Cell: "+sheet.getRow(rowNum).getCell(0));
            }
            /*
               /*
             // to make it reusable

             for (int rowNum = 0; rowNum < usedRows; rowNum++) {

            XSSFCell currentCell=sheet.getRow(rowNum).getCell(0);

            //usualy it return cell value, to be able to return String and compare we .toString(). method
            if (currentCell.toString().equals("Neena")){
                System.out.println("Current Cell: "+currentCell);

            }
             */

        }



        // TODO: Create a logic to print Adam Sandler's last Name dynamically

        for (int rowNum = 0; rowNum < usedRows ; rowNum++) {
            XSSFCell sandler= sheet.getRow(rowNum).getCell(1);

            if (sandler.toString().equals("Sandler")){
                System.out.println("Adam's last name is =  "+ sandler);
            }
        }

        //TODO: create logic to print out STEVEN KINGS JOB ID DYNAMICALLY
        // if it is KING then print out his JOBID
        for (int rownum = 0; rownum < usedRows; rownum++) {
            XSSFCell steveAlstanme = sheet.getRow(rownum).getCell(1);

            if (steveAlstanme.toString().equalsIgnoreCase("king")){
                System.out.println("Steve JOb ID = " + sheet.getRow(rownum).getCell(2));
            }
            }
        }











    }


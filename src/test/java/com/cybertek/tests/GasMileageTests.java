package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {


    XSSFWorkbook workbook;
    XSSFSheet sheet;
  FileInputStream fileInputStream;
  FileOutputStream fileOutputStream;

  GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

   @Test
    public void gas_mileage_calculation() throws IOException {


       // Inputtiong using EXCELL Sheet APache Poi
       Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
       String path= "src/test/resources/TestData/GasMileageTestData.xlsx";

       //loading the file into fileInputStream object
       fileInputStream= new FileInputStream(path);

       //loading Workbook to the class
       workbook= new XSSFWorkbook(fileInputStream);

       // opening the sheet
       sheet= workbook.getSheet("Sheet1");



       // CREATING SO THAT WHOLE EXCELL SHEET WILL BE READING BY ITSELF INSIDE OF LOOP
       for (int rowNum = 1; rowNum < sheet.getLastRowNum() ; rowNum++) {

           // 1st step creating Row
           XSSFRow currentRow = sheet.getRow(rowNum); //here-> we saying go and get each row and check inside and create


           // THIS CONDITION WILL COME TO EXCELL SHEET AND CHECK ONLY "yes" ONES
           if (!currentRow.getCell(0).toString().equals("Y")) {

               // we re saying for "NO" ones SKIPE REQUESTED
               if (currentRow.getCell(6) == null) {
                   currentRow.createCell(6);
               }
               currentRow.getCell(6).setCellValue("SKIP REQUESTED");
               continue;// AND IGNORE-SKIP  "no" ONES
           }

           //inputting from EXCEL SHEET
           double current = currentRow.getCell(1).getNumericCellValue();
           //double current= 123000;---> Inputing manually
           // clearing any data before putting new

          // BrowserUtils.waitForClickability(gasMileageCalculatorPage.inputCurrentOdo,7);

           gasMileageCalculatorPage.inputCurrentOdo.clear();
           // we nee o pass 'double into input box
           gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current)); //passing our current val


           // Entering previous odometer reading
           double previous = currentRow.getCell(2).getNumericCellValue();
           //double previous = 122000;  this was Manually
           gasMileageCalculatorPage.inputPreviousOdo.clear();
           gasMileageCalculatorPage.inputPreviousOdo.sendKeys(String.valueOf(previous));


           // How many galoons of gas we enetering
           double gas = currentRow.getCell(3).getNumericCellValue();// enternally
           //int gas= 70;  this was Manually
           gasMileageCalculatorPage.inputGas.clear();
           gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));

           // click on Claculate button
           gasMileageCalculatorPage.calculateBtn.click();


           //=============================
           // How does the calculation of AVG/MPG works?
           // basicallly : (CURRENT-PREVIOUS) / GAS --> avg/mpg
           double expectedResult = (current - previous) / gas;
           System.out.println("expectedResult = " + expectedResult);


           // actualResult gonna be --> 14.29 mpg --> split " " --> {"14.29","mpg"}
           String[] actualResultArr = gasMileageCalculatorPage.resultInAGs.getText().split(" ");
           System.out.println("actualResultArr = " + actualResultArr[0]);

           // Now we have to round expected DOUBLE result into actual result
           String actual = actualResultArr[0];
           String expected = String.valueOf(expectedResult);


           // for rounding our DOUBLE actual result we gonna use DECIMALFormat'
           DecimalFormat decimalFormat = new DecimalFormat("#0.00");
           String formatterExpected = decimalFormat.format(expectedResult); //returns us String

           System.out.println("formatterExpected = " + formatterExpected);

           //=========
           // passing EXECTED VALUE INTO EXCEL SHEET
           // If the cell is empty  we need to create the cell before being able to  pass
           // any data into it
           if (currentRow.getCell(4) == null) {
               currentRow.createCell(4);
           }
           //passing the 'formattedExpected' into Excel Sheet cell
           currentRow.getCell(4).setCellValue(formatterExpected);

//================================================================================

           if (currentRow.getCell(5) == null) {
               currentRow.createCell(5);
           }
           //passing the 'formattedExpected' into Excel Sheet cell
           currentRow.getCell(5).setCellValue(actual);
           //--------------------------------------------


           // PASSING HE RESULT INTO EXCELL
           if (currentRow.getCell(6) == null) {
               currentRow.createCell(6);
           }

           // COMPARING ACTUAL VS EXPECTED AND PASSING THE RESULT INTO EXCEL SHEET
           if (actual.equals(formatterExpected)) {
               // System.out.println("PASS");
               currentRow.getCell(6).setCellValue("Pass");
           } else {
               //System.out.println("FAIL!!!");
               currentRow.getCell(6).setCellValue("Fail");
           }


           //==================================================================================
           // ENTERING CURRENT TIME WHEN TEST IS RUNNING THAT SPECIFIC LINE
           if (currentRow.getCell(7) == null) {
               currentRow.createCell(7);
           }
           DateTimeFormatter DT = DateTimeFormatter.ofPattern("hh:mm:ss a");
           currentRow.getCell(7).setCellValue(LocalDateTime.now().format(DT));


       }

       ///----------------------------------------------------
       // WE MUST TO WRITE INTO excel file using .write method, otherwise changes will not be applicable
       fileOutputStream = new FileOutputStream(path);
       workbook.write(fileOutputStream);

       workbook.close();
       fileOutputStream.close();
       fileInputStream.close();


   }
}

package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class GasMileageTests {


    XSSFWorkbook workbook;
    XSSFSheet sheet;
  FileInputStream fileInputStream;
  FileOutputStream fileOutputStream;

  GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

   @Test
    public void gas_mileage_calculation() throws IOException {

       Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");
       String path= "src/test/resources/TestData/GasMileageTestData.xlsx";

       //loading the file into fileInputStream object
       fileInputStream= new FileInputStream(path);

       //loading Workbook to the class
       workbook= new XSSFWorkbook(fileInputStream);

       // opening the sheet
       sheet= workbook.getSheet("Sheet1");

       double current= 123000;

       // clearing any data before putting new
       gasMileageCalculatorPage.inputCurrentOdo.clear();
       // we nee o pass 'double into input box
       gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current)); //passing our current val

       //+++++++++++++++++++++++++++++++++++++++++++++++


       // Entering previous odometer reading
       double previous = 122000;
       gasMileageCalculatorPage.inputPreviousOdo.clear();
       gasMileageCalculatorPage.inputPreviousOdo.sendKeys(String.valueOf(previous));


       //+++++++++++++++++++++++++++++++++++++++++++++++

       // How many galoons of gas we enetering
       int gas= 70;
       gasMileageCalculatorPage.inputGas.clear();
       gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));

       //+==================================
       // click on Claculate button
       gasMileageCalculatorPage.calculateBtn.click();


       //=============================
       // How does the calculation of AVG/MPG works?
       // basicallly : (CURRENT-PREVIOUS) / GAS --> avg/mpg

       double expectedResult = (current-previous)/gas;
       System.out.println("expectedResult = " + expectedResult);


       // actualResult gonna be --> 14.29 mpg --> split " " --> {"14.29","mpg"}
     String [] actualResultArr =   gasMileageCalculatorPage.resultInAGs.getText().split(" ");
       System.out.println("actualResultArr = " + actualResultArr[0]);

       // Now we have to round expected DOUBLE result into actual result
       String actual = actualResultArr[0];
       String expected = String.valueOf(expectedResult);


       // for rounding our DOUBLE actual result we gonna use DECIMALFormat'
       DecimalFormat decimalFormat = new DecimalFormat("#0.00");
       String formatterExpected = decimalFormat.format(expectedResult); //returns us String

       System.out.println("formatterExpected = " + formatterExpected);

       if (actual.equals(formatterExpected)){
           System.out.println("PASS");
       }else {
           System.out.println("FAIL!!!");
       }









   }
}

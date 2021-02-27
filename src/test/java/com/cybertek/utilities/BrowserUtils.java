package com.cybertek.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {


    //create method name: wait
    //converting milliseconds to seconds
    //handle checked exception

    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            System.out.println("something happened in sleep method");

        }
    }

    // waits for Clickability
    public static WebElement waitForClickability(WebElement element, int timeout ){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    // able to click using JSExecutor
    public static void clickWithJs (WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click;",element);
    }

    // wiats for visibility
    public static WebElement waitForVisibility(WebElement element, int timeWaitsInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),timeWaitsInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //SCREENSHOT METHOD
   //  The top line goes into your test, the other part is a seperate method-->
    //  and to be able call that metho create obj -->  takeSnapShot(driver, "D:\\Users\\User\\Pictures\\ss.png");

public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);//driver is the source

        //Move image file to new destination

        File DestFile = new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

        }



        // method to assert the title of Browsers for each time
    public static void titleVerification(String expectedTitle){

        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));

    }

    /*
    This method
    Accepts List <Webelement> and return List<String>
     */
    public static List<String> getElemenetsTxt(List<WebElement> webElementList){

        // placeholder for empty List of webelements
        List<String> webElementsAsString = new ArrayList<>();

        // looping through webelemenets and storing text into placeholder list
        for (WebElement each: webElementList){
            webElementsAsString.add(each.getText());
        }
        // returning final List<String>
    return webElementsAsString;

    }
}

package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBear_loginPage {
    public SmartBear_loginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement inputUsername;

    @FindBy(id = "ctl00_MainContent_password")
    public WebElement inputPassword;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status")
    public WebElement errorMessage;

    public void loginSmartBear(){
        inputUsername.sendKeys("Tester");
        inputPassword.sendKeys("test");
        loginButton.click();
    }

    public void loginSmartBear2(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }


    public void loginSmartBearConfig(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("sbUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("sbPassword"));
        loginButton.click();
    }


}

package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia_Page {

    public Wikipedia_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchInput")
    public WebElement input;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchBoc;


    @FindBy(id = "firstHeading")
    public WebElement mainHeader;

    }

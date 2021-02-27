package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SBear_BasePage {

    public SBear_BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "View all orders")
    public WebElement viewAllOrdersLink;

    @FindBy(linkText = "View all products")

    public WebElement viewAllProductsLink;
    @FindBy(linkText = "Order")
    public WebElement orderLink;
}

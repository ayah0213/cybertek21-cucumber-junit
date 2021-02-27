package com.cybertek.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sbear_ViewAllOrdersPage extends SBear_BasePage{

    @FindBy(xpath = "//tr[2]/td[2]")
    public WebElement newCustomerCell;


    /// methods
//        public void selectCardType(String cardType) {
//        for (WebElement element : radioButtonCardType) {
//            if (element.getText().equalsIgnoreCase(cardType)) {
//                element.click();
//            }
//        }

}

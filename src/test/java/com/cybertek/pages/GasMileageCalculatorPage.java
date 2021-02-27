package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileageCalculatorPage {


    public GasMileageCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='uscodreading']")
    public WebElement inputCurrentOdo;

    @FindBy(xpath = "//input[@id='uspodreading']")
    public WebElement inputPreviousOdo;

    @FindBy(id = "usgasputin")
    public WebElement inputGas;

    @FindBy(xpath = "(//input[@value='Calculate'])[1]")
    public WebElement calculateBtn;

    @FindBy(xpath = "//b[contains(text(),'mpg')]")
    public WebElement resultInAGs;



}

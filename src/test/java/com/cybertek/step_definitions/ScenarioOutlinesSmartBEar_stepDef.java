package com.cybertek.step_definitions;

import com.cybertek.pages.Sbear_ViewAllOrdersPage;
import com.cybertek.pages.SmartBearOrder_Page;
import com.cybertek.pages.SmartBear_loginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class ScenarioOutlinesSmartBEar_stepDef {


    SmartBearOrder_Page page1 = new SmartBearOrder_Page();
    SmartBear_loginPage page2= new SmartBear_loginPage();
    Sbear_ViewAllOrdersPage page4 = new Sbear_ViewAllOrdersPage();

    @Given("User is logged into SmartBear Tester account and on Order page")
    public void user_is_logged_into_smart_bear_tester_account_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smartBearUrls"));
    page2.loginSmartBear();
        page1.orderLink.click();
    }

    @Then("User fills out the form as followed from the table below:")
    public void user_fills_out_the_form_as_followed_from_the_table_below() {

    }
    @Then("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String string) {
        Select select= new Select(page1.productDropdown);
       select.selectByVisibleText(string);
    }
    @Then("User enters {string} to quantity")
    public void user_enters_to_quantity(String string) {
        page1.quantity.sendKeys(Keys.BACK_SPACE+string);
    }

    @Then("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String string) {
   page1.customerName.sendKeys(string);
    }

    @Then("User enters {string} to street")
    public void user_enters_to_street(String string) {
page1.street.sendKeys(string);
    }

    @Then("User enters {string} to city")
    public void user_enters_to_city(String string) {
        page1.inputCity.sendKeys(string);
    }
    @Then("User enters {string}  to state")
    public void user_enters_to_state(String string) {
        page1.inputState.sendKeys(string);
    }
    @Then("User enters {string} to zip")
    public void user_enters_to_zip(String string) {
    page1.inputZip.sendKeys(string);
    }

    @Then("User selects {string} as card type")
    public void user_selects_as_card_type(String string) {
    page1.visaCredit.click();
    }

    @Then("User enters {string} to card number")
    public void user_enters_to_card_number(String string) {
     page1.inputCardNumber.sendKeys(string);
    }
    @Then("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String string) {
    page1.inputExpireDate.sendKeys(string);
    }

    @Then("User clicks process button")
    public void user_clicks_process_button() {
    page1.processButton.click();
    }
    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String expectedName) {
        page1.viewAllOrdersLink.click();
        String actualName = page4.newCustomerCell.getText();
        Assert.assertTrue(actualName.equals(expectedName));
    }

}

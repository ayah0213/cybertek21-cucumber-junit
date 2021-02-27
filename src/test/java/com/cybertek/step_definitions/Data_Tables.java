package com.cybertek.step_definitions;

import com.cybertek.pages.DropDowns_Page;
import com.cybertek.pages.SmartBear_loginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Data_Tables {


    SmartBear_loginPage page = new SmartBear_loginPage();

    DropDowns_Page dropdown= new DropDowns_Page();
// smart bear
    @Given("User is on the login page of SmartBEar")
    public void user_is_on_the_login_page_of_smart_b_ear() {
       String url= ConfigurationReader.getProperty("smartBearUrls");
        Driver.getDriver().get(url);
    }

    @When("USer enters below inform")
    public void u_ser_enters_below_inform(Map<String, String> loginInfo) {
      String username =   loginInfo.get("username"); // --> return Tester
      String password = loginInfo.get("password"); //--> return test
        page.loginSmartBear2(username,password);
        page.loginSmartBear2(loginInfo.get(username),loginInfo.get(password));

    }
    @Then("User sould see title changed to Web Orders")
    public void user_sould_see_title_changed_to_web_orders() {

        BrowserUtils.titleVerification("Web Orders");

    }


    // fruitss list

    @Then("User should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> fruitlist) {
        System.out.println("Fruits size : "+fruitlist.size());
        System.out.println("Fruits list: "+fruitlist);
        for (String each: fruitlist){
            System.out.println("eachf fruit :"+ each);
        }

    }


    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        String url = ConfigurationReader.getProperty("smartBearUrls");
        Driver.getDriver().get(url);
    }


    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        Select select  =  new Select(dropdown.monthDropdown);

         // Basically we re comparing two list of thngs
        //expcted: List<String> expectedMonths
        List<String> actualMomths= BrowserUtils.getElemenetsTxt(select.getOptions());
        Assert.assertTrue(expectedMonths.equals(actualMomths));

        // 2nd way full wya to do
//       List<WebElement> list =  select.getOptions();
//       List<String> monthsAsString = new ArrayList<>();
//       for (WebElement each : list){
//           monthsAsString.add(each.getText());
//       }
//        Assert.assertTrue(expectedMonths.equals(monthsAsString));


    }



}

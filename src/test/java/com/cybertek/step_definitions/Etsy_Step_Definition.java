package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Etsy_Step_Definition {

    EtsySearchPage etsySearchPage= new EtsySearchPage();
    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {

        String url= ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);
    }



    @Then("user should see Etsy title as wxpected")
    public void user_should_see_etsy_title_as_wxpected() {
    String actual = Driver.getDriver().getTitle();
    String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        Assert.assertTrue(actual.equals(expected));
    }

    @When("user seraches for {string}")
    public void userSerachesFor(String string) {
        etsySearchPage.searchBox.sendKeys(string+ Keys.ENTER);
    }


    @Then("user should see {string}in the Etsy title")
    public void userShouldSeeInTheEtsyTitle(String string) {
        String actual = Driver.getDriver().getTitle();
        String expected = string + " | Etsy";
        Assert.assertTrue(actual.contains(expected));

    }
}

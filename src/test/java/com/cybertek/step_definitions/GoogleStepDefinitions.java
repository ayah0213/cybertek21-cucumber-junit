package com.cybertek.step_definitions;

import com.cybertek.pages.GoogleSearchPage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleStepDefinitions {

    GoogleSearchPage page =new GoogleSearchPage();

    @Then("User should see in the title")
    public void user_should_see_in_the_title() {
      String actual =Driver.getDriver().getTitle();
      String expected = "Google";
      Assert.assertTrue(actual.equals(expected));
    }


    @Given("User is on Google home page")
    public void user_is_on_google_home_page() {
        Driver.getDriver().get("https://www.google.com");

    }


    @When("User searches for apple")
    public void user_searches_for_apple() {
        GoogleSearchPage googleSearchPage= new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys("apple"+ Keys.ENTER);
    }
    @Then("User should see apple in the title")
    public void user_should_see_apple_in_the_title() {
     String actualTitle=Driver.getDriver().getTitle();
     String expectedInTitle = "apple";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
        Driver.closeDriver();
    }

    // for Orange
    @When("User searches for {string}")
    public void userSearchesFor(String string) {
        GoogleSearchPage googleSearchPage= new GoogleSearchPage();
        googleSearchPage.searchBar.sendKeys(string+ Keys.ENTER);
    }


    // for Orange
    @Then("User should see {string} in the title")
    public void userShouldSeeInTheTitle(String string) {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedInTitle = string;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    @Then("User should see following links")
    public void user_should_see_following_links(List<String> expectedFooteLink) {
        System.out.println("footer: "+expectedFooteLink);

        for (WebElement eachlink: page.footLinks ){
            System.out.println("each link: "+eachlink.getText());
        }

    }

}

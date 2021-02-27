package com.cybertek.step_definitions;

import com.cybertek.pages.Wikipedia_Page;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wikipedia_Step_Definition {


  Wikipedia_Page page= new Wikipedia_Page();

    @Given("User is on Wiki home page")
    public void user_is_on_wiki_home_page() {
        String url= ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(url);
    }

    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        page.input.sendKeys(string);
    }
    @When("User clicks Wiki search button")
    public void user_clicks_wiki_search_button() {
    page.searchBoc.sendKeys(Keys.ENTER);
    }
    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {
            String actualTitle = Driver.getDriver().getTitle();
            String expectedTitle = string +" - Wikipedia";

            Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
        }


//     String actual=Driver.getDriver().getTitle();
//     String expected= string + "- Wikipedia";
//        Assert.assertTrue(actual.equals(expected));


    @Then("USer sees {string} in the main header")
    public void userSeesInTheMainHeader(String string) {
        String actualHeaderText = page.mainHeader.getText();
        String expectedHeaderText= string;

        //Checking the context of the web element
        Assert.assertTrue(actualHeaderText.equalsIgnoreCase(expectedHeaderText));

        //Checking if the web element displayed or not
        Assert.assertTrue(page.mainHeader.isDisplayed());


    }

}

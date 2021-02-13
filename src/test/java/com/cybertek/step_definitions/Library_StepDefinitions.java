package com.cybertek.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Library_StepDefinitions {

    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("User in on the login page");
    }

    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters LIBRARIAN username");
       // Assert.fail("INTENTIAL FAIL");
    }
    @When("user enter librarian password")
    public void user_enter_librarian_password() {
        System.out.println("User enters LIBRARIAN password");
    }


    @Then("user should see dashboard")
    public void userShouldSeeDashboard() {
        System.out.println("User sees Dashboard");
    }

    @When("user enters student username")
    public void user_enters_student_username() {

    }



    @When("user enters student password")
    public void user_enters_student_password() {

    }

    @When("user enters admin username")
    public void userEntersAdminUsername() {

    }

    @And("user enters admin password")
    public void userEntersAdminPassword() {
    }
}

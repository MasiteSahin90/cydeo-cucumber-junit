package com.cydeo.step_definitions;

import com.cydeo.pages.WebTablePages;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTableStepDefinition {

    WebTablePages webTablePages = new WebTablePages();
    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTablePages.username.sendKeys(string);
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTablePages.password.sendKeys(string);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTablePages.loginButton.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyURLContains("orders");
    }

    @Given("user is on the login page of web table app")
    public void userIsOnTheLoginPageOfWebTableApp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String str1, String str2) {
        webTablePages.login(str1,str2);
        //str1= username , str2= password


    }

    @When("User enters below credentials")
    public void userEntersBelowCredentials(Map<String,String> credentials) {
        webTablePages.username.sendKeys(credentials.get("username"));
        webTablePages.password.sendKeys(credentials.get("password"));
        webTablePages.loginButton.click();

    }

    @Then("User should see url contains orders")
    public void userShouldSeeUrlContainsOrders( ) {
        BrowserUtils.verifyURLContains("orders");


    }
}

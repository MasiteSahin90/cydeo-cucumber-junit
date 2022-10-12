package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.security.Key;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        // Write code here that turns the phrase above into concrete actions
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        // Write code here that turns the phrase above into concrete actions
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();

        //TODO=tell me about your frame work yazisi hazirla
    }



    @Then("user sees apple in the google title")
    public void userSeesAppleInTheGoogleTitle() {
        String eTitle = "apple - Google Search";
        String aTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(eTitle,aTitle);



    }

    @And("user handles cookies")
    public void handleCookies() {
        googleSearchPage.cookies.click();
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {
googleSearchPage.searchBox.sendKeys(searchKeyword+ Keys.ENTER);
    }

    @When("user types apple and clicks enter")
    public void user_types_and_clicks_enter2() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }


    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String searchKeyword) {
       String aTitle = Driver.getDriver().getTitle();
       String eTitle = searchKeyword + " - Google Search";
       Assert.assertEquals(aTitle,eTitle);
    }





}

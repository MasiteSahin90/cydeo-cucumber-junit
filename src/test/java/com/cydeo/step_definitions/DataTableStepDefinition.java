package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownPages;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTableStepDefinition {

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like( List<String> fruits) {
        System.out.println(fruits);
        System.out.println(fruits.get(1));

    }

    DropdownPages dropdownPages = new DropdownPages();
    @Given("User is on the dropdowns page of practice tool")
    public void userIsOnTheDropdownsPageOfPracticeTool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown" );
    }

    @Then("User should see below info in month dropdown")
    public void userShouldSeeBelowInfoInMonthDropdown(List <String> expectedMonths) {

        List<String> actualMonths = BrowserUtils.dropdownOptionAsString(dropdownPages.dropdown);

        Assert.assertEquals(expectedMonths,actualMonths);

    }
}

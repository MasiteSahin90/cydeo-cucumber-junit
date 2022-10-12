package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    public static void switchWindowsVerify(String expectedInUrl, String expectedInTitle){


        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("current url=" + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }

    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);

    }

    /**
     * this method will accept a String as expected value and verify actual URL CONTAINS the value
     * @param expectedUrl
     */

    public static void verifyURLContains(String expectedUrl){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedUrl));
    }

    /**
     * this method will accept a dropdown as a webelement
     * and return all the options' text in a list of string
     * @param dropdownElement
     * @return
     */

    public static List<String> dropdownOptionAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        List < WebElement> actualOptionsAsWebElement = select.getOptions();

        List <String> actualOptionAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement){
            actualOptionAsString.add(each.getText());
        }
        return actualOptionAsString;
    }

    /**
     * this method will accept a group of radio buttons as a list of webElement
     * it will loop through the list and click on the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons , String attributeValue){
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }

        }
    }

}

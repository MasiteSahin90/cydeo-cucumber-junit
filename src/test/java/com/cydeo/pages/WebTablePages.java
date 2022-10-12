package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablePages {

    public WebTablePages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;


    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /**
     * No parameters
     * when we call this method it will directly login using
     * username: Test
     * password: Tester
     */

    public void login(){
        username.sendKeys("Test");
        password.sendKeys("Tester");
        loginButton.click();
    }

    /**
     *
     *this method will accept two arguments and login
     * @param userName
     * @param passWord
     */

    public void login(String userName , String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();

    }

    /**
     * this method will login using credentials from
     * configuration.properties
     */
    public void loginWithConfig(){
        username.sendKeys(ConfigurationReader.getProperty("web.table.username"));
        password.sendKeys(ConfigurationReader.getProperty("web.table.password"));
    }





}

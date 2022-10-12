package com.cydeo.step_definitions;


//in this class we will be able to pass pre- and post- conditions to each scenario and each step

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    //@Before(order = 0)
    //public void setUpScenario(){
      //  System.out.println("====Setting up browser using cucumber @Before====");
    //}

    /*@Before(value = "@login",order = 1)
    public void setUpScenarioForLogins(){
        System.out.println("&&&Setting up browser using scenarios with @login tag====");
    }

    @Before(value = "@db",order = -1)
    public void setUpForDatabaseScenarios(){
        System.out.println("###Setting up browser using scenarios with @db tag====");
    }

     */

    @After
    public void teradownScenario(Scenario scenario){

        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot,"image/png",scenario.getName());
        }



        Driver.closeDriver();
        //System.out.println("====Closing browser using cucumber @After====");
        //System.out.println("====Scenario ended / Take screenshot if failed====");
    }

   /* @BeforeStep
    public void setupStep(){
        System.out.println("---------> applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("---------> applying setup using @AfterStep");
    }


    */


}

package com.cydeo.step_definition;


import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.swing.*;

public class Hooks {


    @After
    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }



        Driver.closeDriver();

        //System.out.println("===Closing browser using cucumber @After");
        //System.out.println("===Scenario ended/ Take screenshot if failed!");
    }



}

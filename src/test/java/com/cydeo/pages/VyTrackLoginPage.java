package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.Pageable;

public class VyTrackLoginPage {

    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "_username")
    public WebElement usernameInput;

    @FindBy(name = "_password")
    public WebElement passwordInput;

    @FindBy(name = "_submit")
    public WebElement loginButton;

    public void login(String username, String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }




}

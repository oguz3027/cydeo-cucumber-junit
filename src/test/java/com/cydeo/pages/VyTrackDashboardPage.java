package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackDashboardPage {

    public VyTrackDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='user-menu']")
    public WebElement fullname;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    public void logout(){
        fullname.click();
        logoutButton.click();
    }





}

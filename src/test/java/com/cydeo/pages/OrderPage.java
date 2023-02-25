package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage{

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "product")
    public WebElement productDropdown;

    @FindBy(name = "quantity")
    public WebElement inputQuantity;

    @FindBy(name = "name")
    public WebElement customerName;

    @FindBy(name = "street")
    public WebElement streetName;

    @FindBy(name = "city")
    public WebElement cityName;

    @FindBy(name = "state")
    public WebElement stateName;

    @FindBy(name = "zip")
    public WebElement zipCode;

    /*@FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaCard;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement masterCardCard;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressCard;
*/

    @FindBy(name = "card")
    public List<WebElement> creditCardType;


    @FindBy(name = "cardNo")
    public WebElement creditCardNumber;

    @FindBy(name = "cardExp")
    public WebElement expireDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;








}

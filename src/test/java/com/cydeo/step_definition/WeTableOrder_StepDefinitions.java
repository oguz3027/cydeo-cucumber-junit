package com.cydeo.step_definition;

import com.cydeo.pages.*;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WeTableOrder_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();

    OrderPage orderPage = new OrderPage();

    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();


    @Given("user is already logged in an order page")
    public void user_is_already_logged_in_an_order_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));

        webTableLoginPage.login();

        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);
    }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int quantity) {
        orderPage.inputQuantity.sendKeys(String.valueOf(quantity));
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        orderPage.customerName.sendKeys(string);
    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.streetName.sendKeys(string);
    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.cityName.sendKeys(string);
    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.stateName.sendKeys(string);
    }

    @When("user enters zip {string}")
    public void user_enters_zip(String string) {
        orderPage.zipCode.sendKeys(string);
    }

    @When("user enters credit card type {string}")
    public void user_enters_credit_card_type(String cardType) {

        List<WebElement> cardTypes = orderPage.creditCardType;
        BrowserUtils.clickRadioButton(cardTypes, cardType);

    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.creditCardNumber.sendKeys(string);
    }

    @When("user enters expire date {string}")
    public void user_enters_expire_date(String string) {
        orderPage.expireDate.sendKeys(string);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderButton.click();
        ;
    }

    @Then("user should see {string} in first row of the table")
    public void user_should_see_in_first_row_of_the_table(String expectedName) {

        String actualName = viewAllOrdersPage.newCustomerCell.getText();

        Assert.assertEquals(expectedName,actualName);

    }

}

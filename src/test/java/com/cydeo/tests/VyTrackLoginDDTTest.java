package com.cydeo.tests;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.hssf.record.chart.DatRecord;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.notification.RunListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest{

    @Before
    public void setup(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }



    @Test
    public void loginDDTTest() throws IOException {

        String path = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("Credentials");


        VyTrackLoginPage loginPage = new VyTrackLoginPage();
        VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            String username = sheet.getRow(rowNum).getCell(0).toString();
            String password = sheet.getRow(rowNum).getCell(1).toString();
            String firstname = sheet.getRow(rowNum).getCell(2).toString();
            String lastname = sheet.getRow(rowNum).getCell(3).toString();
            String fullname = firstname + " " + lastname;

            loginPage.login(username,password);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String actualFullName = dashboardPage.fullname.getText();
            XSSFCell resultCell = sheet.getRow(rowNum).getCell(4);
            if(actualFullName.equals(fullname)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            }else{
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }

            dashboardPage.logout();

        }

        FileOutputStream output =new FileOutputStream(path);
        workbook.write(output);

        in.close();
        output.close();
        workbook.close();

    }



}

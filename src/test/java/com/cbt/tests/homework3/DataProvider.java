package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataProvider {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @org.testng.annotations.DataProvider
    public Object[] data(){

        return new Object[]{"200", "301", "404", "500"};
    }


    @Test(dataProvider = "data")
    public void test(String text) {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText(text)).click();
        String actualMessage = driver.findElement(By.tagName("p")).getText();
        String expectedMessage = "This page returned a " + text + " status code.";
        Assert.assertEquals(expectedMessage, actualMessage, "message should contain explanation => ");
    }

}

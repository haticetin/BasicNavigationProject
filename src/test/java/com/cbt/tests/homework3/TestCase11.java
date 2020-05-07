package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase11 {

    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        faker = new Faker();
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Status Codes")).click();
        driver.findElement(By.linkText("404")).click();
        String expctedMessage = "This page returned a 404 status code";
        String actualMessage = driver.findElement(By.cssSelector(".example>p")).getText();
        Assert.assertTrue(actualMessage.contains(expctedMessage),"Verify that following message is displayed");


    }

}

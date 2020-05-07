package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase8 {

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
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        String expectedMessage = "You selected: United States of America";
        String actualMessage = driver.findElement(By.xpath("(//div/p)[2]")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message is displayed");

    }

}

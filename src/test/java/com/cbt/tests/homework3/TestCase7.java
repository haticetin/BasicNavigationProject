package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

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
    public void test() {
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C://Users//Windows//Desktop/helloworld.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualMessage = driver.findElement(By.xpath("//h3[.='File Uploaded!']")).getText();
        String expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualMessage, expectedMessage, "Verify that subject is:");
        WebElement actualResult = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(actualResult.isDisplayed());


    }

}

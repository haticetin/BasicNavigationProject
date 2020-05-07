package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase4 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name = 'lastname']")).sendKeys("e");
        WebElement lastname = driver.findElement(By.xpath("(//small[@data-bv-validator='stringLength'])[2]"));
        String actualMessage = lastname.getText();
        String expectedMessage = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualMessage, expectedMessage, "Verify that warning message is displayed");

    }

}

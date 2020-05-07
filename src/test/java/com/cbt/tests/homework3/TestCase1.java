package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase1 {

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
        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        registration_form.click();
        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@name  = 'birthday']"));
        dateOfBirth.sendKeys("wrong_dob");
        WebElement message = driver.findElement(By.xpath("//*[.='The date of birth is not valid']"));
        String actualMessage = message.getText();
        String expectedMessage = "The date of birth is not valid";

        Assert.assertEquals(expectedMessage, actualMessage, "verify if messages are same");

    }

}

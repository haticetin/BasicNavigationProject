package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase2 {

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
        List<WebElement> options = driver.findElements(By.cssSelector(".form-check.form-check-inline"));
        List<String> expectedOptions = new ArrayList<>(Arrays.asList("C++", "Java", "JavaScript"));

        for (int i=0; i<options.size(); i++) {

//            Assert.assertTrue(options.get(i).isDisplayed(), "verify C++, Java, JavaScript is displayed");
            Assert.assertTrue(options.get(i).getText().equals(expectedOptions.get(i)), "verify C++, Java, JavaScript are displayed ");

        }




    }

}

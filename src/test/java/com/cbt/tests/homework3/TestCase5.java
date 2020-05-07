package com.cbt.tests.homework3;

import com.cbt.utilities.BrowserFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class TestCase5 {

    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        faker = new Faker();
    }

    @AfterMethod

    public void close() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Registration Form")).click();
        driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(faker.name().username().replace(".",""));
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(faker.internet().password());
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("567-214-6424");
        driver.findElement(By.cssSelector("input[value='female']")).click();
        driver.findElement(By.cssSelector("input[name='birthday']")).sendKeys("05/21/1978");
        WebElement department = driver.findElement(By.cssSelector("select[name='department']"));
        Select select = new Select(department);
        select.selectByIndex(5);
        WebElement job_title = driver.findElement(By.cssSelector("select[name='job_title']"));
        select = new Select(job_title);
        select.selectByVisibleText("QA");
        driver.findElement(By.cssSelector("input[value='java']")).click();
        driver.findElement(By.id("wooden_spoon")).click();

        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = driver.findElement(By.cssSelector(".alert.alert-success>p")).getText();
        Assert.assertEquals(actualMessage, expectedMessage,"Verify that following success message is displayed");


    }

}

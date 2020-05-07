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

import java.util.concurrent.TimeUnit;

public class TestCase6 {

    WebDriver driver;
    Faker faker;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        faker = new Faker();
    }

    @AfterMethod
    public void close() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://www.fakemail.net/");
        String email = driver.findElement(By.className("animace")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("input[name='full_name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actualMessage,expectedMessage,"Verify that following message is displayed");
        driver.get("https://www.fakemail.net/");
        WebElement mail = driver.findElement(By.cssSelector(".hidden-xs.hidden-sm.klikaciRadek.newMail:nth-of-type(1)"));
        Assert.assertTrue(mail.isDisplayed(),"Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”");
        mail.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualResult = driver.findElement(By.id("odesilatel")).getText();
        String expectedResult = "do-not-reply@practice.cybertekschool.com";
        Assert.assertEquals(actualResult, expectedResult,"Verify that email is from:");
        actualResult = driver.findElement(By.id("predmet")).getText();
        expectedResult = "Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertEquals(actualResult, expectedResult,"Verify that subject is:");



    }




}

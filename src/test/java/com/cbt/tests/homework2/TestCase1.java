package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        WebElement search = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        search.sendKeys("speakers");
        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();
        String results = driver.findElement(By.xpath("//h1[contains(@*,'srp-controls')]")).getText();
        System.out.println("results = " + results);
        driver.quit();


    }
}

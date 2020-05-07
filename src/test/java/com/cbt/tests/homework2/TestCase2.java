package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        driver.navigate().to("https://www.ebay.com/");
        WebElement search = By.xpath("//input[starts-with(@class,'gh-tb')]").findElement(driver);
        search.sendKeys("amazon");
        WebElement searchButton = driver.findElement(By.xpath("//td[@class='gh-td gh-sch-btn']//input"));
        searchButton.click();

        String actual = String.valueOf(driver.getTitle().contains("amazon"));
        StringUtility.verifyEquals("true", actual);

        driver.quit();


    }
}

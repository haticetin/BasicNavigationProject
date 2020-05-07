package com.cbt.tests.homework2;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.BiFunction;

public class TestCase3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org/");
        WebElement langOptionEng = driver.findElement(By.xpath("//strong[text()='English']"));
        langOptionEng.click();
        WebElement search = driver.findElement(By.xpath("//input[@*='searchInput']"));
        search.sendKeys("selenium webdriver");
        WebElement searchButton = driver.findElement(By.xpath("(//div[@id='simpleSearch']//input)[3]"));
        searchButton.click();
        WebElement seleniumWebdriver = driver.findElement(By.xpath("(//li/div/a)[1]"));
        seleniumWebdriver.click();
        Thread.sleep(1000);
        String actualResult = String.valueOf(driver.getCurrentUrl().endsWith("Selenium_(software)"));
        StringUtility.verifyEquals("true", actualResult);
        driver.quit();


    }
}

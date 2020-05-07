package com.cbt.tests.homework1;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        WebDriver driver1 = BrowserFactory.getDriver("chrome");
        driver(driver1);
        WebDriver driver2 = BrowserFactory.getDriver("firefox");
        driver(driver2);
        WebDriver driver3 = BrowserFactory.getDriver("edge");
        driver(driver3);

    }

    public static void driver(WebDriver driver){

        driver.get("https://google.com");
        String title1 = driver.getTitle();
        driver.get("https://etsy.com");
        String title2 = driver.getTitle();
        driver.navigate().back();
        String title3 = driver.getTitle();
        StringUtility.verifyEquals(title1, title3);
        driver.navigate().forward();
        String title4 = driver.getTitle();
        StringUtility.verifyEquals(title4, title2);
        driver.quit();

    }


}

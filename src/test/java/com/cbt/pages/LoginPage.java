package com.cbt.pages;

import com.cbt.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage{

    // butun dogru olanlari aliyor ve get() metodu ile hangisini kullanmak istiyosan seciyosun
    // eger o indexte bisey yoksa ERROR veriyo
    @FindAll({
            @FindBy(id = "prependedInputFALSE"),
            @FindBy(className = "span2"),
            @FindBy(name = "_username")
    })
    public List<WebElement> username;

    @FindBy(id = "prependedInput2")
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement login;


    public void login(String user){
        switch (user.toLowerCase().replace(" ", "")){
            case "driver": case "truckdriver":
                username.get(0).sendKeys(ConfigurationReader.get("driver_username"));
                password.sendKeys(ConfigurationReader.get("driver_password")+ Keys.ENTER);
                break;
            case "salesmanager":
                username.get(1).sendKeys(ConfigurationReader.get("salesmanager_username"));
                password.sendKeys(ConfigurationReader.get("salesmanager_password"));
                login.click();
                break;
            case "storemanager":
                username.get(0).sendKeys(ConfigurationReader.get("storemanager_username"));
                password.sendKeys(ConfigurationReader.get("storemanager_password"));
                login.click();
                break;
            default:
                System.out.println("Invalid User");
        }
    }




}

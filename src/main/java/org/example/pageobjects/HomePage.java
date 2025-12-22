package org.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //WebElement Locators

    @FindBy(xpath = "//input[@type='text']")
    WebElement search;

    //Actions

    public void goTo(){
        driver.get("https://www.flipkart.com/");
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void search(){
       search.sendKeys("Shirt");
    }



}

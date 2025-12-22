package org.example.testcomponents;

import org.example.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties properties;
    public HomePage homePage;

    public WebDriver initializeDriver() throws IOException {

        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/utils/GlobalData.properties");
        properties.load(fis);

        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firfox")) {
            driver=new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver=new EdgeDriver();
        }

        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public void launchApp() throws IOException {
        driver=initializeDriver();
        homePage = new HomePage(driver);
        homePage.goTo();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver !=null){
            driver.quit();
        }
    }

}

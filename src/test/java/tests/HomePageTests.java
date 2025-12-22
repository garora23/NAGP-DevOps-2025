package tests;

import org.example.testcomponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void searchOnHomepage(){
        System.out.println("app launched");
       // homePage.search();
    }

    @Test
    public void validateURL(){
        System.out.println("Validating URL");
        String expectedHomePageURL = "https://www.flipkart.com/";
        String actualHomePageURL=homePage.getURL();
        Assert.assertEquals(actualHomePageURL,expectedHomePageURL);
    }

    @Test
    public void validateTitle(){
        System.out.println("Validating Title");
        String expectedTitle = "Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
        String actualTitle=homePage.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


}

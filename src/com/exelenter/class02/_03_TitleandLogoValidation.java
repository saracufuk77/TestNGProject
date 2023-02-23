package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;

import java.util.prefs.BackingStoreException;

public class _03_TitleandLogoValidation extends BaseClass {
    @BeforeMethod
    void openBrowser(){
        setUp();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }
    @Test
    void titleValidation(){
        String expectedTitle= "Exelenter Project";  //if you change the expected title and run the second test only, it will cause first one failure and second one skipped.
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title does not match. Test failed.");
    }
    @Test(dependsOnMethods = "titleValidation" )
    void logoValidation(){
        LoginPage loginPage =new LoginPage();
        boolean logoDisplayed = loginPage.homepageLogo.isDisplayed();
        Assert.assertTrue(logoDisplayed,"Logo is not displayed. Test Failed");
    }
    //If a test assertion fails, test will continue and quite the browser. Because Assert has a built-in try-catch.
}

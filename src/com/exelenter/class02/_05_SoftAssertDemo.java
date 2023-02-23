package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _05_SoftAssertDemo extends BaseClass {
    @BeforeMethod
    void openBrowser(){
        setUp();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

    @Test
    void softAssertionTest(){
        //First:Verify logo is displayed
        LoginPage login=new LoginPage();
        boolean logoDisplayed = login.homepageLogo.isDisplayed();
        logoDisplayed= false;
//        Assert.assertTrue(logoDisplayed,"Logo is not displayed"); // Validating Logo

        //Soft Assert (If sort assert fails, remaining test steps will continue
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(logoDisplayed,"Logo is not displayed");

        //Second: Login to the website
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password,ConfigsReader.getProperties("password"));
        clickButwaitForClickability(login.loginBtn);
        DashboardPage dashboard = new DashboardPage();
        Assert.assertEquals(dashboard.welcome.getText(),"Welcome Admin"," 'Welcome Admin' text is incorrect"); //Validating Login
        System.out.println("Using Hard Assert if previous test assertion fails, this line will not be printed. But in softassert it will be printed");

        //assertAll() method must be used at the end of the soft-assert test. this will check ALL assertions, if one fails all test fails.
        //but if you forgot it, if one passes, entire @Test passes.
        softAssert.assertAll();
        System.out.println("After assertAll(), this line will not be executed if any test fails.");
        System.out.println("All tests passed.");
    }
}

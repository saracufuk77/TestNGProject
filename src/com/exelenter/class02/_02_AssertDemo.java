package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 * TC 01: Login Validation Test (Happy Path)
 *      Open chrome browser
 *      Go to https://exelentersdet.com
 *      Enter valid username and password
 *      Click on login button
 *      Verify login is successful
 *      Close the browser
 *
 * TC 02: Login Validation Test (Negative Test)
 *      Open chrome browser
 *      Go to http://exelentersdet.com
 *      Enter valid username
 *      Leave password field empty
 *      Verify error message with text “Password cannot be empty” is displayed.
 */
public class _02_AssertDemo extends BaseClass {

    @BeforeMethod
    void openBrowser(){
        setUp();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

    @Test
    void validLoginTest(){
        LoginPage login =new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password,ConfigsReader.getProperties("password"));
        clickButwaitForClickability(login.loginBtn);

        //validation comes here
        DashboardPage dashboard = new DashboardPage();
        String expectedText="Welcome Admin";
        String actualText = dashboard.welcome.getText();
        Assert.assertEquals(actualText,expectedText," 'Welcome Admin' text is incorrect"); //message is optional. It is printed only if test fails.

        //Assert.assertEquals(dashboard.welcome.getText(),"Welcome Admin"," 'Welcome Admin' text is incorrect");

    }

    @Test
    void invalidLoginTest(){
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        String expectedTest="Password cannot be empty";
        clickButwaitForClickability(loginPage.loginBtn);
        Assert.assertEquals(loginPage.LoginErrorMessage.getText(),expectedTest,"Message error is incorrect.");

    }

}

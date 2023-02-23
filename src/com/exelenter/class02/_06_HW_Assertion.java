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

/*
 *  Task: Hard Assert & Soft Assertion
 *    First use Hard Assert
 *        1. Go to exelentersdet.com website
 *        2. Get the title of the webpage, change it to false, fail this test step intentionally
 *        3. Login to the website. You should NOT be able to login
 *    Now, comment out Hard Assert, and use Soft Assert instead.
 *        4. Using Soft Assert, try to login to the website.
 *    You should be able to login, even if the title verification (previous step) fails.
 *
 */
public class _06_HW_Assertion extends BaseClass {
    @BeforeMethod
    void openBrowser(){
        setUp();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

    @Test
    public void hw_Assertion(){
        LoginPage login =new LoginPage();
        String expectedTitle = "Exelenter Project!!!";
        String actualTitle = driver.getTitle();
//        Assert.assertEquals(actualTitle,expectedTitle,"Title is wrong"); //hard assert

        SoftAssert soft =new SoftAssert();
        soft.assertEquals(actualTitle,expectedTitle,"Title is wrong");

        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password, ConfigsReader.getProperties("password"));
        click(login.loginBtn);
        DashboardPage dashboard = new DashboardPage();
        String expectedText="Welcome Admin";
        String actualText = dashboard.welcome.getText();
        Assert.assertEquals(actualText,expectedText," 'Welcome Admin' text is incorrect");
    }

}

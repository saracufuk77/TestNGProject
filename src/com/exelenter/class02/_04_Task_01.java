package com.exelenter.class02;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _04_Task_01 extends BaseClass {
    @BeforeMethod
    void openBrowser(){
        setUp();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

    @Test
    void dashboardLogoValidation(){
        LoginPage login =new LoginPage();
        sendText(login.username, ConfigsReader.getProperties("username"));
        sendText(login.password,ConfigsReader.getProperties("password"));
        clickButwaitForClickability(login.loginBtn);

        DashboardPage dashboard = new DashboardPage();
        boolean logoDisplayed = dashboard.dashboardLogo.isDisplayed();
        Assert.assertTrue(logoDisplayed,"Logo could not be displayed");

    }
}

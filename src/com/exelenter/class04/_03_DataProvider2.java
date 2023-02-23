package com.exelenter.class04;

import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;


//Instead of repeating ourselves with many test methods(login1, login2, login3), we can use DataProvider
public class _03_DataProvider2 extends BaseClass {
    @Test()
    public void loginTest1(String username, String password){
        sendText(loginPage.username, "Admin");
        sendText(loginPage.password,"Exelent2022Sdet!");
        click(loginPage.loginBtn);
        boolean displayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(displayed,"Welcome Message is not displayed");
    }

    @Test()
    public void loginTest2(String username, String password){
        sendText(loginPage.username, "johndoe");
        sendText(loginPage.password,"k#G886@H");
        click(loginPage.loginBtn);
        boolean displayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(displayed,"Welcome Message is not displayed");
    }

    @Test()
    public void loginTest3(String username, String password){
        sendText(loginPage.username, "EssUser");
        sendText(loginPage.password,"Ess@2023");
        click(loginPage.loginBtn);
        boolean displayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(displayed,"Welcome Message is not displayed");
    }

}

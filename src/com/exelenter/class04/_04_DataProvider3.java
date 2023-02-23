package com.exelenter.class04;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;

public class _04_DataProvider3 extends BaseClass {

    //Instead of repeating ourselves with many test methods(login1, login2, login3), we can use DataProvider
    @Test(dataProvider = "dataProviderMethod")
    public void loginTest(String username, String password){
        sendText(loginPage.username, username);
        sendText(loginPage.password,password);
        click(loginPage.loginBtn);
        boolean displayed = dashboardPage.welcome.isDisplayed();
        Assert.assertTrue(displayed,"Welcome Message is not displayed");
    }

    @DataProvider
    public Object[][] dataProviderMethod(){
        Object[][] data={
                {"Admin","Exelent2022Sdet!"},
                {"johndoe","k#G886@H"},
                {"EssUser","Ess@2023"}
        };
        return data;
    }
}

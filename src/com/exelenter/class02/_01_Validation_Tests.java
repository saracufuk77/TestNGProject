package com.exelenter.class02;

import org.testng.annotations.*;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;

public class _01_Validation_Tests extends BaseClass {
    /**
     * We will copy from Selenium project following folders and packages
     * 1-utils package
     * 2-page package /in class20
     * 3-test package / in class20
     * 4-Selenium JARS
     * 5-drivers folder
     * 6-configs folder
     */

    //We need to call Webdriver and also Quit it before and after EACH test. So we need to use @beforemethod and @aftermethod

    @BeforeMethod
    void beforeMethod(){
        setUp();
    }

    @AfterMethod
    void afterMethod(){
        tearDown();
    }
    @Test
    void titleValidation(){
        String expectedTitle= "Exelenter Project";
        String actualTitle= driver.getTitle();
        if(actualTitle.equals(expectedTitle))
            System.out.println("Title matches. Test passed");
        else
            System.out.println("Title does not match. Test failed.");
    }
    @Test
    void logoValidation(){
        LoginPage loginPage =new LoginPage();
        boolean logoDisplayed = loginPage.homepageLogo.isDisplayed();
        if(logoDisplayed)
            System.out.println("Logo is displayed. Test Passed");
        else
            System.out.println("Logo is not displayed. Test Failed");

    }

    @Test  //Positive Testing = "Happy Path" , Negative Testing
    void validLoginTest(){
        LoginPage loginPage = new LoginPage();
        //sendText(loginPage.username, "Admin");
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        //sendText(loginPage.password,"Exelent2022Sdet!");
        sendText(loginPage.password,ConfigsReader.getProperties("password"));
        click(loginPage.loginBtn);

        DashboardPage dashboard = new DashboardPage();
        String expectedValue = "Welcome Admin!!!";
        String actualValue = dashboard.welcome.getText();;

        if(actualValue.equals(expectedValue))
            System.out.println("Login successfull. Test Passed");
        else
            System.out.println("Login Failed");
    }
}

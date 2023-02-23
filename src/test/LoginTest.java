package test;

import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.ConfigurationGroupMethods;
import pages.DashboardPage;
import pages.LoginPage;
import utils.BaseClass;
import utils.ConfigsReader;
/**
 * US 16457: As an admin user I should be able to login to the admin page using valid login credentials.
 * US 23541: As a user, I should be able to login to the dashboard page using valid login credentials.
 * US 48554: As a business user, here goes your request...
 */
public class LoginTest extends BaseClass {

    @Test
    public void validAdminLogin(){
        loginPage.loginToWebsite("username","password");
        String expectedText="Welcome Admin";
        String actualText = dashboardPage.welcome.getText();
        Assert.assertEquals(actualText,expectedText," 'Welcome Admin' text is incorrect");
    }

    @Test
    public void validUserInvalidPassword(){                 //negative testing
        String invalidPassword = "Pass1234";
        String expectedErrorMessages="Invalid credentials";

        sendText(loginPage.username, ConfigsReader.getProperties("username"));   //Valid Username
        sendText(loginPage.password,invalidPassword);    //Invalid password
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.LoginErrorMessage.getText(),expectedErrorMessages,"Error message is incorrect");
    }

    @Test
    public void validUserEmptyPassword(){                      //negative testing
        String expectedErrorMessages="Password cannot be empty";
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   //Valid Username

        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.LoginErrorMessage.getText(),expectedErrorMessages,"Error message is incorrect");
    }

}

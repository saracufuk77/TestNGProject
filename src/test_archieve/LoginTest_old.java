package test_archieve;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ConfigsReader;

/**
 * US 16457: As an admin user I should be able to login to the admin page using valid login credentials.
 * US 23541: As a user, I should be able to login to the dashboard page using valid login credentials.
 * US 48554: As a business user, here goes your request...
 */
public class LoginTest_old extends BaseClass {
    @BeforeMethod
    void openBrowser(){
        setUp();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

    @Test
    public void validAdminLogin(){                                   //happy path testing
//        var loginPage = new LoginPage();     //we can get rid of it because we inherited PageInitiliazer from CommonMethods From BaseClass
        sendText(loginPage.username, ConfigsReader.getProperties("username"));
        sendText(loginPage.password, ConfigsReader.getProperties("password"));
        click(loginPage.loginBtn);

//        DashboardPage dashboard = new DashboardPage();
        String expectedText="Welcome Admin";
        String actualText = dashboardPage.welcome.getText();
        Assert.assertEquals(actualText,expectedText," 'Welcome Admin' text is incorrect");
    }

    @Test
    public void validUserInvalidPassword(){                 //negative testing
        String invalidPassword = "Pass1234";
        String expectedErrorMessages="Invalid credentials";
//        var loginPage =new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   //Valid Username
        sendText(loginPage.password,invalidPassword);    //Invalid password
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.LoginErrorMessage.getText(),expectedErrorMessages,"Error message is incorrect");
    }

    @Test
    public void validUserEmptyPassword(){                      //negative testing
        String expectedErrorMessages="Password cannot be empty";
//        var loginPage =new LoginPage();
        sendText(loginPage.username, ConfigsReader.getProperties("username"));   //Valid Username
        //sendText(login.password,"");    //Empty password
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.LoginErrorMessage.getText(),expectedErrorMessages,"Error message is incorrect");
    }

}

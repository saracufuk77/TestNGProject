package com.exelenter.HW;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

import static org.testng.Assert.assertEquals;

/*
HW: using TestNG DataProvider, write negative test cases for all the following scenarios:
User Story: As an Invalid User, I should not be able to login using invalid login credentials, and if I try, I should see an error message.
Acceptance Criteria:
 1. When a User enters a valid username and an invalid password
    An 'Invalid credentials' error message is presented.
 2. When a User enters an invalid username and a valid password
    An 'Invalid credentials' error message is presented.
 3. When a User enters an invalid username and invalid password
    An 'Invalid credentials' error message is presented.
 4. When a User enters a valid username and an empty password
    A 'Password cannot be empty' error message is displayed.
 5. When a User enters an invalid username and an empty password
    A 'Password cannot be empty' error message is displayed.
 6. When a User enters an empty username and a valid password
    A 'Username cannot be empty' error message is presented.
 7. When a User enters an empty username and an invalid password
    A 'Username cannot be empty' error message is presented.
 8. When a User enters an empty username and an empty password
    A 'Username cannot be empty' error message is presented.
 9. When a User enters a valid username and a valid password
    "Welcome 'user firstname' " message is displayed in dashboard page
 */
public class HW1_version2 extends BaseClass {
    @Test(dataProvider = "getItFromExcel",groups = {"homework"})
    public void addEmployeeTest(String firstName, String lastName, String username, String password){
        loginPage.loginToWebsite("username","password");
        wait(1);
        pimPage.navigateToAddEmployee();
        wait(1);
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.lastName, lastName);
        String expectedEmployeeId = addEmployeePage.employeeId.getAttribute("value");
        System.out.println("expectedEmployeeId = " + expectedEmployeeId);
        clickButwaitForClickability(addEmployeePage.createLoginDetailsCheckBox);
        wait(1);
        sendText(addEmployeePage.username,username);
        sendText(addEmployeePage.password,password);
        sendText(addEmployeePage.confirmPassword, password);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        wait(1);
        click(addEmployeePage.saveButton);
        try {
            boolean headerDisplayed = personalDetailsPage.personalDetailsHeader.isDisplayed();
            if(headerDisplayed){
                String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
                assertEquals(actualEmployeeId,expectedEmployeeId,"Employee id does not match");
                takeScreenshot(firstName+"_"+lastName);
                System.out.println("The new employee is added successfully");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Employee is not added. Username or Id already exists.");
        }
    }

    @DataProvider(name = "getItFromExcel")
    public Object[][] getItFromExcel(){
        String filePath = ExcelUtility.projectPath+"/testData/HW_user_login_tests.xlsx";
        return ExcelUtility.readFromExcel(filePath,"users");
    }

    @Test(dataProvider = "loginData",groups = {"homework"})
    public void userLogin(String username, String password,String expectedErrorMessage ){
        sendText(loginPage.username, username);
        System.out.println("username = " + username);
        sendText(loginPage.password, password);
        System.out.println("password = " + password);
        click(loginPage.loginBtn);
        Assert.assertEquals(loginPage.LoginErrorMessage.getText(), expectedErrorMessage, "Error message is incorrect");
        System.out.println(expectedErrorMessage);
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        String filePath = ExcelUtility.projectPath+"/testData/HW_user_login_tests.xlsx";
        return ExcelUtility.readFromExcel(filePath,"testler");
    }

    @DataProvider
    Object[][] getData() {
        return new Object[][]{
                {"Admin", "invalidPass", "Invalid credentials"},           // valid user     invalid password
                {"admi123", "Exelent2022Sdet!", "Invalid credentials"},    // invalid user   valid password
                {"admi123", "invalidPass", "Invalid credentials"},         // invalid user   invalid password
                {"Admin", "", "Password cannot be empty"},                 // valid user     empty password
                {"Admi123", "", "Password cannot be empty"},               // invalid        empty
                {"", "Exelent2022Sdet!", "Username cannot be empty"},      // empty          valid
                {"", "invalidPass", "Username cannot be empty"},           // empty          invalid
                {"", "", "Username cannot be empty"}                       // empty          empty
        };
    }
}

package com.exelenter.class05;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.ExcelUtility;

import static org.testng.Assert.*;

/*
  Task: HW: Add Employees using Data Provider Annotation
         1.  Open the Chrome browser
         2.  Go to https://exelentersdet.com/
         3.  Login into the application
         4.  Navigate to Add Employee Page
         5.  Add 5 different Employees and create login credentials by providing:
                 - First Name
                 - Last Name
                 - Username
                 - Password
         6.  Verify Employee has been added successfully and take screenshots (you
              must have 5 different screenshots)
         7.  Close the browser
              BONUS: Specify a group name for this test case, and execute from the
              XML file.
 */
public class _02_HW_AddEmployee extends BaseClass {
    @Test(dataProvider = "readFromExcel", groups = {"smoke","regression","excel"})
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

//        //Validation
//        waitForVisibilty(personalDetailsPage.personalDetailsHeader);  //wait for the header to become visible
//        String actualEmployeeId = personalDetailsPage.employeeId.getAttribute("value");
//        assertEquals(actualEmployeeId,expectedEmployeeId,"Employee id does not match");
//        takeScreenshot(firstName+"_"+lastName);
//        System.out.println("The new employee is added successfully");

        //Validation with Try-Catch
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
            //1 st way to fail my test
//            System.out.println("Employee is not added. Username or Id already exists.");
//            Assert.fail();
            //2nd way to fail my test
            throw new RuntimeException("Employee is not added. Username or Id already exists.");
        }
    }
    @DataProvider
    public Object[][] addEmployees(){
        return new Object[][]{
                {"Sophia","Patel","spatel231",randomStrongPassWord()},
                {"Jackson","Chan","jchan231",randomStrongPassWord()},
                {"Mehmet","Karabey","mkarabey23",randomStrongPassWord()},
                {"Caleb","Thomson","cthomson231",randomStrongPassWord()},
                {"Zoe","Kim","zoekim231",randomStrongPassWord()}
        };
    }

    //2 nd way: How to read data from Excel

    @DataProvider(name = "readFromExcel")
    public Object[][] getDataFromExcel(){
        String absolutePath = ExcelUtility.projectPath + "/testData/HW_user_login_tests.xlsx";
        return ExcelUtility.readFromExcel(absolutePath,"Employee");
    }

}

package test_archieve;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

public class AddEmployeeTest_old extends BaseClass {
    @BeforeMethod
    void openBrowser(){
        setUp();
        initialize();
    }

    @AfterMethod
    void closeBrowser(){
        tearDown();
    }

    @Test
    public void addEmployeeTest(){
//        LoginPage loginPage = new LoginPage();
        loginPage.loginToWebsite("username","password");

//        PIMPage pimPage =new PIMPage();
        pimPage.navigateToAddEmployee();

//        AddEmployeePage addEmployeePage = new AddEmployeePage();
        String employeeId = addEmployeePage.employeeId.getAttribute("value");
        System.out.println("employeeId = " + employeeId);
//        sendText(addEmployeePage.firstName,ConfigsReader.getProperties("empFirstName"));
//        sendText(addEmployeePage.lastName,ConfigsReader.getProperties("empLastName"));
//        sendText(addEmployeePage.uploadPhoto,ConfigsReader.getProperties("filePath"));  //retrieving photo location
//        click(addEmployeePage.saveButton);

        addEmployeePage.addEmployee("empFirstName","empLastName","filePath");    //this method will add a new employee
    }

}

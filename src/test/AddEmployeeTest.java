package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseClass;

public class AddEmployeeTest extends BaseClass {
       @Test
    public void addEmployeeTest(){
        loginPage.loginToWebsite("username","password");
        pimPage.navigateToAddEmployee();

        String employeeId = addEmployeePage.employeeId.getAttribute("value");
        System.out.println("employeeId = " + employeeId);

        addEmployeePage.addEmployee("empFirstName","empLastName","filePath");    //this method will add a new employee
    }

}

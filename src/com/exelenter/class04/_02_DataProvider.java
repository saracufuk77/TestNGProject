package com.exelenter.class04;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider {
    //Data Driven Testing. Behavioral Driven Testing (BDD)(TDD)
    //DataProvide  it works 2D Array and accepts Objects as data type
    @Test
    void printData() {

    }

    //Manipulating data with DataProvider

    @Test(dataProvider="users")
    public void prindData2(String firstName,String lastName, int age){
        System.out.println(firstName+" "+lastName+" "+age);
    }

    @DataProvider
    public Object[][] users() {
        Object[][] user = {
                {"John", "Doe", 28},
                {"Sam", "Lee", 35},
                {"Jack", "Sparrow", 40}
        };
        return user;
    }
}
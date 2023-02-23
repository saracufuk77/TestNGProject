package com.exelenter.class01_Intro;

import org.testng.annotations.*;

public class _04_TestNGDemo4 {

    @Test(enabled = false)  //if you want to ignore the test, use attribute (enabled=false). Do not run this test
    public void test1(){
        System.out.println("Test One");
    }

    @Test
    void test2(){
        System.out.println("Test Two");
    }

    @Test
    void test3(){
        System.out.println("Test Three");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After Method");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    void afterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass
    void afterClass(){
        System.out.println("After Class");
    }

    @BeforeSuite
    void beforeSuite(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    void afterSuite(){
        System.out.println("After Suite");
    }

}

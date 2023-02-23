package com.exelenter.class01_Intro;

import org.testng.annotations.*;

public class _03_TestNGDemo3 {
    /**
     *TestNG Methods run by ascending order (alphabetically)
     * sayH
     * sayG
     */

    //@Test(priority = 1)
    @Test(enabled = false)  //if you want to ignore the test, use attribute (enabled=false). Do not run this test
    public void test1(){
        System.out.println("Test One");
    }

    //@Test(priority = 2)
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

}

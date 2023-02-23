package com.exelenter.class01_Intro;

import org.testng.annotations.*;

public class _01_TestNGDemo {
    /**
     *TestNG Methods run by ascending order (alphabetically)
     * sayH
     * sayG
     */

    //@Test(priority = 1)
    @Test
    public void sayHello(){
        System.out.println("Hello");
    }

    //@Test(priority = 2)
    @Test
    void sayBye(){
        System.out.println("GoodBye");
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

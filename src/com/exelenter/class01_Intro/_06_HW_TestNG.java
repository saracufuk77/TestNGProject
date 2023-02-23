package com.exelenter.class01_Intro;

import org.testng.annotations.*;

/**
 * Task: Create Three Test methods and run them in the order as following:
 *          1. testOne()
 *          2. testTwo()
 *          3. testThree()
 *       and print the following:
 *          1. 'Starting Test' before each test
 *          2. 'Ending Test' after each test
 *          3. 'Launching Regression Test' before all tests (only once).
 *          4. 'End of Regression Test' after all tests (only once).
 *
 *          Final result should look like this:
 *          === Launching Regression Test ===
 *          Starting Test
 *          -->Test One
 *          Ending Test
 *          Starting Test
 *          -->Test Two
 *          Ending Test
 *          Starting Test
 *          -->Test Three
 *          Ending Test
 *          === End of Regression Test ===
 */
public class _06_HW_TestNG {

    @Test
    void testOne(){
        System.out.println("-->Test One");
    }
    @Test(priority = 1)
    void testTwo(){
        System.out.println("-->Test Two");
    }
    @Test(priority = 2)
    void testThree(){
        System.out.println("-->Test Three");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("Starting Test");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("Ending Test");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("=== Launching Regression Test ===");
    }
    @AfterTest
    void afterTest(){
        System.out.println("=== End of Regression Test ===");
    }
}

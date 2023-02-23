package com.exelenter.class01_Intro;

import org.testng.annotations.Test;

/**
 *  Task: Create a class that has 5 test methods named as the following:
 *      1. firstMethod
 *      2. firstMethod1
 *      3. secondMethod
 *      4. thirdMethod
 *      5. fourthMethod
 *   And each of them printing the method name
 *   Run and observe the results
 *   Then, add the needed attribute(s) to print them in the following result:
 *      1. fourthMethod
 *      2. thirdMethod
 *      3. secondMethod
 *      4. firstMethod
 */
public class _05_Task1 {

    @Test(priority = 4)
    void firstMethod(){
        System.out.println("firstMethod");
    }

    @Test(enabled = false)
    void firstMethod1(){
        System.out.println("firstMethod1");
    }

    @Test(priority = 3)
    void secondMethod(){
        System.out.println("secondMethod");
    }
    @Test(priority = 2)
    void thirdMethod(){
        System.out.println("thirdMethod");
    }
    @Test(priority = 1)
    void fourthMethod(){
        System.out.println("fourthMethod");
    }


}

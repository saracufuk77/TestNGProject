package com.exelenter.class03;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssert_Recap {
    @Test
    public void testCase(){
        //example of hard Assert
//        System.out.println("before Assert");
//        Assert.assertTrue(false);
//        System.out.println("after Assert");  //this line won't be printed if Assert before it fails

        //example of Soft Assert
        System.out.println("before SoftAssert");
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(true);
        System.out.println("after soft Assert"); //this line will be printed even if soft Assert before it fails
        soft.assertAll();
        System.out.println("All test steps passed"); //this line will be printed if All steps pass, otherwise it will not be printed
    }
    //remember: use only one Assertion per Test Case (@Test method)
}

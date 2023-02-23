package com.exelenter.class05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Listener_Demo {
    @Test
    void test1(){
        System.out.println("test1 Running...");
    }

    @Test
    void test2(){
        System.out.println("test2 Running...");
//        Assert.fail();
    }
}

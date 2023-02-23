package com.exelenter.class04;

import org.testng.annotations.Test;

public class _01_GroupsDemo {
    @Test(dependsOnGroups = "regression")
    void test1(){
        System.out.println("test1");
    }
    @Test(groups = "smoke")
    void test2(){
        System.out.println("test2");
    }
    @Test(groups = "regression")
    void test3(){
        System.out.println("test3");
    }
    @Test(groups = {"smoke","regression"})
    void test4(){
        System.out.println("test4");
    }

    @Test
    void test5(){
        System.out.println("test5");
    }
    @Test
    void test6(){
        System.out.println("test6");
    }
}

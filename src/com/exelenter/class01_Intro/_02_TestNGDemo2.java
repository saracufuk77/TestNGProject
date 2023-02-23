package com.exelenter.class01_Intro;

import org.testng.annotations.Test;

public class _02_TestNGDemo2 {
    /**
     *  Ascending  1, 2, 3, a, b, c, ..
     *  Descending  3, 2, 1, c, b, a, ..
     */
    @Test
    void testOne() {
        System.out.println("Test One");
    }

    @Test
    void testTwo() {
        System.out.println("Test Two");
    }

    @Test
    void testThree() {
        System.out.println("Test Three");
    }

    /**
     *  testO    <== 1st place
     *  testTw   <== 3rd place
     *  testTh   <== 2nd place
     */

}

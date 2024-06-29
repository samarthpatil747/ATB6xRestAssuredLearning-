package com.testingacademy.ex_25062023;

import org.apache.log.Priority;
import org.testng.annotations.Test;

public class Lab278 {
    @Test(priority = 2)
    public void testmethodOne() {
        System.out.println("Test method one");
    }

    @Test(priority = 1)
    public void testmethodTwo() {
        System.out.println("Test method Two");
    }

    @Test (priority = 0)
    public void testmethodThree() {
        System.out.println("Test method Three");
    }
}


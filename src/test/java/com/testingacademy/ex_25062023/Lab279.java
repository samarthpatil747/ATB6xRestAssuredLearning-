package com.testingacademy.ex_25062023;

import org.testng.annotations.Test;

public class Lab279 {
    @Test(priority = 1)
    public void testmethodA() {
        System.out.println("A");
    }

    @Test(priority = 1)
    public void testmethod0A() {
        System.out.println("B");
    }

    @Test (priority = 1)
    public void testmethodC() {
        System.out.println("C");
    }
}


package com.testingacademy.ex_20062023;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab266 {
    @Test
    public void test1() {
        System.out.println("This is test() method");
        Assert.assertEquals(true,true);
    }
    @Test
    public void test2() {
        System.out.println("This is test2() method");
        Assert.assertEquals(true, false);
    }
}

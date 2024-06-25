package com.testingacademy.ex_20062023;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Lab262 {
    @Description("Verify Test case 1")
    @Test
    public void getRequest1() {
        System.out.println("@Test - testLoad1()");
    }
    @Description("Verify Test case 2")
    @Test
    public void getRequest2() {
        System.out.println("@Test - testLoad2()");
    }
    @Description("Verify Test case 3")
    @Test
    public void getRequest3() {
        System.out.println("@Test - testLoad3()");
    }
    @Test (enabled = false)
    public void getRequest4() {
        System.out.println("@Test - testLoad4()");
    }

}

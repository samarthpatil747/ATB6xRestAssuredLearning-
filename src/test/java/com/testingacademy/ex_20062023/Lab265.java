package com.testingacademy.ex_20062023;

import groovy.json.JsonOutput;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Lab265 {
    @Description("TC1")
    @Test
    public void myTest1() {
     //   System.out.println("Hello");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Samarth","Samarth","First assertion failed");
        System.out.println("End of the program 1");
        softAssert.assertAll();


    }
    @Description("TC2")
    @Test
    public void myTest2() {
        //   System.out.println("Hello");
        Assert.assertEquals("Samarth","Smarth","Second assertion failed");
        System.out.println("End of the program 2");


    }

}

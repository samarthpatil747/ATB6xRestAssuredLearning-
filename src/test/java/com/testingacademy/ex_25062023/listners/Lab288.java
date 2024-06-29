package com.testingacademy.ex_25062023.listners;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListner.class)
public class Lab288 {

    @Test
    public void test1(){
        //code
        System.out.println("Test1");
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        //code
        System.out.println("Test2");
        Assert.assertTrue(false);
    }
    @AfterSuite
    public void emailSendtoQALead(){
        //code
        System.out.println("After suite Executing");
        System.out.println("Sending email");
    }
}

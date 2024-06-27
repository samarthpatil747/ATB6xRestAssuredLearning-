package com.testingacademy.ex_22062023.CRUD.Full;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab276 {
    @BeforeTest()
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void bookinId(){
        System.out.println("2");
    }

    @Test()
    public void t1(){
        System.out.println("3");
    }
}

package com.testingacademy.ex_25062023;

import org.testng.annotations.Test;

public class Lab281 {

    @Test
    public void getToken(){
        System.out.println("Get Token");
    }

    @Test
    public void getBookingID(){
        System.out.println("Login");
    }
    @Test
   public void serverStartOk() {
        System.out.println("Server started");
    }

    @Test (dependsOnMethods = {"serverStartOk"})
    public void method1() {
        System.out.println("method1");
    }
    @Test(dependsOnMethods = {"method1"})
            public void  method2()
    {
        System.out.println("method2");
    }
}

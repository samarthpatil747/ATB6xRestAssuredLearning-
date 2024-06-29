package com.testingacademy.ex_25062023;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Lab282 {
    @Description("This is for token")
    @Test ()
    public void getToken()
    {
        System.out.println("token");
    }
    @Description ("This is for bookingId")
    @Test
    public void getBookinId()
    {
        System.out.println("bookingId");
    }

    @Test(dependsOnMethods = {"getToken","getBookinId"})
    public void testPut()
    {
        System.out.println("testPut");
    }
    @Test(dependsOnMethods = {"getToken", "getBookinId"})
    public void testDeleteReq()
    {
        System.out.println("testDeleteReq");
    }
}

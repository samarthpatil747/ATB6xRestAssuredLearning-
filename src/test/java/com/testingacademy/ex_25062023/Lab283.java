package com.testingacademy.ex_25062023;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class Lab283 {
    @Description("This is for token")
    @Test(groups = {"init"}, priority = 1)
    public void getToken() {
        System.out.println("token");
    }

    @Description("This is for bookingId")
    @Test(groups = {"init"}, priority = 2)
    public void getBookinId() {
        System.out.println("bookingId");
    }

    @Test(dependsOnGroups = {"init.*"})
    public void testPut() {
        System.out.println("testPut");
    }

}

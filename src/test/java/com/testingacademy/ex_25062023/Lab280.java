package com.testingacademy.ex_25062023;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab280 {
    // grouping of Test cases.
    @Issue("ID123")
    @AllureId("TC#1")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sabuty TestCase")
    @Test(groups = {"sanity","prod"})
    public void sanity() {
        System.out.println("Sanity");
    }
    @AllureId("TC#2")
    @Test(groups = "QA")
    public void integration() {
        System.out.println("integration");
    }
    @Test(groups = {"sanity","QA"})
    public void regression() {
        System.out.println("regression");
    }
    @Test(groups = "Dev")
    public void smoke() {
        System.out.println("smoke");
        Assert.assertTrue(false);
    }

}

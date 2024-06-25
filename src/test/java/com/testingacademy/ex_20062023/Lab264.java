package com.testingacademy.ex_20062023;

import org.testng.annotations.*;

public class Lab264 {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is beforeSuite");
        System.out.println("Establish Database connection");
        System.out.println("Read CSV file or Excel file");
        System.out.println("Read env or Property file");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass");
    }
    @BeforeGroups
    public void beforeGroups() {
        System.out.println("This is beforeGroups");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is beforeMethod");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is beforeTest");
    }

    // This test method belongs to both groups A and B
    // This test method belongs to groups A and B
    @org.testng.annotations.Test(groups = {"A", "B"})
    public void testCase1() {
        System.out.println("This is testCase1");
    }

    // This test method belongs to group A
    @org.testng.annotations.Test(groups = "A")
    public void testCase2() {
        System.out.println("This is testCase2");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is afterTest");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("This is afterMethod");
    }
    @AfterGroups
    public void afterGroups() {
        System.out.println("This is afterGroups");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("This is afterClass");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("This is afterSuite");
        System.out.println("Close Database connection");
        System.out.println("Closed open file");
    }
    // This test method belongs to group A
    // This test method belongs to group B
}

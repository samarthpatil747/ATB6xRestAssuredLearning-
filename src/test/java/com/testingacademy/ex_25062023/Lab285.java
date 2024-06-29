package com.testingacademy.ex_25062023;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab285 {
    //Data driven testing - TestNg
    // Mix data driven with the appache poi
    // Data driven testing - Running a single test case with multiple inputs
    // Login test case 100 -U/P
    //
    Faker faker = new Faker();
    String username = faker.name().firstName();
    String password = faker.internet().password();
    @DataProvider
    public  Object [][] getData()
    {
       return new Object[][]{
            new Object[]{username, password},
            new Object[]{"admin", "password"},
            new Object[]{"admin", "password123"}
       };

    }
    @DataProvider
    public Object[][] getDataFromExcel(){
        return null;
    };

    @Test(dataProvider = "getData")
    public void testGetAuthToken(String username, String password) {
        System.out.println(username+"\t"+password);
     //   System.out.println(password);

        // Rest assured Logic
        //Rest given()->when()->then()-> status 200 OK or Response


    }
}

package com.testingacademy.ex_20062023;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab261 {

    @Description("Verify Test case 1 in 261 file")
    @Test
    public void getRequest() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/ping")
                .when().get().then().statusCode(201);
    }

    @Description("Verify Test case 1 in 261 file")
    @Test
    public void getRequest2() {
        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("/ping")
                .when().get().then().statusCode(201);
    }
}

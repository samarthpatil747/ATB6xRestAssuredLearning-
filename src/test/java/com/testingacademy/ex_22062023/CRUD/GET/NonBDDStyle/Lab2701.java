package com.testingacademy.ex_22062023.CRUD.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab2701 {

    @Test
    public  void getRequestPositive(){
        RequestSpecification rs = RestAssured.given();

        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/2002").log().all();
        rs.when().get();
        rs.then().log().all().statusCode(200);

    }
    @Test
    public  void getRequestNegative(){
        RequestSpecification rs = RestAssured.given();

        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/-1").log().all();
        rs.when().get();
        rs.then().log().all().statusCode(200);

    }


}

package com.testingacademy.ex_22062023.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab275 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "63ac4c6366d4f27";
    String bookingID = "2039";
    String Baseurl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking";


    @Test
    public void testDeleteRequestNonBdd() {
        String BasePath = endpoint + "/" + bookingID;
        System.out.println(BasePath);
        r.baseUri(Baseurl);
        r.basePath(BasePath);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.log().all();

        response = r.when().log().all().delete();
        vr = response.then().log().all();
        vr.statusCode(201).log().all();


    }
}

package com.testingacademy.ex_22062023.CRUD.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab274 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "0bd9a1b7253a5c3";
    String bookingID = "1761";
    String Baseurl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking";


    @Test
    public void testPatchRequestNonBdd() {
        String BasePath = endpoint + "/" + bookingID;
        System.out.println(BasePath);
        String payload = "{\n" +
                "    \"firstname\" : \"Samarth\"\n" +
                "}";

        r.baseUri(Baseurl);
        r.basePath(BasePath);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload).log().all();

        response = r.when().log().all().patch();
        vr = response.then().log().all();
        vr.statusCode(200).log().all();
        vr.body("firstname", Matchers.equalTo("Samarth"));


    }
}

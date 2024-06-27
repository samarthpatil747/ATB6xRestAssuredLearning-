package com.testingacademy.ex_22062023.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class Lab273 {
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String token = "0bd9a1b7253a5c3";
    String bookingID = "1761";
    String Baseurl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking";



    @Test
    public void testPutrequestNonBdd() {
        String BasePath = endpoint +"/"+ bookingID;
        System.out.println(BasePath);
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast,lunch\"\n" +
                "}";

        r.baseUri(Baseurl);
        r.basePath(BasePath);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.body(payload).log().all();

        response = r.when().log().all().put();
        vr = response.then().log().all();
        vr.statusCode(200).log().all();
        vr.body("firstname", Matchers.equalTo("James"));
        vr.body("lastname", Matchers.equalTo("Brown"));



    }
}

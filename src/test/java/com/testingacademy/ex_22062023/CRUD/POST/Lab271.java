package com.testingacademy.ex_22062023.CRUD.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab271 {
    // BDD style
    String Baseurl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking";
    String payload = "{\n" +
            "    \"firstname\": \"John\",\n" +
            "    \"lastname\": \"Doe\",\n" +
            "    \"totalprice\": 123,\n" +
            "    \"depositpaid\": true,\n" +
            "    \"bookingdates\": {\n" +
            "        \"checkin\": \"2018-01-01\",\n" +
            "        \"checkout\": \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\": \"Breakfast\"\n" +
            "}";
    String nullBody = "{}";
    String contentType = "application/json";
    RequestSpecification request;
    ValidatableResponse validatableResponse;
    Response response;
@Description ("This is to test a POST request with BDD style with valid payload")
    @Test(priority = 1)
    public void testBDDstylePostPositive() {
        // Set up the request
        // URL Send the request
        // Body/payload/json Validate the response
        // Header content type


        RestAssured.given().baseUri(Baseurl).basePath(endpoint).contentType(ContentType.JSON)
                .auth().none().log().all().body(payload)
                .when().post()
                .then().log().all().statusCode(200);

    }
@Description ("This is to test a POST request with non BDD style with valid payload")
    @Test(priority = 2)
    public void testNonBDDstylePostPositive() {
        // Set up the request
        // URL Send the request
        // Body/payload/json Validate the response
        // Header content type
        RequestSpecification request = RestAssured.given();

        request.baseUri(Baseurl);
        request.basePath(endpoint);
        request.contentType(ContentType.JSON);
        request.auth().none();

        request.log().all().body(payload);

        response = request.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();

        validatableResponse.log().all().statusCode(200);

    }
    @Description ("This is to negative test a POST request with non BDD style with invalid payload with 500 error")
    @Test(priority = 3)
    public void testNonBDDstylePostNegative() {
        // Set up the request
        // URL Send the request
        // Body/payload/json Validate the response
        // Header content type
        request = RestAssured.given();
        request.baseUri(Baseurl);
        request.basePath(endpoint);
        request.contentType(ContentType.JSON);
        request.auth().none();
        request.log().all().body(nullBody);

        response = request.when().log().all().post();

        validatableResponse = response.then();

        validatableResponse.log().all().statusCode(500);

    }
}

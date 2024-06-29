package com.testingacademy.ex_27062023;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Lab290 {
    // PayloadUsingMap
    // POST req -> payload -> string
   /* "firstname" : "John",
    "lastname" : "Doe",
    "age" : 30,
    "address" : {
        "street" : "123 Main St",
        "city" : "Anytown",
        "state" : "CA",
        "zip" : "12345"
    }*/
    // MAP
    RequestSpecification r = RestAssured.given();
    Response response;
    ValidatableResponse vr;
    String Baseurl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking";

    @Test
    public void testPostUsingMap() {
        // Code to test payload using Map
        // ...
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();


        jsonBodyUsingMap.put("firstName", firstName);
        jsonBodyUsingMap.put("lastName", lastName);
        jsonBodyUsingMap.put("totalPrice", faker.random().nextInt(100));
        jsonBodyUsingMap.put("depositPaid", faker.random().nextBoolean());
        Map<String, Object> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "12/2/2024");
        bookingDatesMap.put("checkout", "13/2/2024");
        jsonBodyUsingMap.put("bookingDates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalNeeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);


        RequestSpecification request = RestAssured.given();

        request.baseUri(Baseurl);
        request.basePath(endpoint);
        request.contentType(ContentType.JSON);
        request.auth().none();

        request.log().all().body(jsonBodyUsingMap);

        response = request.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();

        vr.log().all().statusCode(200);


    }
}

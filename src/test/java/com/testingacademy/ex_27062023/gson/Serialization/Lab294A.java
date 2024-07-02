package com.testingacademy.ex_27062023.gson.Serialization;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Lab294A {

    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_path = "/booking";

    RequestSpecification request;
    ValidatableResponse validatableResponse;
    Response response;


    @Description("This is to test a POST request with non BDD style with valid payload")
    @Test(priority = 1)
    public void testNonBDDstylePostPositive() {
        // Set up the request
        // URL Send the request
        // Body/payload/json Validate the response
        // Header content type
        Booking booking1 = new Booking();
        booking1.setFirstname("Jones");
        booking1.setLastname("Brown");
        booking1.setTotalprice(1341);
        booking1.setDepositpaid(false);
        BookingDates bookingDates1 = new BookingDates();
        bookingDates1.setCheckin("2018-01-01");
        bookingDates1.setCheckout("2019-01-01");
        booking1.setBookingDates(bookingDates1);
        booking1.setAdditionalNeeds("Breakfast");
        System.out.println("Booking1 String data:" + booking1.toString());

        System.out.println(booking1);
        // Serialization -> Java -> POJO Booking -> Object -> JsonString

        Gson gson = new Gson();
        String jsonStringPayload = gson.toJson(booking1);
        System.out.println(jsonStringPayload);

//        RequestSpecification request = RestAssured.given();
//
//        request.baseUri(Base_Url);
//        request.basePath(Base_path);
//        request.contentType(ContentType.JSON).log().all();
//
//        request.body(payload);
//
//        response = request.when().log().all().post();
//        String responseString = response.asString();
//        System.out.println(responseString);
//
//        validatableResponse = response.then();
//
//        validatableResponse.statusCode(200);

    }
}



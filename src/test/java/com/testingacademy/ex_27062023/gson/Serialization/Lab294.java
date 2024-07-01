package com.testingacademy.ex_27062023.gson.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lab294 {
    String Baseurl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking";

    RequestSpecification request;
    ValidatableResponse validatableResponse;
    Response response;


    @Description ("This is to test a POST request with non BDD style with valid payload")
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
        System.out.println("Booking1 String data:"+booking1.toString());


        Booking booking2 = new Booking();
        booking2.setFirstname("James");
        booking2.setLastname("White");
        booking2.setTotalprice(1111);
        booking2.setDepositpaid(true);
        BookingDates bookingDates2 = new BookingDates();
        bookingDates2.setCheckin("2024-02-01");
        bookingDates2.setCheckout("2024-02-01");
        booking2.setBookingDates(bookingDates2);
        booking2.setAdditionalNeeds("Brunch");
        System.out.println("Booking2 String data:"+booking2.toString());

        ArrayList payload = new ArrayList();
        payload.add(booking1);
        payload.add(booking2);
        System.out.println(payload);

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
}

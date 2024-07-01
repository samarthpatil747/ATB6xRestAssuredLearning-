package com.testingacademy.ex_27062023.gson.Serialization;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab293 {
    RequestSpecification r = RestAssured
            .given();

    Response response;

    ValidatableResponse validatableResponse;


    @Description("Create booking with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        Booking booking = new Booking();
        booking.setFirstname("Jo");
        booking.setLastname("Brown");
        booking.setTotalprice(-1);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        System.out.println(booking.toString());


        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(booking);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(200);


    }

    @Description("TC 2 - Verify that create booking not working, with 500 Error")
    @Test
    public void testNonBDDStylePOSTNegative() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String payload = "{}";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then();
        validatableResponse.statusCode(500);




    }
}

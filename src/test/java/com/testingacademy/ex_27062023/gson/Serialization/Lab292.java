package com.testingacademy.ex_27062023.gson.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import com.testingacademy.ex_27062023.gson.Serialization.Booking;
import com.testingacademy.ex_27062023.gson.Serialization.BookingDates;

public class Lab292 {
    // Payload - String, Map
    // Most used - Class and Objects
    // Swagger API - Document

    // Payload -> RA -> Class/ Object -> JSONString (Who Help, Library) -> Serialisation
    // Response -> JSONString -> Object (Deserialisation)


    RequestSpecification request = RestAssured.given();;
    ValidatableResponse validatableResponse;
    Response response;


    @Description ("This is to test a POST request with non BDD style with valid payload")
    @Test(priority = 1)
    public void testNonBDDstylePostPositive() {
        String Baseurl = "https://restful-booker.herokuapp.com";
        String endpoint = "/booking";

        Booking booking = new Booking();
        booking.setFirstName("Jim");
        booking.setLastName("Brown");
        booking.setPrice(111);
        booking.setPaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-02-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        System.out.println("Booking String Data ="+booking.toString());

        request.baseUri(Baseurl);
        request.basePath(endpoint);
        request.contentType(ContentType.JSON).log().all();
        request.body(booking).log().all();

        response = request.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200).log().all();

    }



}

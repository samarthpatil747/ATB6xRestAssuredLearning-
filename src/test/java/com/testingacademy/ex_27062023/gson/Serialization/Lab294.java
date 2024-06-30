package com.testingacademy.ex_27062023.gson.Serialization;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab294 {
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



    @Description ("This is to test a POST request with non BDD style with valid payload")
    @Test(priority = 1)
    public void testNonBDDstylePostPositive() {
        // Set up the request
        // URL Send the request
        // Body/payload/json Validate the response
        // Header content type
        Booking booking = new Booking();
        booking.setFirstName("Jones");
        booking.setLastName("Brown");
        booking.setPrice(1341);
        booking.setPaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        System.out.println(booking.toString());
        RequestSpecification request = RestAssured.given();

        request.baseUri(Baseurl);
        request.basePath(endpoint);
        request.contentType(ContentType.JSON);
        request.auth().none();

        request.log().all().body(booking);

        response = request.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse = response.then();

        validatableResponse.log().all().statusCode(200);

    }
}

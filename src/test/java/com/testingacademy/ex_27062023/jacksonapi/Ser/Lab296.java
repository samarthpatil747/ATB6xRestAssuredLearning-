package com.testingacademy.ex_27062023.jacksonapi.Ser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testingacademy.ex_27062023.gson.Serialization.Booking;
import com.testingacademy.ex_27062023.gson.Serialization.BookingDates;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Lab296 {
    String Base_Url = "https://restful-booker.herokuapp.com";
    String Base_path = "/booking";

    RequestSpecification request;
    ValidatableResponse validatableResponse;
    Response response;


    @Test
    public void serJackson() throws JsonProcessingException {
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

        System.out.println(booking1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking1);
        System.out.println(jsonString);

    }
}

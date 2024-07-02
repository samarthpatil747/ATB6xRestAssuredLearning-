package com.testingacademy.ex_27062023.gson.Deserialization;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.testingacademy.ex_27062023.gson.Serialization.Booking;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab295 {
    @Test
    public void deSerializationTest() {
        String jsonString = "{\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Gson gson = new Gson();
        Booking booking = gson.fromJson(jsonString, Booking.class);
        System.out.println(booking.toString());
        System.out.println(booking.getLastname());

        Assert.assertEquals(booking.getFirstname(),"Jim");
    }
}

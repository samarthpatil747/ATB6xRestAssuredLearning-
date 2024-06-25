package com.testingacademy.ex_20062023;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lab267 {

// Curd
    // Create booking -> ID
    // Create Auth -> Token
    // Put -> ID, Token
    // Delete -> ID, Token
    // Get -> ID, Token

    String token;
    Integer bookingId;
    public String getToken()
{
    token = "1234567890";
    return token;
}
@BeforeTest
    public void getTokenAndBookingId() {
        token = getToken();
        //Post
        // code
        bookingId = 123;

    }
    @Test
    public void testPutReq() {
        //Put
        System.out.println(token);
        // code
        System.out.println(bookingId);
    }

    @Test
    public void testDeleteReq() {
        //Delete
        System.out.println(token);
        // code
        System.out.println(bookingId);
    }
    @Test
    public void testGetReq() {
        //Get
        System.out.println(token);
        // code
        System.out.println(bookingId);
    }



}

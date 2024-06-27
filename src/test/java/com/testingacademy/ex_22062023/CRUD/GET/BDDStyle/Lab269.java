package com.testingacademy.ex_22062023.CRUD.GET.BDDStyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Lab269 {
// Two ways to create RA Testcase
    // BDD style - Given,when,then
    // Non BDD style - Class and Object

    // REQUEST
    // Getreq = https://zippopotam.us/in/{Pincode}
    // URL =
    // Path = /in/pincode
    // Auth = basic,digest,JWT,Bearer Token,OAuth 2.0 ? = No
    // query
    // header
    // get mothod
    // body / payload

    //VERIFICATION
    // status code
    // response body
    // response header,time,cookies
    // response status code

    //TWO FORMAT
    // BDD Style - Given, when, then
    //

    @Test
    public void getReqBDDStyle() {
        RestAssured.given()
                .baseUri("https://zippopotam.us")
                .basePath("/in/413517")
                .when().log().all()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}

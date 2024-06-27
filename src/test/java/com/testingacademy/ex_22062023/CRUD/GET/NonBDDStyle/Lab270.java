package com.testingacademy.ex_22062023.CRUD.GET.NonBDDStyle;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab270 {
    //Two ways to create RA Testcase
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

    @Test
    public void getRequstNonBDDstyle() {
     /*   // Create a new instance of the GetRequest class
        GetRequest getRequest = new GetRequest();

        // Set the URI for the GET request
        getRequest.setUri("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        // Execute the GET request and get the response
        Response response = getRequest.execute();

        // Print the response body
        System.out.println(response.getBody());*/

        System.out.println("Non BDD style");
        RequestSpecification rs = RestAssured.given();
        rs.baseUri("https://zippopotam.us");
        rs.basePath("/in/413517");
        rs.when().log().all().get();
        rs.then().log().all().statusCode(2010);
    }
}

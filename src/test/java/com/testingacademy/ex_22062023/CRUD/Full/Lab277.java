package com.testingacademy.ex_22062023.CRUD.Full;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Lab277 {
    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;
    String BaseURI = "https://restful-booker.herokuapp.com";

    @BeforeTest()
    public void getToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri(BaseURI);
        requestSpecification.basePath("/auth");
        System.out.println("URL="+BaseURI+"/auth");
        requestSpecification.body(payload);
        requestSpecification.contentType(ContentType.JSON);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println("Response String ="+responseString);
        validatableResponse.statusCode(200);


        //Extract the token
        //token = response.jsonPath().getString("token");
        token = response.then().extract().path("token");
        System.out.println("Token ="+token);
        Assert.assertNotNull(token);

    }

    @BeforeTest
    public void bookinId() {
        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification.baseUri(BaseURI);
        requestSpecification.basePath("/booking");
        System.out.println("URL="+BaseURI + "/booking");
        requestSpecification.body(payload);
        requestSpecification.contentType(ContentType.JSON);

        response = requestSpecification.when().post();

        validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println("Response String ="+responseString);
        validatableResponse.statusCode(200);

        //Extract the bookingId
        bookingId = response.then().log().all().extract().path("bookingid");
        System.out.println("BookingID="+bookingId);
        String firstname = response.then().extract().path("booking.firstname");
        System.out.println("FirstName="+firstname);
        Assert.assertNotNull(bookingId);
    }

    @Test
    public void testPutPositiveRequest() {
        String payload = "{\n" +
                "    \"firstname\" : \"Samarth\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(BaseURI);
        requestSpecification.basePath("/booking/" + bookingId);
        requestSpecification.body(payload).log().all();
        requestSpecification.contentType(ContentType.JSON);

        //     requestSpecification.header("Cookie", "token=" + token);
        requestSpecification.cookie("token", token);
        // Put request
        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String fullresponseString = response.asString();
        System.out.println(fullresponseString);

        String firstNameResponse = response.then().extract().path("firstname");
       Assert.assertEquals(firstNameResponse,"Samarth");

       // 3 way to verify response
        // 1. RA Matchers.
        validatableResponse.body("firstname", Matchers.equalTo("Samarth"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));

        // 2. TestNG Asserts
        String firstNameResponse2 =  response.then().extract().path("firstname");
        Assert.assertEquals(firstNameResponse2, "Samarth");
        // 3. Assertion with JSON path
        JsonPath jsonPath = new JsonPath(fullresponseString);
        String firstnameJSONExtracted = jsonPath.getString("firstname");
        String lastnameJSONExtracted = jsonPath.getString("lastname");
        Integer totalpriceJSONExtracted = jsonPath.getInt("totalprice");
        String checkinJSONExtracted = jsonPath.getString("bookingdates.checkin");
        String checkoutJSONExtracted = jsonPath.getString("bookingdates.checkout");

        Assert.assertEquals(firstnameJSONExtracted,"Samarth");
        Assert.assertEquals(lastnameJSONExtracted, "Brown");
        Assert.assertEquals(totalpriceJSONExtracted, Integer.valueOf(111));
        Assert.assertEquals(checkinJSONExtracted, "2018-01-01");
        Assert.assertEquals(checkoutJSONExtracted, "2019-01-01");

        // JSON Array Response

        String checkin =  jsonPath.getString("[0][\"bookingdates\"][\"checkin\"]");
        System.out.println("Checkin ="+checkin);


        // 3. AssertJMatching
        assertThat(firstnameJSONExtracted).isNotBlank().isEqualTo("Samarth")
                .contains("Samarth").hasSizeGreaterThan(1);
        assertThat(totalpriceJSONExtracted).isNotEqualTo(0).isNotNegative();


    }
}

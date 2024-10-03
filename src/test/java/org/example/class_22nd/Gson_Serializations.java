package org.example.class_22nd;

import com.google.gson.Gson;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Gson_Serializations {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    public java.lang.String token;
    public java.lang.String bookingId;

    @Description("verify post request")
    @Test
    public void test_post(){

        Booking booking = new Booking();
        booking.setFirstname("yadraj");
        booking.setLastname("shinde");
        booking.setDepositpaid(true);
        booking.setTotalprice(400);
        booking.setAdditionalneeds("Lunch");


        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("23-1-024");
        bookingdates.setCheckout("23-1-024");

        booking.setBookingdates(bookingdates);

        Gson gson = new Gson();
        String payload_gson = gson.toJson(booking);


        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(payload_gson);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);

         

    }
}

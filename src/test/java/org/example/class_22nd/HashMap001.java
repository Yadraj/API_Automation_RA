package org.example.class_22nd;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMap001 {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public  void test_HashMap(){


        Map<String,Object> hashmap_payload = new LinkedHashMap<>();
        hashmap_payload.put("firstname","Jim");
        hashmap_payload.put("lastname","Brown");
        hashmap_payload.put("totalprice","111");
        hashmap_payload.put("depositpaid","true");

        Map<String,Object>  bookingdates_value = new LinkedHashMap<>();
        bookingdates_value.put("checkin","2018-01-01");
        bookingdates_value.put("checkout","2018-01-01");

        hashmap_payload.put("bookingdates",bookingdates_value);



        hashmap_payload.put("additionalneeds","Breakfast");
        System.out.println(hashmap_payload);



        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(hashmap_payload);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String  bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);





    }
}

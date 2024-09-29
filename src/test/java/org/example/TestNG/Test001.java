package org.example.TestNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test001 {

    @Test
    public  void test_get(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");

        Response response = r.when().get();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }

}

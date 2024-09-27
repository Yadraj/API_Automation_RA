package org.example;
import io.restassured.RestAssured;

public class Demo {

    public static void main(String[] args) {

        System.out.println("hi");

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1").log().all()
                .when().get()
                .then().log().all().statusCode(200);

    }
}

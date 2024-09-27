package org.example.CRUD.POST;
import java.lang.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDD_Style {
    public static void main(String[] args) {

        java.lang.String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .body(payload)
                .contentType(ContentType.JSON)
                .when().post()
                .then().log().all().statusCode(200);
    }
}

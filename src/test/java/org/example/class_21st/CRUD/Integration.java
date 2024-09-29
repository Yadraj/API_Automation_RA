package org.example.class_21st.CRUD;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Integration {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    java.lang.String token;
    java.lang.String bookingId;


    @Test
    public String getToken(){

        java.lang.String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/auth");
        requestSpecification.body(payload);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        token = response.jsonPath().getString("token");
        System.out.println(token);
        System.out.println("hi");
        return token;

    }


    public String getBookingId(){

        java.lang.String payload1 = "{\n" +
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

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.body(payload1);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);
        System.out.println("hi");
        return bookingId;



    }

    @Test
    public void test_put(){

        String token = getToken();
        String bookingId=getBookingId();

        java.lang.String payload_put = "{\n" +
                "    \"firstname\" : \"yadraj\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking"+bookingId);
        requestSpecification.body(payload_put);
        requestSpecification.cookie("token",token);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().put();

        ValidatableResponse validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

    }
    @Test
    public void test_get(){

    }
    @Test
    public void test_delete(){

    }

    @Test
    public void test_get_after_delete(){

    }
}

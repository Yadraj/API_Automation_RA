package org.example.class_22nd;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;


public class JsonPath001 {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;


    @Test
    public void test_json(){

        java.lang.String payload_json = "{\n" +
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
        requestSpecification.body(payload_json);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        System.out.println(response.asString());

        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        String checkindate = jsonPath.getString("booking.bookingdates.checkin");

        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkindate);

        assertThat(bookingId).isNotNull().isNotBlank();
        assertThat(firstname).isNotNull().isNotBlank().isEqualTo("Jim");


    }

}

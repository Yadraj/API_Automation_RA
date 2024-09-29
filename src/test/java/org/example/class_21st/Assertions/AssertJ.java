package org.example.class_21st.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class AssertJ {

    @Test
    public void test_put() {

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
        requestSpecification.basePath("/booking");
        requestSpecification.body(payload_put);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);

       Integer  bookingId = response.then().extract().path("bookingid");
        assertThat(bookingId).isNotNull();
        String firstname1= response.then().extract().path("booking.firstname");
        assertThat(firstname1).isEqualTo("yadraj");


    }
}

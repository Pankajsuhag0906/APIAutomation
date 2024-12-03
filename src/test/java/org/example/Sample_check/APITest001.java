package org.example.Sample_check;

import io.restassured.RestAssured;

public class APITest001 {
    public static void main(String[] args) {
        RestAssured.given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/booking/232")
                .when().get()
                .then().log().all();


    }
}

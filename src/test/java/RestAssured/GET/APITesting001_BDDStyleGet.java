package RestAssured.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting001_BDDStyleGet {

    @Test
    public void test_GET_Req_Positive() {

        String pincode = "124001";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void test_GET_Req_Negative() {

        String pincode = "-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .log().all().get()
                .then()
                .log().all().statusCode(200);


    }
}

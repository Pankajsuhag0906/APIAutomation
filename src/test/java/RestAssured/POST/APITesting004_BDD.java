package RestAssured.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting004_BDD {

    @Test
    public void test_post(){

        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/auth")
                        .contentType(ContentType.JSON)
                        .body(payload).log().all()
                    .when().log().all().post()
                    .then().log().all().statusCode(200);
//
    }
}

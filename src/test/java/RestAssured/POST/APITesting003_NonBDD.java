package RestAssured.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting003_NonBDD {
    @Test
    public void test_post(){
        RequestSpecification r= RestAssured.given();

         String payload="{\n" +
                 "    \"username\" : \"admin\",\n" +
                 "    \"password\" : \"password123\"\n" +
                 "}";

         r.baseUri("https://restful-booker.herokuapp.com")
                 .basePath("/auth")
                 .contentType(ContentType.JSON)
                 .body(payload).log().all()
         .when().log().all().post()
         .then().log().all().statusCode(200);

    }
}

package RestAssured.GET;

import io.restassured.RestAssured;
import io.restassured.internal.proxy.RestAssuredProxySelector;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITesting002_NonBDDStyleGET {
    @Test
    public void test_GET_Req_Positive() {
        RequestSpecification r=RestAssured.given();
        String pincode = "124001";

                r.baseUri("https://api.zippopotam.us");
                r.basePath("/IN/" + pincode);
                r.when().log().all().get();
                r.then().log().all().statusCode(200);

    }
}

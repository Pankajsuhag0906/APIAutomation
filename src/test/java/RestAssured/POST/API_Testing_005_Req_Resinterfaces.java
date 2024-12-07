package RestAssured.POST;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class API_Testing_005_Req_Resinterfaces {

    @Test
    public void test_PUT(){
    String token="2b9e47d2b2c1b02";
    int booking_id=1577;
    String payload="{\n" +
            "    \"firstname\" : \"Pankaj\",\n" +
            "    \"lastname\" : \"Suhag\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2024-01-01\",\n" +
            "        \"checkout\" : \"2024-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

            RequestSpecification r=RestAssured.given();

            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/"+booking_id);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);
            r.body(payload).log().all();


            Response response=r.when().put();

           ValidatableResponse validateresponse = response.then().log().all();
           validateresponse.statusCode(200);






    }




}

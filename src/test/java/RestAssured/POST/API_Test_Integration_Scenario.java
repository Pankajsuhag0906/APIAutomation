package RestAssured.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import org.hamcrest.Matchers;


public class API_Test_Integration_Scenario {

    // Create a Token
    // Create a Booking
    // Create a PUT request
    // Verify that PUT is success by GET request
    // Delete the ID
    // Verify that it doesn't exist by GET request

    RequestSpecification r;
    Response response;
    ValidatableResponse validatable_response;

    String token;
    String booking_id;


    @BeforeTest
    public String get_token()
    {
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);
        response = r.when().post();
        validatable_response =response.then();
        validatable_response.statusCode(200);
        token=response.jsonPath().getString("token");

        // ValidatableResponse Assertions
        validatable_response.body("token",Matchers.notNullValue());

        // Assertj Assertions
        assertThat("token").isNotNull().isNotBlank().isNotEmpty().isAlphanumeric();
        System.out.println(token);
        return token;

    }
    @BeforeTest
    public String get_id()
    {

        String payload_post="{\n" +
                "    \"firstname\" : \"Parveen\",\n" +
                "    \"lastname\" : \"Vashsith\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        r=RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload_post).log().all();
        response=r.when().post();
        validatable_response =response.then().log().all();
        validatable_response.statusCode(200);

        booking_id=response.jsonPath().getString("bookingid");

        // validatableResponse Assertions
        validatable_response.body("bookingid",Matchers.notNullValue());

        // Assertj assertions
        assertThat("booking_id").isNotNull().isNotEmpty().isNotBlank();
        System.out.println(booking_id);
        return booking_id;

    }

        @Test(priority =1)
        public void test_update_request_put()
        {
            token=get_token();
            booking_id=get_id();
            System.out.println(booking_id);
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

            r=RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/"+booking_id);
            r.contentType(ContentType.JSON);
            r.cookie("token",token);
            r.body(payload).log().all();

            response=r.when().put();
            validatable_response =response.then().log().all();
            validatable_response.statusCode(200);
            String firstname=response.then().extract().path("firstname");
            String lastname=response.then().extract().path("lastname");

            System.out.println("firstname =" + firstname);
            assertThat(firstname).isEqualTo("Pankaj");
            assertThat(lastname).isEqualTo("Suhag");


//            String token=get_token();
//            System.out.println(token);
//
//            String bookingid=get_id();
//            System.out.println(bookingid);
        }

        @Test (priority =2)
        public void test_update_request_get(){

            System.out.println(booking_id);
            r=RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/"+booking_id);

            response=r.when().log().all().get();
            validatable_response=response.then();
            validatable_response.statusCode(200);

            String firstname=response.then().extract().path("firstname");
            assertThat(firstname).isEqualTo("Pankaj");
        }

        @Test(priority = 3)
        public void test_delete_request(){

            r=RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/"+ booking_id);

            r.contentType(ContentType.JSON);
            r.cookie("token",token);

            response=r.when().delete();
            validatable_response =response.then().log().all();
            validatable_response.statusCode(201);
        }

        @Test(priority = 4)
        public void test_get_after_delete(){
            System.out.println(booking_id);
            r=RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking/"+ booking_id);

            response=r.when().log().all().get();
            validatable_response=response.then();
            validatable_response.statusCode(404);
        }
}

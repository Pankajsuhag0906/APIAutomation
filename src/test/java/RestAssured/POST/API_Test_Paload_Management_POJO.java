package RestAssured.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class API_Test_Paload_Management_POJO {

    // Create a Booking

    RequestSpecification r;
    Response response;
    ValidatableResponse validatable_response;
    String booking_id;

        @Test
    public void test_create_booking(){

//            String payload_post="{\n" +
//                    "    \"firstname\" : \"Parveen\",\n" +
//                    "    \"lastname\" : \"Vashsith\",\n" +
//                    "    \"totalprice\" : 111,\n" +
//                    "    \"depositpaid\" : true,\n" +
//                    "    \"bookingdates\" : {\n" +
//                    "        \"checkin\" : \"2018-01-01\",\n" +
//                    "        \"checkout\" : \"2019-01-02\"\n" +
//                    "    },\n" +
//                    "    \"additionalneeds\" : \"Breakfast\"\n" +
//                    "}

            Booking booking=new Booking();
            booking.setFirstname("Parveen");
            booking.setLastname("Vashisth");
            booking.setTotalprice(123);
            booking.setDepositpaid(true);

            BookingDates bookingDates=new BookingDates();
            bookingDates.setCheckin("2024-01-01");
            bookingDates.setCheckout("2024-01-02");

            booking.setBookingDates(bookingDates);
            booking.setAdditionalneeds("Lunch");


            r=RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking");
            r.contentType(ContentType.JSON).log().all();
            r.body(booking).log().all();
            response=r.when().post();
            validatable_response =response.then().log().all();
           // validatable_response.statusCode(200);

         //   booking_id=response.jsonPath().getString("bookingid");

            // validatableResponse Assertions
           // validatable_response.body("bookingid",Matchers.notNullValue());

            // Assertj assertions
         //   assertThat("booking_id").isNotNull().isNotEmpty().isNotBlank();
           // System.out.println(booking_id);
        }
        //

}
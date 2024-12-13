package RestAssured.POST;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class API_Test_Paload_Management_POJO_GSON_demo {

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
//                    "        \"checkout\" : \"2018-01-02\"\n" +
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

            //Convert object into JSON string
            Gson gson=new Gson();
            String jsonStringBooking=gson.toJson(booking);
            System.out.println(jsonStringBooking);


            r=RestAssured.given();
            r.baseUri("https://restful-booker.herokuapp.com");
            r.basePath("/booking");
            r.contentType(ContentType.JSON).log().all();
            r.body(jsonStringBooking).log().all();
            response=r.when().post();
            validatable_response =response.then().log().all();

            BookingResponse bookingResponse=gson.fromJson(jsonStringBooking,BookingResponse.class);

           // assertThat(bookingResponse.getBookingid()).isNotNull();
          //  assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Parveen");
        }

}
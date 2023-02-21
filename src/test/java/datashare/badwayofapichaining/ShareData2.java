package datashare.badwayofapichaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class ShareData2 {
	
	@Test(priority = 2)
	void getBooking() {
		given()
        .contentType(ContentType.JSON)
        
        .when()
        .get("https://restful-booker.herokuapp.com/booking/"+ShareData.bookingID)
        .then()
        .log().all().extract().response();
	}

}

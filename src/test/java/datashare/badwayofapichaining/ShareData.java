package datashare.badwayofapichaining;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class ShareData {
	
	public static int bookingID; //this variable is common to all the testcases
	
	// 50 class , each class having 3 testcases ( @Test - 1 testcase)
	
	@Test(priority = 1)
    void createBooking() {
        String str="{\r\n"
                + "    \"firstname\" : \"Jim\",\r\n"
                + "    \"lastname\" : \"Brown\",\r\n"
                + "    \"totalprice\" : 111,\r\n"
                + "    \"depositpaid\" : true,\r\n"
                + "    \"bookingdates\" : {\r\n"
                + "        \"checkin\" : \"2018-01-01\",\r\n"
                + "        \"checkout\" : \"2019-01-01\"\r\n"
                + "    },\r\n"
                + "    \"additionalneeds\" : \"Breakfast\"\r\n"
                + "}";
        Response res=
        given()
            .contentType(ContentType.JSON)
            .body(str)
            .when()
            .post("https://restful-booker.herokuapp.com/booking")
            .then()
            .log().all().extract().response();
        JsonPath jo=new JsonPath(res.asString());
        bookingID=jo.getInt("bookingid");
        System.out.println(bookingID);
               
    }
	
	@Test(priority = 2)
	void getBooking() {
		given()
        .contentType(ContentType.JSON)
        
        .when()
        .get("https://restful-booker.herokuapp.com/booking/"+bookingID)
        .then()
        .log().all().extract().response();
	}

}

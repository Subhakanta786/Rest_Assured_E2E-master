package jsonschema;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import java.io.File;

public class CreateBookingWithSchemaValidator {

	// In Rest-Assured, we are getting response from the server , so we can't edit json but we can edit json-schema.
	@Test
	void postrequestWithSchemaValidator() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"firstname\" : \"Pal\",\r\n"
					+ "    \"lastname\" : \"Brown\",\r\n"
					+ "    \"totalprice\" : 111.11,\r\n"
					+ "    \"depositpaid\" : \"True\",\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \"2018-01-01\",\r\n"
					+ "        \"checkout\" : \"2019-01-01\"\r\n"
					+ "    }\r\n"
					+ "}")//string to json internally by rest-assured-->serialization
		.when()
			.post("https://restful-booker.herokuapp.com/booking")
		.then()
			//.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("CreateBookingResponseSchema2.json"))
		//.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\priran\\eclipse-workspace\\RestAssuredPractices\\src\\test\\java\\jsonschema\\CreateBookingResponseSchema2.json")))
		.statusCode(200)
		//.body("firstname.length()")
		.log().all().extract().response();
		
		
		
		
	}
}

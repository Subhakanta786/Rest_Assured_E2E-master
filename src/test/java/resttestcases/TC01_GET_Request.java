package resttestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GET_Request {

	@Test
	void getWeatherDetails() {

		// specify base URI
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/Books");

		// print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: "+responseBody);

		// validate status code
		//int statusCode = response.getStatusCode();
		//System.out.println("Status Code:" + statusCode);
		//Assert.assertEquals(statusCode, 200);

		// validate status code
		String statusLine = response.getStatusLine();
		System.out.println("Status Line:" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}

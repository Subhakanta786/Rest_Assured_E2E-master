package resttestcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_POST_Request {

	@SuppressWarnings("unchecked")
	@Test
	void getWeatherDetails() {

		// specify base URI
		RestAssured.baseURI = "https://reqres.in/";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Request payload sending along with POST request
		JSONObject requestparams = new JSONObject(); // its a kind of hashmap
		requestparams.put("name", "Puju");
		requestparams.put("job", "Automation");

		// wrap with Request object
		httprequest.body(requestparams.toJSONString());

		// Response object
		Response response = httprequest.request(Method.POST, "/api/users");

//		// print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: " + responseBody);
//
//		// validate status code
//		int statusCode = response.getStatusCode();
//		System.out.println("Status Code:" + statusCode);
//		Assert.assertEquals(statusCode, 201);
//
//		// validate status line
//		String statusLine = response.getStatusLine();
//		System.out.println("Status Line:" + statusLine);
//		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");

		// validate value of a particular key which is inside JSON
//		JsonPath js = response.jsonPath(); // its a kind of hashmap
//		String getText = js.get("createdAt");
//		Assert.assertEquals(getText.contains("2022-12-01"), true);

	}

}

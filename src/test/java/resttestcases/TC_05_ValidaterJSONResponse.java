package resttestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_05_ValidaterJSONResponse {
	
	@Test
	void getWeatherDetails() {

		// specify base URI
		RestAssured.baseURI = "https://reqres.in/";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/api/users");
		
//		String responseBody=response.getBody().asPrettyString();
//		
//		System.out.println(responseBody);
		
		//Assert.assertEquals(responseBody.contains("charles.morris@reqres.in"), true);

		JsonPath jsonpath=response.jsonPath(); // its a kind of hashmap
		System.out.println(jsonpath.get("data").toString());
		System.out.println("-------------------------------------------------------");
		System.out.println(jsonpath.get("data[0].email").toString());


	}
	
	
	
}

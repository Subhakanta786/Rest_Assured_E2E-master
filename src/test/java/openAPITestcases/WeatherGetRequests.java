package openAPITestcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class WeatherGetRequests {

// Query parameters in non-bdd
//	RestAssured.baseURI="https://reqres.in";
//	RequestSpecification req= RestAssured.given();
//	//req.queryParams("delay", 3);
//	Response res=req.request(Method.GET,"/api/users?delay=3");

	//@Test
	public void Test_01() {
		given()
		.when()
			.get("http://api.weatherapi.com/v1/current.json?key=0c0afc4b04bb478580f80745232801&q=London&aqi=no")
		.then()
				.log().all();
	}
	
//	@Test
//	public void Test_02() {
//		given()
//			.param("key", "0c0afc4b04bb478580f80745232801")
//			.and()
//			.param("q", "London")
//			.and()
//			.param("aqi", "no")
//		.when()
//			.get("http://api.weatherapi.com/v1/current.json")
//		.then()
//			.log().all();
//		
//	}
	
	@Test
	public void Test_02() {
		
		Response res=
		given()
			.param("key", "Sameer0c0afc4b04bb478580f80745232801")
			.and()
			.param("q", "London")
			.and()
			.param("aqi", "no")
		.when()
			.get("http://api.weatherapi.com/v1/current.json");
		
		Assert.assertEquals(res.getStatusCode(), 400);
		
		if(res.getStatusCode()==200) {
			System.out.println("API is working fine");
		}else {
			System.out.println("API is not working");
		}
		
		
	}

}

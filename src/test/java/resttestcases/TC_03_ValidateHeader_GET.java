package resttestcases;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03_ValidateHeader_GET {
	
	@Test
	void ValidateHeader() {

		// specify base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// print response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body: "+responseBody);

		//Capture details of header from response
		String contentType=response.header("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

	}
	
	@Test
	void PrintallHeaders() {

		// specify base URI
		RestAssured.baseURI = "https://maps.googleapis.com";

		// Request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// print response in console
		String responseBody = response.getBody().asString();
		//System.out.println("Response Body: "+responseBody);

		//capture all the headers from response
		Headers allHeaders=response.headers();
		Map<String,String> hm=new LinkedHashMap<>();
		
		for(Header header:allHeaders) {
			//System.out.println(header.getName()+"-->"+ header.getValue());
			hm.put(header.getName(), header.getValue());
		}
		
		System.out.println(hm);

	}
}

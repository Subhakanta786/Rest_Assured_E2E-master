package nonbddresttestcasesusingtestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC03_GetRequest {

	@Test
	void validateHeaders() {

		// client side
		RestAssured.baseURI = "https://maps.googleapis.com";

		// request object
		RequestSpecification r = RestAssured.given();
		r.header("User-Agent", "PostmanRuntime/7.29.2");// insert header

		// response object
		Response res = r.request(Method.GET,
				"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		// response capture hne ke baad server side ki operation start hgi
		System.out.println(res.getBody().asPrettyString());
		System.out.println("---------------------------------------------");

		String contentType = res.header("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

		String contentEncoding = res.header("Content-Encoding");
		System.out.println(contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}

}

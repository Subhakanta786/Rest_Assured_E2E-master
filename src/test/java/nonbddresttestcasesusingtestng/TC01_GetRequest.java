package nonbddresttestcasesusingtestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_GetRequest {

	@Test
	void getBooks() {

		// specify base URI
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1";

		// request object
		RequestSpecification httprequest = RestAssured.given();

		// Response object
		Response response = httprequest.request(Method.GET, "/books");
		// print response body in console
		// String responseBody = response.getBody().asString();
		// String responseBody = response.getBody().asPrettyString();
		// System.out.println(responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		// status line verification
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		// validate jsonresponse using String
		String responseBody = response.getBody().asPrettyString();
		Assert.assertEquals(responseBody.contains("9781449331818"), true);

		// extract description of 2nd location
		String node = response.jsonPath().get("books[1].description");
		// System.out.println(node);
		Assert.assertEquals(node.contains("With Learning JavaScript Design Patterns,"), true);

		String node1 = response.jsonPath().get("books[4].isbn");
		// System.out.println(node1);

		JsonPath jsonpath = response.jsonPath();
		// System.out.println(jsonpath.get("books[1].description"));

	}

	// @Test getUsers()

@Test
void getRequest(){

    // Client side

    RestAssured.baseURI = "https://www.google.co.in";
    
    RequestSpecification req =  RestAssured.given();
    
    req.header("Accept-Encoding","gzip, deflate, br");
    
    Response res = req.request(Method.GET,"/search?q=amitabh+bachchan&client=ms-android-xiaomi&sxsrf=ALiCzsYYyjlWwv-i_g-DQEjjMDVj3qcnng%3A1671342612337&ei=FKqeY9aVFMu9seMP5N-n0AE&oq=am&gs_lcp=Cgxnd3Mtd2l6LXNlcnAQAxgBMgQIIxAnMgQIIxAnMgQILhAnMgoIABCxAxCDARBDMgoIABCxAxCDARBDMgoIABCxAxCDARBDMgQIABBDMgQIABBDMgQIABBDMgQIABBDOgcIIxDqAhAnOg0ILhDHARCvARDqAhAnOgcILhDqAhAnOgwIABDqAhC0AhBDGAE6DQgAEI8BEOoCELQCGAI6CAgAELEDEIMBOgUILhCABDoFCAAQgAQ6CwguEIMBELEDEIAESgQIQRgASgQIRhgBUABYvAdgtxloAXABeACAAWiIAc0BkgEDMC4ymAEAoAEBsAEUwAEB2gEGCAEQARgB2gEGCAIQARgK&sclient=gws-wiz-serp");
    
    // Server side
    
    String body = res.getBody().asPrettyString();
    System.out.println(body);
    
     Assert.assertEquals( res.header("Server"),"gws");

}

}

package nonbddresttestcasesusingtestng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PracticeAPIs {
	
	//getRequest()
	//validate status code & validate status line
	//print response body
	@Test
	void getRequest() {
		
		//client side
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req= RestAssured.given();
		//req.queryParams("delay", 3);
		Response res=req.request(Method.GET,"/api/users?delay=3");
		//attach header of client side
		req.header("Content-Type", "application/json");
		
		//------------------server side----------------------
//		Assert.assertEquals(res.getStatusCode(), 200);
//		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
//		System.out.println(res.getBody().asPrettyString());
		
		//individual header
//		String cache=res.header("CF-Cache-Status");
//		System.out.println(cache);
		
		//print all headers
		Headers allHeaders=res.headers();//allHeaders is an array
		
		for(Header h:allHeaders) {
			String headerkey=h.getName();
			String headevalue=h.getValue();
			System.out.println(headerkey+"----"+headevalue);
		}
		
	}
	
	@Test
	void postRequest() {
		
		//Client side
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification req= RestAssured.given();
		
		//payload--request body
		JSONObject payload=new JSONObject();//hashmap
		payload.put("email", "eve.holt@reqres.in");
		payload.put("password", "pistol");
		
		req.body(payload.toJSONString());
		
		Response res=req.request(Method.POST,"/api/register");
		
		//server side
		String exp=res.jsonPath().get("token");
		System.out.println(exp);
		Assert.assertEquals(exp,"QpwL5tke4Pnpja7X4");
			
	}
	
	

}

package bddAutomation;

import org.testng.annotations.Test;

import io.restassured.http.Header;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Get_Request {
	
	@Test
	public void getUsers() {
		
		given()
			.header("Connection","keep-alive")
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.and()
			.statusLine("HTTP/1.1 200 OK")
			.and()
			.header("Content-Type", "application/json; charset=utf-8");
		
	}

}

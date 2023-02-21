package testcasesusingbdd;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class PutUsingBDD {

	public static HashMap<String, String> map = new HashMap<>();
	String firstname = RandomData.getFirstName();
	String lastname = RandomData.getLastName();
	int id = 2;

	@BeforeClass
	public void putData() {

		map.put("first_name", firstname);
		map.put("last_name", lastname);

		RestAssured.baseURI = "https://reqres.in/api";
		RestAssured.basePath = "/users/" + id;
	}

	@Test
	public void putTest() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();//everything will be printed in console
		
	}

}

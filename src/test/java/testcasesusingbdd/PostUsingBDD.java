package testcasesusingbdd;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class PostUsingBDD {

	public static HashMap<String,String> map=new HashMap<>();
	
	@BeforeClass
	public void postData() {
		map.put("name",RandomData.getName());//name-->PujuASFC
		map.put("job", RandomData.getJob());//job--> DancerSdx
		
		RestAssured.baseURI="https://reqres.in/api";//non-bdd
		RestAssured.basePath="/users";
	}
	
	@Test
	public void testPost() {
		
		given()
			.contentType("application/json")
			.body(map) //payload
		.when()
			.post()
		.then()
			.statusCode(201)
			.body("name", equalTo(map.get("name")))
			.body("job", equalTo(map.get("job")));
//		System.out.println(map.get("name"));
//		System.out.println(map.get("job"));
	}
	
}

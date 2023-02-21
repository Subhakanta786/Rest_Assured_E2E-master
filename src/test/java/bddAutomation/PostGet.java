package bddAutomation;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PostGet {

	@Test
	void postGet() {
		HashMap<String, String> map = new HashMap<>();
		map.put("firstName", "Sahil");
		map.put("lastName", "Raj");
		map.put("subjectId", "2");

		given().body(map).when().post("http://localhost:3000/users").then().contentType(ContentType.JSON);

		System.out.println("we will check the new request is added or not");

		Response res = given().when().get("http://localhost:3000/users/11");

		System.out.println(res.asPrettyString());
	}

}

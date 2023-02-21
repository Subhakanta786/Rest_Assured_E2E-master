package openAPITestcases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class HTTPRequests {

	public static int id;
	public static HashMap<String, String> map;

	@Test(priority = 1)
	void createUser() {
		map = new HashMap<>();
		map.put("name", "Sameer");
		map.put("job", "Leader");

		Response res = given().contentType("application/json").body(map).when().post("https://reqres.in/api/users")
				.then()
					.log().all()
				.extract().response();

		int statusCode = res.statusCode();

		if (statusCode == 201)
			System.out.println("New record has been added");
		else
			System.out.println("New record is NOT added");

		// the return type of get() method is an object
		// int id=res.jsonPath().get("id");//here int is internally converted into
		// Integer(Object), called Auto-boxing.
		// Method-1
		id = res.jsonPath().getInt("id");// integer jo hga wo String form me hga
		// Method-2
//		String id1=res.jsonPath().get("id");
//		id=Integer.parseInt(id1);
//		System.out.println(id);
		
		System.out.println("----------------------------------------------------------------------");

	}

	@Test(priority = 2,dependsOnMethods = {"createUser"})
	void updateUser() {
		map = new HashMap<>();
		map.put("name", "Sameer");
		map.put("job", "Tester");
		
		given()
			.contentType("application/json")
			.body(map).
		when()
			.put("https://reqres.in/api/users/"+id).
		then()
			.statusCode(200)
			.log().all();
	}

	@Test(priority = 3, dependsOnMethods = {"createUser"})
	void deleteUser() {
			given()
				.contentType("application/json")
			.when()
			.get("https://reqres.in/api/users/" + id)
			.then().log().all();
		}
	
	
	// @Test(priority = 2,dependsOnMethods = {"createUser"})
	void verifyUser() {
		given()
			.contentType("application/json")
		.when()
		.get("https://reqres.in/api/users/" + id)
		.then().log().all();
	}
	
	@Test
	void tc() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/students");
		
		JSONObject obj=new JSONObject(res.asString());
		
		
	}

}

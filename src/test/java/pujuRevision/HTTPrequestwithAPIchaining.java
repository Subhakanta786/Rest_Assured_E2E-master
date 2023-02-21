package pujuRevision;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HTTPrequestwithAPIchaining {

	public static int id;
	public static HashMap<Object,Object> data;
	
	@Test
	void createUser() {
		data=new HashMap<>();
		data.put("name", "Sita");
		data.put("location", "Ramnagar");
		data.put("phone", "12345");
		
		String c[]= {"Pascal","VLSI"};
		data.put("courses", c);
		
		Response res=
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.log().all().extract().response();
		
		id=res.jsonPath().get("id");
		System.out.println(id);
		System.out.println("-----------------------------------------------------------------");
		
	}
	
	@Test(dependsOnMethods = {"createUser"})
	void updateUser() {
		data=new HashMap<>();
		data.put("name", "Ram");
		data.put("location", "Nanded");
		data.put("phone", "125638");
		
		String c[]= {"P","VLSI"};
		data.put("courses", c);
		
		Response res=
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("http://localhost:3000/students/"+id)
		.then()
			.log().all().extract().response();
		System.out.println("-----------------------------------------------------------------");
	}
	
	@Test(dependsOnMethods = {"updateUser"})
	void verifyUser() {
		given()
		.when()
			.get("http://localhost:3000/students/"+id)
		.then()
			.log().body()
			.statusCode(200);
	}
	
	@Test(dependsOnMethods = {"verifyUser"})
	void deleteUser() {
		given()
		.when()
			.delete("http://localhost:3000/students/"+id)
		.then()
			.log().body()
			.statusCode(200);
	}	
}

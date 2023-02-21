package openAPITestcases;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Different ways we create POST request body(payload)
//1)HashMap
//2)Using JsonObject(org.json)
//3)Using POJO(Plain Old Java Object)
//4)using external json file

public class DiffWaysToCreatePostRequestBody {

	//1)request body using Hashmap
	
	//@Test
	void testPostUsingHashMap() {
		HashMap map = new HashMap();
		map.put("name", "Subhakant");
		map.put("location", "Puri");
		map.put("phone", "145267383");
	
//wrong logic :- not in approriate form when hashmap is specific to datatype
//way-1
		ArrayList<String> c=new ArrayList<>();
		c.add("C#");
		c.add("Pyhton");
		map.put("courses", c);

//way-2
//		String courseArr[]= {"C#","Pyhton"};//more efficient
//		map.put("courses", courseArr);
		
		Response res=
		given()
			.contentType("application/json")
		    .body(map).
		when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			//.body("courses[1]", equalTo("Pyhton"))
			.log().all().extract().response();
		String c1=res.jsonPath().get("courses[1]").toString();
		//Assert.assertEquals(res.jsonPath().get("courses[1]").toString(), "Python");
		Assert.assertEquals(c1, "Python");
		
	}
	
	//2)Json Object
	@Test
	void testPostUsingJsonObject() {
		
		JSONObject map=new JSONObject();
		map.put("name", "Manish");
		map.put("location", "Kolkata");
		map.put("phone", "97667383");
		
		String courseArr[]= {"VLSI","Maths","Chemistry"};//more efficient
		map.put("courses", courseArr);
		
		given()
			.contentType("application/json")
		    .body(map.toString()).
		when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();

	}
	
	//3)sending request body Using POJO(Plain Old Java Object)
	
	@Test
	void testPostUsingPOJO() {
		
		Pojo_PostRequest data=new Pojo_PostRequest();
		data.setName("Rajnikant");
		data.setLocation("Chennai");
		data.setPhone("94233111");
		String courseArr[]= {"R","Ruby"};
		data.setCourses(courseArr);
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	//4)using external json file
	@Test
	void testPostUsingExternalJsonFile() throws FileNotFoundException {
		
		String fileLocation=System.getProperty("user.dir")+"\\body.json";//will give the path upto project level
		//System.out.println(fileLocation);
		File f=new File(fileLocation);
		
		FileReader fr=new FileReader(f);
		
		JSONTokener jt=new JSONTokener(fr);
		
		JSONObject map=new JSONObject(jt);
		
		given()
		.contentType("application/json")
	    .body(map.toString())
	    .when()
			.post("http://localhost:3000/students")
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	
	
}

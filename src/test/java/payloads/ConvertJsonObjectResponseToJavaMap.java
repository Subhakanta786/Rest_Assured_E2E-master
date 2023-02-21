package payloads;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//De-serialization
public class ConvertJsonObjectResponseToJavaMap {

	@Test
	void tc1() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/data");
		
		System.out.println(res.asPrettyString());//response converted to string
		
		Map jsonResponseAsMap=res.as(Map.class);
		String firstname=(String) jsonResponseAsMap.get("first_name");
		System.out.println(firstname);
		Set<String> keys=jsonResponseAsMap.keySet();
		
		for(String key:keys) {
			System.out.println(key+" "+jsonResponseAsMap.get(key));
		}
	}
	
	@Test
	void tc2() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/data");
		
		System.out.println(res.asPrettyString());//response converted to string
		
		Map<String,Object> jsonResponseAsMap=res.as(new TypeRef<Map<String,Object>>() {});
		
		
		String firstname=(String) jsonResponseAsMap.get("first_name");
		System.out.println(firstname);
	}
	
	@Test
	void tc3() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://run.mocky.io/v3/49faebd6-abc6-44dd-b9d0-720645818ffa");
		
		System.out.println(res.asPrettyString());//response converted to string
		
		Student jsonResponseAsObject=res.as(Student.class);
		jsonResponseAsObject.getAccountNo();
		jsonResponseAsObject.getBalance();
		jsonResponseAsObject.getEmailAddress();
		
		
	}
	
	
	
}

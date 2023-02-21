package testcasesusingbdd;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//1)Test status code
//2)Log Response
//3)verify single content in response body
//4)verify multiple contents in response body
//5)setting parameters & headers

public class MixedProblems {

	@Test
	public void testStatusCode() {
		
		given()
		.when()
			.get("https://demoqa.com/BookStore/v1/books")
		.then()
			.statusCode(200).log().all();
		
	}
	
	
	@Test
	public void testsingleContent() {
		
		RestAssured.baseURI="https://gist.githubusercontent.com/kumarpani";
		RequestSpecification request=RestAssured.given();
		RestAssured.registerParser("text/plain", Parser.JSON);
		Response response=
		given()
		.when()
			.get("/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json")
		.then()
			.body("player[7].price-in-crores", equalTo("2.5")).extract().response();
		
		System.out.println(response.asPrettyString());
	}
	
	@Test
	public void indianPlayerCount(){
		
		RestAssured.baseURI="https://gist.githubusercontent.com/kumarpani";
		RequestSpecification request=RestAssured.given();
		RestAssured.registerParser("text/plain", Parser.JSON);
		
		Response response=
		given()
		.when()
			.get("/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json")
		.then()
		.extract().response();
		//System.out.println(response.asPrettyString());
		JsonPath jpath=response.jsonPath();
		//List<String> indianplayercount=jpath.getList("player.country");
		
		
	}
	
	@Test
	public void validatePlayer() {
	    
        RestAssured.baseURI ="https://gist.githubusercontent.com/kumarpani";
        RestAssured.basePath = "/1e759f27ae302be92ad51ec09955e765/raw/184cef7125e6ef5a774e60de31479bb9b2884cb5/TeamRCB.json";
        
        RestAssured.registerParser("text/plain", Parser.JSON);
        
        Response r=
	        given()
	        .when()
	            .get()
	        .then()
	            .extract().response();
        
        String name=r.jsonPath().get("player[9].name");
        Assert.assertEquals(name, "Josh Hazlewood");
        
    }
	
	
}

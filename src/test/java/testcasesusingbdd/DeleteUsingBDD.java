package testcasesusingbdd;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

//Best way to write API tests using mixed way(bdd+non-bdd)
public class DeleteUsingBDD {

	
	@Test
	public void deleteRecord() {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured.basePath="/2";
		
		Response response=
		given()
		.when()
			.delete()
		.then()
			.log().all().extract().response();
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 204);

		
//		String jsonToString=response.asPrettyString();
//		System.out.println(jsonToString);
	}
}

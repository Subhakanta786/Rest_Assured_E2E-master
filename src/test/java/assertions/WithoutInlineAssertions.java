package assertions;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class WithoutInlineAssertions {

		
	@Test
	void withoutInline() {
		
		Response res=
		given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "    \"username\" : \"admin\",\r\n"
					+ "    \"password\" : \"password123\"\r\n"
					+ "}")
		.when()
			.post("https://restful-booker.herokuapp.com/auth")
		.then()
			.log().all().extract().response();
		
		// approach-1
		JsonPath jp=new JsonPath(res.asString());
		
//		String token=jp.getString("token");
//		
//		for(int i=0;i<token.length();i++) {
//			char ch=token.charAt(i);
////			if(!Character.isLetterOrDigit(ch)) {
////				Assert.assertTrue(!Character.isLetterOrDigit(ch));
////				return;
////			}
//			
//			if( (ch>='a' && ch<='z') || (ch>='1' || ch<='9')){
//				Assert.assertTrue(!Character.isLetterOrDigit(ch));
//				return;
//			}
//		}
//		
//		Assert.assertTrue(true);
		
//		if(token.length()>10) {
//			System.out.println(true);
//		}else {
//			System.out.println(false);
//		}
		
		//Assert.assertEquals(token.length()<10, true);
		//Assert.assertTrue(token.length()>10);
		
		//approach-2
		JSONObject jobj=new JSONObject(res.asString());
		String token=jobj.getString("token");
		//Assert.assertEquals(token.length()>10, true);
		Assert.assertNotNull(jobj.getString("token"));
		
	}
	
	@Test
	void inlineAssertions() {
		
		given()
			.contentType(ContentType.JSON)
			.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.when()
			.post("https://restful-booker.herokuapp.com/auth")
		.then()
			.body("token",notNullValue())
			.statusCode(equalTo(200))
			.body("token.length()", greaterThan(10))
			.body("token", matchesRegex("^[a-z0-9]+$"));
				
	}

}

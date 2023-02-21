package assertions;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Assertions {

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
			.post("https://restful-booker.herokuapp.com/auth");
		
		JSONObject jobj=new JSONObject(res.asString());
		String token=jobj.getString("token");
		
		System.out.println(token instanceof String ? true:false);
		
		//System.out.println(token.length()==10?true:false);
		int flag=1;
		for(int i=0;i<token.length();i++) {
			char ch=token.charAt(i);
			if(!Character.isLetterOrDigit(ch)) {
				flag=0;
				break;
			}
		}
		if(flag==0) {
			System.out.println("It contains special characters or bigger alphabets");
		}else {
			System.out.println("valid toekn");
		}
					
	}
	
	@Test
	void inLine() {
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
					//.body("token.length()", equalTo(10))
					.body("token", matchesRegex("^[a-z0-9]+$"));
					
	}
}

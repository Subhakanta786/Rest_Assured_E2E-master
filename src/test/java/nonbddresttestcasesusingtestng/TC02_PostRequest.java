package nonbddresttestcasesusingtestng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC02_PostRequest {

	@Test
	public void createNewUser() {

		//---------------------CLIENT SIDE--------------------
		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httprequest = RestAssured.given();//initialize all variables on client side

		// HashMap<String,String> hm=new HasMap<>();
		// Request Payload sending along with post request
		JSONObject requestParams = new JSONObject();// its a hashmap
		requestParams.put("name", "Subhakant");
		requestParams.put("job", "Tester");
		
		//attach header of client side
		httprequest.header("Content-Type", "application/json");

		// attach above data to the request
		httprequest.body(requestParams.toJSONString());

		Response res = httprequest.request(Method.POST, "/api/users");

		//--------------------------SERVER SIDE------------------
		System.out.println(res.getBody().asPrettyString());

		int s = res.getStatusCode();
		Assert.assertEquals(s, 201);

		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 201 Created");

		// validate particular field which is dynamic in nature
		String timeStamp = res.jsonPath().get("createdAt");
		// Assert.assertEquals(timeStamp, "2022-12-11T06:42:45.138Z");
		Assert.assertEquals(timeStamp.contains("2022-12-11"), true);

	}

}

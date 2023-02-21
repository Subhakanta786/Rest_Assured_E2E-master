package jsonparsing;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParse {

	@Test
	void getUsers() {
		Response res = given().contentType(ContentType.JSON).when().get("https://demoqa.com/BookStore/v1/books");

//		String isbn=res.jsonPath().get("books[2].isbn").toString();
//		System.out.println(isbn);

		// JSONObject job=new JSONObject(res.toString());//overall json

	}

//	{
//		  "users": [
//		    {
//		      "firstName": "Krish",
//		      "lastName": "Lee",
//		      "emailAddress": "krish.lee@learningcontainer.com",
//		      "phoneNumber": "123456",
//		      "userId": 1
//		    },
//		    {
//		      "firstName": "racks",
//		      "lastName": "jacson",
//		      "emailAddress": "racks.jacson@learningcontainer.com",
//		      "phoneNumber": "123456",
//		      "userId": 2
//		    },
//		    {
//		      "firstName": "denial",
//		      "lastName": "roast",
//		      "emailAddress": "denial.roast@learningcontainer.com",
//		      "phoneNumber": "33333333",
//		      "userId": 3
//		    },
//		    {
//		      "firstName": "devid",
//		      "lastName": "neo",
//		      "emailAddress": "devid.neo@learningcontainer.com",
//		      "phoneNumber": "222222222",
//		      "userId": 4
//		    },
//		    {
//		      "firstName": "jone",
//		      "lastName": "mac",
//		      "emailAddress": "jone.mac@learningcontainer.com",
//		      "phoneNumber": "111111111",
//		      "userId": 5
//		    }
//		  ]
//		}

	@Test
	void parse2() {
		String str = "{\r\n" + "  \"users\": [\r\n" + "    {\r\n" + "      \"firstName\": \"Krish\",\r\n"
				+ "      \"lastName\": \"Lee\",\r\n"
				+ "      \"emailAddress\": \"krish.lee@learningcontainer.com\",\r\n"
				+ "      \"phoneNumber\": \"123456\",\r\n" + "      \"userId\": 1\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"firstName\": \"racks\",\r\n" + "      \"lastName\": \"jacson\",\r\n"
				+ "      \"emailAddress\": \"racks.jacson@learningcontainer.com\",\r\n"
				+ "      \"phoneNumber\": \"123456\",\r\n" + "      \"userId\": 2\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"firstName\": \"denial\",\r\n" + "      \"lastName\": \"roast\",\r\n"
				+ "      \"emailAddress\": \"denial.roast@learningcontainer.com\",\r\n"
				+ "      \"phoneNumber\": \"33333333\",\r\n" + "      \"userId\": 3\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"firstName\": \"devid\",\r\n" + "      \"lastName\": \"neo\",\r\n"
				+ "      \"emailAddress\": \"devid.neo@learningcontainer.com\",\r\n"
				+ "      \"phoneNumber\": \"222222222\",\r\n" + "      \"userId\": 4\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"firstName\": \"jone\",\r\n" + "      \"lastName\": \"mac\",\r\n"
				+ "      \"emailAddress\": \"jone.mac@learningcontainer.com\",\r\n"
				+ "      \"phoneNumber\": \"111111111\",\r\n" + "      \"userId\": 5\r\n" + "    }\r\n" + "  ]\r\n"
				+ "}";
		JSONObject job = new JSONObject(str);
		//JSONObject arr = job.getJSONArray("users").getJSONObject("last_name")
//		System.out.println(job);
//		System.out.println("-----------------------------------------");
//		System.out.println(job.get("users"));
//		System.out.println("-----------------------------------------");
//		//System.out.println(job.get("first_name"));//org.json.JSONException: JSONObject["first_name"] not found
//		System.out.println("-----------------------------------------");

//		JSONArray arr = job.getJSONArray("users");
//		System.out.println(arr);
//		System.out.println("-----------------------------------------");
//		System.out.println(arr.get(1));
//		System.out.println("-----------------------------------------");
//		System.out.println(arr.length());
//		for (int i = 0; i < arr.length(); i++) {
//			//System.out.println(arr.get(i) + "\n");
//			JSONObject data=arr.getJSONObject(i);
//			System.out.println(data);
//		}
	}

//	[
//	  {
//	    "id": 1,
//	    "first_name": "Bobine",
//	    "last_name": "Isaak",
//	    "email": "bisaak0@newsvine.com",
//	    "gender": "Female",
//	    "data": {
//	      "name": [
//	        "priye",
//	        "subhakant",
//	        "rahul",
//	        "sameer"
//	      ]
//	    }
//	  },
//	  {
//	    "id": 2,
//	    "first_name": "Goober",
//	    "last_name": "Poley",
//	    "email": "gpoley1@themeforest.net",
//	    "gender": "Male",
//	    "mobile": [
//	      "9653426",
//	      "89437418"
//	    ],
//	    "skills": {
//	      "tech": "Java",
//	      "cloud": "AWS"
//	    }
//	  }
//	]
	@Test
	void parse3() {
		String str = "[\r\n" + "  {\r\n" + "    \"id\": 1,\r\n" + "    \"first_name\": \"Bobine\",\r\n"
				+ "    \"last_name\": \"Isaak\",\r\n" + "    \"email\": \"bisaak0@newsvine.com\",\r\n"
				+ "    \"gender\": \"Female\",\r\n" + "    \"data\": {\r\n" + "      \"name\": [\r\n"
				+ "        \"priye\",\r\n" + "        \"subhakant\",\r\n" + "        \"rahul\",\r\n"
				+ "        \"sameer\"\r\n" + "      ]\r\n" + "    }\r\n" + "  },\r\n" + "  {\r\n" + "    \"id\": 2,\r\n"
				+ "    \"first_name\": \"Goober\",\r\n" + "    \"last_name\": \"Poley\",\r\n"
				+ "    \"email\": \"gpoley1@themeforest.net\",\r\n" + "    \"gender\": \"Male\",\r\n"
				+ "    \"mobile\": [\r\n" + "      \"9653426\",\r\n" + "      \"89437418\"\r\n" + "    ],\r\n"
				+ "    \"skills\": {\r\n" + "      \"tech\": \"Java\",\r\n" + "      \"cloud\": \"AWS\"\r\n"
				+ "    }\r\n" + "  }\r\n" + "]";
		
		JSONArray jarr=new JSONArray(str);
		//JSONObject job=(JSONObject)jarr;
		
//		System.out.println(jarr);
//		System.out.println("-----------------------------------------");
//		System.out.println(jarr.get(1));
		
//		JSONObject job=jarr.getJSONObject(0);
//		System.out.println(job);
		
//		JSONObject job=jarr.getJSONObject(0).getJSONObject("data");
//		System.out.println(job);
		
//		JSONArray job=jarr.getJSONObject(0).getJSONObject("data").getJSONArray("name");
//		System.out.println(job);
		
//		String job=jarr.getJSONObject(0).getJSONObject("data").getJSONArray("name").getString(1);
//		System.out.println(job);
		
//		JSONObject job=jarr.getJSONObject(1).getJSONObject("skills");
//		System.out.println(job);
		
		//JsonPath jp=new JsonPath(str);
		//System.out.println((Object)jp.get("$"));
		//System.out.println(jp.get("$").toString());
//		Object job=jp.getJsonObject("[0]");
//		System.out.println(job);
		//System.out.println((Object)jp.get("[0].data.name[1]"));
		//System.out.println((Object)jp.get("[1].skills.cloud"));
		
		
		
	}
	
	

}

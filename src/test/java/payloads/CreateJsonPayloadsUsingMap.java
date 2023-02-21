package payloads;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateJsonPayloadsUsingMap {

//	{
//		  "id":1,
//		  "first_name":"Raman",
//		  "last_name":"Sharma",
//		  "married":false,
//		  "salary":23.5
//	}
	// key will always be String and value can be anything(Object)
	// jsonobject hold key-value pairs, hence Map will be conveininet.
	@Test
	void simpleJsonObject() {

		// -------------------JAVA------------------------------
		Map<String, Object> javapayload = new LinkedHashMap<>();
		javapayload.put("id", 1);
		javapayload.put("first_name", "Raman");
		javapayload.put("last_name", "Sharma");
		javapayload.put("married", false);
		javapayload.put("salary", 23.5);

		System.out.println("This is normal Java object:");
		System.out.println(javapayload);

		// -----------------------------REST-ASSURED---------------------------
		System.out.println("This object is converted into JSON:");
		given().contentType(ContentType.JSON).body(javapayload)// javapayload is an object of map:- Serialization(java
																// object to JSON)
				.log().all().when().post();

	}

//	{
//		  "id": 1,
//		  "name": {
//		    "first_name": "Raman",
//		    "last_name": "Sharma"
//		  },
//		  "married": false,
//		  "salary": 23.5
//	}
	@Test
	void nestedJsonObject() {

		Map<String, Object> parent = new LinkedHashMap<>();
		Map<String, Object> child = new LinkedHashMap<>();
		parent.put("id", 1);
		child.put("first_name", "Raman");
		child.put("last_name", "Sharma");

		parent.put("name", child);
		parent.put("married", false);
		parent.put("salary", 23.5);

		given().contentType(ContentType.JSON).body(parent).log().all().when().post();

	}

	// Create Simple JsonArray payload using Java List

//	[
//	  10,
//	  "Ramesh",
//	  23.61,
//	  true
//	]
	@Test
	void simpleJsonArray() {

//		ArrayList<Object> l=new ArrayList<>();
//		l.add(10);//l.add(new Integer(10));--> auto-boxing
//		l.add("Ramesh");
//		l.add(23.61);
//		l.add(true);
//		
//		System.out.println(l);
//		
//		given().contentType(ContentType.JSON).body(l).log().all().when().post();

//		[
//		  {
//		    "id": 1,
//		    "first_name": "Bobine",
//		    "last_name": "Isaak",
//		    "email": "bisaak0@newsvine.com",
//		    "gender": "Female"
//		  },
//		  {
//		    "id": 2,
//		    "first_name": "Goober",
//		    "last_name": "Poley",
//		    "email": "gpoley1@themeforest.net",
//		    "gender": "Male"
//		  }
//		]
		ArrayList<Object> parentlist = new ArrayList<>();

		Map<String, Object> zerothObject = new LinkedHashMap<>();
		zerothObject.put("id", 1);
		zerothObject.put("first_name", "Bobine");
		zerothObject.put("last_name", "Isaak");
		zerothObject.put("email", "bisaak0@newsvine.com");
		zerothObject.put("gender", "Female");

		Map<String, Object> firstObject = new LinkedHashMap<>();
		firstObject.put("id", 2);
		firstObject.put("first_name", "Goober");
		firstObject.put("last_name", "Poley");
		firstObject.put("email", "gpoley1@themeforest.net");
		firstObject.put("gender", "Male");

		parentlist.add(zerothObject);
		parentlist.add(firstObject);

		System.out.println(parentlist);

		given().contentType(ContentType.JSON).body(parentlist).log().all().when().post();

	}

//	[
//	  {
//	    "id": 1,
//	    "first_name": "Bobine",
//	    "last_name": "Isaak",
//	    "email": "bisaak0@newsvine.com",
//	    "gender": "Female",
//	    "mobile": [
//	      "9325678",
//	      "4321678"
//	    ]
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
//	    ]
//	  }
//	]
	@Test
	void complexjsonpayload() {
		
		ArrayList<Object> parentlist = new ArrayList<>();
		
		Map<String, Object> zerothObject = new LinkedHashMap<>();
		zerothObject.put("id", 1);
		zerothObject.put("first_name", "Bobine");
		zerothObject.put("last_name", "Isaak");
		zerothObject.put("email", "bisaak0@newsvine.com");
		zerothObject.put("gender", "Female");
		
		ArrayList<Object> mob = new ArrayList<>();
		mob.add("9325678");
		mob.add("4321678");
		
		zerothObject.put("mobile",mob);
		
		parentlist.add(zerothObject);
		
		Map<String, Object> firstObject = new LinkedHashMap<>();
		firstObject.put("id", 2);
		firstObject.put("first_name", "Goober");
		firstObject.put("last_name", "Isaak");
		firstObject.put("email", "bisaak0@newsvine.com");
		firstObject.put("gender", "Female");
		
		ArrayList<Object> mob2 = new ArrayList<>();
		mob2.add("9325678");
		mob2.add("4321678");
		
		firstObject.put("mobile",mob2);
		
		parentlist.add(firstObject);
		
		given().contentType(ContentType.JSON).body(parentlist).log().all().when().post();
		
	}

}

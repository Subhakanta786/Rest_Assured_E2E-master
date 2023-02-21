package jsonparsing;

import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class WhentoUseJsonObjectArray_JsonPath {

//	{
//		  "id": 1,
//		  "first_name": "Verla",
//		  "last_name": "Carnihan",
//		  "email": "vcarnihan0@google.de",
//		  "gender": "Female",
//		  "ip_address": "1.132.48.160"
//	}

	// find all the keys in jsonobject
//			Iterator<String> it=job.keys();
//			while(it.hasNext()) { //if next key is available
//				String key=it.next();
//				System.out.println(key +":"+job.get(key));
//			}
	@Test
	void parse1() {

		String str = "{\r\n" + "		  \"id\": 1,\r\n" + "		  \"first_name\": \"Verla\",\r\n"
				+ "		  \"last_name\": \"Carnihan\",\r\n" + "		  \"email\": \"vcarnihan0@google.de\",\r\n"
				+ "		  \"gender\": \"Female\",\r\n" + "		  \"ip_address\": \"1.132.48.160\"\r\n" + "	}";

		// approach-1
		JSONObject job = new JSONObject(str);
//		String s=job.getString("ip_address");
//		System.out.println(s);

		// print whole json
		// System.out.println(job);

		// approach-2
		JsonPath jp = new JsonPath(str);
//		String s=jp.getString("ip_address");
//		System.out.println(s);

		Object notajson = jp.get("$");
		System.out.println(notajson);
	}

//	{
//		  "id": 1,
//		  "first_name": "Verla",
//		  "last_name": "Carnihan",
//		  "email": {
//		    "personal_email": "abc@gmail.com",
//		    "official_email": "xyz@yahoo.co.in"
//		  },
//		  "gender": "Female",
//		  "ip_address": "1.132.48.160"
//	}

	@Test
	void parse2() {

		String str = "{\r\n" + "  \"id\": 1,\r\n" + "  \"first_name\": \"Verla\",\r\n"
				+ "  \"last_name\": \"Carnihan\",\r\n" + "  \"email\": {\r\n"
				+ "    \"personal_email\": \"abc@gmail.com\",\r\n" + "    \"official_email\": \"xyz@yahoo.co.in\"\r\n"
				+ "  },\r\n" + "  \"gender\": \"Female\",\r\n" + "  \"ip_address\": \"1.132.48.160\"\r\n" + "}";

		JSONObject job = new JSONObject(str);
		System.out.println(job.getJSONObject("email"));
//		JSONObject email=job.getJSONObject("email");
//		String offical=email.getString("official_email");
//		System.out.println(offical);

//		String ss= job.getJSONObject("email").getString("official_email");
//		System.out.println(ss);

//		JsonPath jp=new JsonPath(str);
//		String official=jp.getString("email.official_email");
//		System.out.println(official);

	}

//	[
//	  {
//	    "id": 1,
//	    "first_name": "Verla",
//	    "last_name": "Carnihan",
//	    "email": {
//	      "personal_email": "abc@gmail.com",
//	      "official_email": "xyz@yahoo.co.in"
//	    },
//	    "gender": "Female",
//	    "ip_address": "1.132.48.160"
//	  },
//	  {
//	    "id": 2,
//	    "first_name": "Rahul",
//	    "last_name": "Verma",
//	    "email": {
//	      "personal_email": "def@gmail.com",
//	      "official_email": "stu@yahoo.co.in"
//	    },
//	    "gender": "Male",
//	    "ip_address": "1.132.92.160"
//	  },
//	"Raman"
//	]

	@Test
	void parse3() {

		String str = "[\r\n" + "  {\r\n" + "    \"id\": 1,\r\n" + "    \"first_name\": \"Verla\",\r\n"
				+ "    \"last_name\": \"Carnihan\",\r\n" + "    \"email\": {\r\n"
				+ "      \"personal_email\": \"abc@gmail.com\",\r\n"
				+ "      \"official_email\": \"xyz@yahoo.co.in\"\r\n" + "    },\r\n" + "    \"gender\": \"Female\",\r\n"
				+ "    \"ip_address\": \"1.132.48.160\"\r\n" + "  },\r\n" + "  {\r\n" + "    \"id\": 2,\r\n"
				+ "    \"first_name\": \"Rahul\",\r\n" + "    \"last_name\": \"Verma\",\r\n" + "    \"email\": {\r\n"
				+ "      \"personal_email\": \"def@gmail.com\",\r\n"
				+ "      \"official_email\": \"stu@yahoo.co.in\"\r\n" + "    },\r\n" + "    \"gender\": \"Male\",\r\n"
				+ "    \"ip_address\": \"1.132.92.160\"\r\n" + "  }\r\n" + "]";

		// JSONArray jarr = new JSONArray(str);
//		System.out.println(jarr.getJSONObject(0).getJSONObject("email").getString("official_email"));
//		System.out.println(jarr.getJSONObject(1).getJSONObject("email").getString("official_email"));

		// System.out.println(jarr.length());

//		for(int i=0;i<jarr.length();i++) {
//			System.out.println(jarr.getJSONObject(i).getJSONObject("email").getString("official_email"));
//		}

		JsonPath jp = new JsonPath(str);
		List<String> l = jp.getList("email.official_email");

		for (String s : l) {
			System.out.println(s);
		}
	}

}

package jsonparsing;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.path.json.JsonPath;

public class ParseJSON {

//	static String json = "{\r\n" + "    \"pageInfo\": {\r\n" + "            \"pageName\": \"Homepage\",\r\n"
//			+ "            \"logo\": \"https://www.example.com/logo.jpg\"\r\n" + "    },\r\n" + "    \"posts\": [\r\n"
//			+ "            {\r\n" + "                \"post_id\": \"0123456789\",\r\n"
//			+ "                \"actor_id\": \"1001\",\r\n" + "                \"author_name\": \"Jane Doe\",\r\n"
//			+ "                \"post_title\": \"How to parse JSON in Java\",\r\n"
//			+ "                \"comments\": [],\r\n" + "                \"time_of_post\": \"1234567890\"\r\n"
//			+ "            }\r\n" + "    ]\r\n" + "}";

	static String json = "{\r\n" + "  \"users\": [\r\n" + "    {\r\n" + "      \"userId\": 1,\r\n"
			+ "      \"firstName\": \"Krish\",\r\n" + "      \"lastName\": \"Lee\",\r\n"
			+ "      \"phoneNumber\": \"123456\",\r\n"
			+ "      \"emailAddress\": \"krish.lee@learningcontainer.com\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"userId\": 2,\r\n" + "      \"firstName\": \"racks\",\r\n" + "      \"lastName\": \"jacson\",\r\n"
			+ "      \"phoneNumber\": \"123456\",\r\n"
			+ "      \"emailAddress\": \"racks.jacson@learningcontainer.com\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"userId\": 3,\r\n" + "      \"firstName\": \"denial\",\r\n" + "      \"lastName\": \"roast\",\r\n"
			+ "      \"phoneNumber\": \"33333333\",\r\n"
			+ "      \"emailAddress\": \"denial.roast@learningcontainer.com\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"userId\": 4,\r\n" + "      \"firstName\": \"devid\",\r\n" + "      \"lastName\": \"neo\",\r\n"
			+ "      \"phoneNumber\": \"222222222\",\r\n"
			+ "      \"emailAddress\": \"devid.neo@learningcontainer.com\"\r\n" + "    },\r\n" + "    {\r\n"
			+ "      \"userId\": 5,\r\n" + "      \"firstName\": \"jone\",\r\n" + "      \"lastName\": \"mac\",\r\n"
			+ "      \"phoneNumber\": \"111111111\",\r\n"
			+ "      \"emailAddress\": \"jone.mac@learningcontainer.com\"\r\n" + "    }\r\n" + "  ]\r\n" + "}";

	public static void main(String[] args) {
		JSONObject obj = new JSONObject(json);
		System.out.println(obj);
		// System.out.println(obj.has("logo"));
		// System.out.println(obj.getJSONObject("pageInfo").getString("pageName"));
		//System.out.println(obj.getJSONArray("users"));
		//System.out.println(obj);

		//JSONArray arr = obj.getJSONArray("users");
		
//		for (int i = 0; i < arr.length(); i++) {
//			if(i==4) {
//				String post_id = arr.getJSONObject(i).getString("phoneNumber");
//				System.out.println(post_id);
//			}			
//		}
		
//	 JsonPath jsonpath=new JsonPath(json);
//	 List<Object> l=(List<Object>)jsonpath.getList("$");
//	 System.out.println(l);
	}

}

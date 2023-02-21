package jsonparsing;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class ParseJSON3 {
	
	@Test
	void hospitaljson() {
		String str="{\r\n"
				+ "  \"Hospital\": [\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Apollo\",\r\n"
				+ "      \"id\": 2,\r\n"
				+ "      \"isDialysis\": true,\r\n"
				+ "      \"Departments\": [\r\n"
				+ "        \"Orthopaedics\",\r\n"
				+ "        \"dental\",\r\n"
				+ "        \"emergency\"\r\n"
				+ "      ],\r\n"
				+ "      \"rating\": 5.0,\r\n"
				+ "      \"numberofdoctors\": 50,\r\n"
				+ "      \"Founder\": \"Bajaj\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"AIMS\",\r\n"
				+ "      \"id\": 3,\r\n"
				+ "      \"isDialysis\": true,\r\n"
				+ "      \"Departments\": [\r\n"
				+ "        {\r\n"
				+ "          \"Orthopaedics\": \"PWD\",\r\n"
				+ "          \"injectionType\": \"DOLO\"\r\n"
				+ "        },\r\n"
				+ "        \"dental\",\r\n"
				+ "        \"emergency\"\r\n"
				+ "      ],\r\n"
				+ "      \"rating\": 6.0,\r\n"
				+ "      \"numberofdoctors\": 100,\r\n"
				+ "      \"Founder\": \"VKS\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
		JSONObject jobj=new JSONObject(str);//json (like a hashmap:- key-value pair)
		
		//System.out.println(jobj);
		
		JSONArray jarr=jobj.getJSONArray("Hospital");//like a ArrayList,here Hospital is a key, value will be JsonArray
		//System.out.println(jarr);//overall array
		//System.out.println(jarr.getJSONObject(0));//first index ka value
		
		System.out.println(jarr.getJSONObject(1).getJSONArray("Departments").getJSONObject(0).getString("injectionType"));
		
	}
	
	
	@Test
	void integerinStringjson() {
		String str="[\r\n"
				+ "\"10\",\r\n"
				+ "\"20\",\r\n"
				+ "\"30\"\r\n"
				+ "]";
		
		JSONArray jarr=new JSONArray(str);
		System.out.println(jarr.getString(2));
		
	}
	
	@Test
	void nestedjsonArrays() {
		String str="[\r\n"
				+ "  [\r\n"
				+ "    \"10\",\r\n"
				+ "    \"20\",\r\n"
				+ "    \"30\",\r\n"
				+ "    \"40\",\r\n"
				+ "    \"50\"\r\n"
				+ "  ],\r\n"
				+ "  [\r\n"
				+ "    \"100\",\r\n"
				+ "    \"200\",\r\n"
				+ "    \"300\",\r\n"
				+ "    \"400\",\r\n"
				+ "    \"500\"\r\n"
				+ "  ]\r\n"
				+ "]";
		
		JSONArray jarr=new JSONArray(str);
		//System.out.println(jarr);
		
		JSONArray ja=jarr.getJSONArray(1);
		System.out.println(ja.getString(2));
		
	}
	
	

}

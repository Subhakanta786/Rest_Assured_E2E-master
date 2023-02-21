package jsonparsing;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class RecursiveJSONParsing {

	public static void main(String[] args) {
//		String str="{\r\n"
//				+ "  \"id\": 1,\r\n"
//				+ "  \"name\": {\r\n"
//				+ "    \"first_name\": \"Raman\",\r\n"
//				+ "    \"last_name\": \"Sharma\"\r\n"
//				+ "  },\r\n"
//				+ "  \"married\": false,\r\n"
//				+ "  \"salary\": 23.5\r\n"
//				+ "}";
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
		JSONObject json = new JSONObject(str);
		getKey(json, "lastName");
	}

	private static void getKey(JSONObject json, String key) {

		boolean exists = json.has(key);

		if (exists == false) {

			Iterator<String> keys = json.keys();

			while (keys.hasNext()) {
				String individualKey = keys.next();
				if (json.get(individualKey) instanceof JSONObject) {

					if (exists == false) {
						getKey(json.getJSONObject(individualKey), key);
					}

				} else if (json.get(individualKey) instanceof JSONArray) {
					JSONArray arr = json.getJSONArray(individualKey);

					for (int i = 0; i < arr.length(); i++) {
						Object id = arr.get(i);
						JSONObject innerjson = new JSONObject(id.toString());
						if (exists == false) {
							getKey(innerjson, key);
						}
					}
				}
			}
		} else {
			System.out.println(json.get(key));
			return;
		}
	}
}

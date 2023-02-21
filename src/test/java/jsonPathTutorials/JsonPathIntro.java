package jsonPathTutorials;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathIntro {

	@Test
	void jsonPathDemo1() {

		String str = "{\r\n" + "  \"name\":\"Sameer\",\r\n" + "  \"gender\": \"male\"\r\n" + "}";

		// Approach-1
		// JSON-->Java Object ( de-serialization)
		JSONObject job = new JSONObject(str);// json
		System.out.println(job);// json print ho jayega
		System.out.println("----------------------------------------");
//		
//		String name=job.get("name").toString();
//		String name1=job.getString("name");
//		System.out.println(name1);

		// Approach-2
		// JsonPath object
		// fetch all json

		JsonPath job1 = new JsonPath(str);
		Object s = job1.get("$");
		System.out.println(s);
//		String name=job1.getString("name");
//		System.out.println(name);

		// Object can hold any datatype
		String name = job1.get("name");// 123
		System.out.println(name);

	}

	@Test
	void jsonPathDemo2() {
		String str = "{\r\n" + "  \"name\":\"Ram\",\r\n" + "  \"age\":34,\r\n" + "  \"salary\":6.5,\r\n"
				+ "  \"gender\":\"male\",\r\n" + "  \"isMarried\":true\r\n" + "}";

		JsonPath jobj = new JsonPath(str);
		// System.out.println(jobj.getString("Name")); gives null
		// System.out.println(jobj.getInt("Age")); throws nullpointer exception
//		System.out.println(jobj.getDouble("salary"));
//		System.out.println(jobj.getString("gender"));
//		System.out.println(jobj.getBoolean("isMarried"));
		Object s = jobj.get("$");
		System.out.println(s);

	}

	@Test
	void nestedJsonDemo() {

		String str = "{\r\n" + "  \"firstName\": \"Ramesh\",\r\n" + "  \"lastName\": \"Jackon\",\r\n"
				+ "  \"gender\": \"male\",\r\n" + "  \"age\": 24,\r\n" + "  \"address\": {\r\n"
				+ "    \"streetAddress\": \"126\",\r\n" + "    \"city\": \"San Jone\",\r\n"
				+ "    \"state\": \"CA\",\r\n" + "    \"postalCode\": 131.31\r\n" + "  }\r\n" + "}";

		JsonPath jp = new JsonPath(str);

		System.out.println(jp.getDouble("address.postalCode"));

	}

	@Test
	void simpleArrayDemo() {

		String str = "[\r\n" + "  \"10\",\r\n" + "  \"20\",\r\n" + "  \"30\",\r\n" + "  \"40\",\r\n" + "  50\r\n" + "]";

		JsonPath jp = new JsonPath(str);
		// System.out.println(jp.getString("[0]"));
		// System.out.println(jp.getInt("[4]"));
		// System.out.println(jp.get("$").toString().length());
		// System.out.println(jp.getList("$").size());

		List<Object> l = jp.getList("$");
		System.out.println(l.size());

	}

	@Test
	void nestedjsonArrays() {
		String str = "[\r\n" + "  [\r\n" + "    \"10\",\r\n" + "    \"20\",\r\n" + "    \"30\",\r\n" + "    \"40\",\r\n"
				+ "    \"50\"\r\n" + "  ],\r\n" + "  [\r\n" + "    \"100\",\r\n" + "    \"200\",\r\n"
				+ "    \"300\",\r\n" + "    \"400\",\r\n" + "    \"500\"\r\n" + "  ]\r\n" + "]";

		JsonPath jp = new JsonPath(str);
		// System.out.println(jp.getList("[1]").size());
		// System.out.println(jp.getString("[1][2]"));
		// System.out.println(jp.getList("$").size());
		// System.out.println(jp.getList("$").get(1));
		List<Object> l = (List<Object>) jp.getList("$").get(0);
		System.out.println(l.size());
	}

	@Test
	void jsonarrayjsonObject() {
		String str = "[\r\n" + "  {\r\n" + "    \"firstName\": \"Ramesh\",\r\n" + "    \"lastName\": \"Jackon\",\r\n"
				+ "    \"gender\": \"male\",\r\n" + "    \"age\": 24,\r\n" + "    \"address\": [\r\n" + "      {\r\n"
				+ "        \"city\": \"Bangalore\",\r\n" + "        \"country\": \"India\"\r\n" + "      },\r\n"
				+ "      {\r\n" + "        \"city\": \"Delhi\",\r\n" + "        \"country\": \"India\"\r\n"
				+ "      }\r\n" + "    ]\r\n" + "  },\r\n" + "  {\r\n" + "    \"firstName\": \"Rakhi\",\r\n"
				+ "    \"lastName\": \"Mishra\",\r\n" + "    \"gender\": \"female\",\r\n" + "    \"age\": 28,\r\n"
				+ "    \"address\": [\r\n" + "      {\r\n" + "        \"city\": \"Bhopal\",\r\n"
				+ "        \"country\": \"India\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"city\": \"Dubai\",\r\n" + "        \"country\": \"San\"\r\n" + "      }\r\n" + "    ]\r\n"
				+ "  }\r\n" + "]";

		JsonPath jp = new JsonPath(str);
		System.out.println(jp.getString("[1].address.city"));

	}

	@Test
	void jsonarrayjsonObject1() {
		String str = "[\r\n" + "  {\r\n" + "    \"firstName\": \"Ramesh\",\r\n" + "    \"lastName\": \"Jackon\",\r\n"
				+ "    \"gender\": \"male\",\r\n" + "    \"age\": 24,\r\n" + "    \"address\": [\r\n" + "      {\r\n"
				+ "        \"city\": \"Bangalore\",\r\n" + "        \"country\": \"India\"\r\n" + "      },\r\n"
				+ "      {\r\n" + "        \"city\": \"Delhi\",\r\n" + "        \"country\": \"India\"\r\n"
				+ "      }\r\n" + "    ]\r\n" + "  },\r\n" + "  {\r\n" + "    \"firstName\": \"Rakhi\",\r\n"
				+ "    \"lastName\": \"Mishra\",\r\n" + "    \"gender\": \"female\",\r\n" + "    \"age\": 28,\r\n"
				+ "    \"address\": [\r\n" + "      {\r\n" + "        \"city\": \"Bhopal\",\r\n"
				+ "        \"country\": \"India\"\r\n" + "      },\r\n" + "      {\r\n"
				+ "        \"city1\": \"Dubai\",\r\n" + "        \"country\": \"San\"\r\n" + "      },\r\n"
				+ "      {\r\n" + "        \"country\":\"Russia\",\r\n" + "        \"island\":\"australia\"\r\n"
				+ "      }\r\n" + "    ]\r\n" + "  }\r\n" + "]";

		JsonPath jp = new JsonPath(str);
		// System.out.println(jp.getList("[1].address.city"));

		System.out.println(jp.getList("address.city"));

	}

	@Test
	void readjsonFromFile() {

		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\jsonPathTutorials\\empdetail.json";
		File jsonArrayFile = new File(filePath);

		JsonPath jp = new JsonPath(jsonArrayFile);

//		List<String> allFirstNames=jp.getList("data.firstName");
//		System.out.println(allFirstNames);

//		String name=jp.getString("data[2].firstName");
//		System.out.println(name);

//		String name=jp.getString(" data.find { it.firstName== 'Sheetal'  }.firstName");
//		System.out.println(name);

		System.out.println(jp.getList("data.findAll{ it.age < 50 }.gender"));
		// All Female First Names :- filter
		// condition :- pure record me se female first names

		// "it" represents root
		// findall{ filter condition }

		// List<String> allFemaleFirstNames=jp.getList("findAll{ it.gender == 'female'
		// }.firstName");
		// System.out.println(allFemaleFirstNames);

		// multiple filters
		// get email id of a particular person whose firstName is Shivani & lastName is
		// Jadon

		// List<String> allemailId=jp.getList("findAll { it.firstName == 'Shivani' |
		// it.lastName == 'Jadon' }.email");
		// System.out.println(allemailId);

		// System.out.println( jp.getList(" findAll { it.id < 5 }.firstName") );

	}

	@Test
	void complexjson() {

		String str = "{\r\n" + "  \"Stores\": [\r\n" + "    \"Lambton Quay\",\r\n" + "    \"Willis Street\"\r\n"
				+ "  ],\r\n" + "  \"Manufacturers\": [\r\n" + "    {\r\n" + "      \"Name\": \"Acme Co\",\r\n"
				+ "      \"Products\": [\r\n" + "        {\r\n" + "          \"Name\": \"Anvil\",\r\n"
				+ "          \"Price\": 50\r\n" + "        }\r\n" + "      ]\r\n" + "    },\r\n" + "    {\r\n"
				+ "      \"Name\": \"Contoso\",\r\n" + "      \"Products\": [\r\n" + "        {\r\n"
				+ "          \"Name\": \"Elbow Grease\",\r\n" + "          \"Price\": 99.95\r\n" + "        },\r\n"
				+ "        {\r\n" + "          \"Name\": \"Headlight Fluid\",\r\n" + "          \"Price\": 4\r\n"
				+ "        }\r\n" + "      ]\r\n" + "    }\r\n" + "  ]\r\n" + "}";

		JsonPath jp = new JsonPath(str);

		// System.out.println(jp.getList("Manufacturers.Products").size());

		int size = jp.getList("Manufacturers.Products").size();
		List<Object> l = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			Object s = jp.getList("Manufacturers.Products").get(i);
			l.add(s);
		}
		System.out.println(l);

	}

	static String str = "{\r\n"
			+ "  \"Stores\": [\r\n"
			+ "    \"Lambton Quay\",\r\n"
			+ "    \"Willis Street\"\r\n"
			+ "  ],\r\n"
			+ "  \"Manufacturers\": [\r\n"
			+ "    {\r\n"
			+ "      \"Name\": \"Acme Co\",\r\n"
			+ "      \"Products\": [\r\n"
			+ "        {\r\n"
			+ "          \"Name\": \"Anvil\",\r\n"
			+ "          \"Price\": 50\r\n"
			+ "        }\r\n"
			+ "      ]\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"Name\": \"Contoso\",\r\n"
			+ "      \"Products\": [\r\n"
			+ "        {\r\n"
			+ "          \"Name\": \"Elbow Grease\",\r\n"
			+ "          \"Price\": 99.95\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"Name\": \"Headlight Fluid\",\r\n"
			+ "          \"Price\": 4\r\n"
			+ "        }\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";

	public static void main(String[] args) {
		List<Object> l = getListOfProducts(str);
		System.out.println(l);
	}

	private static List<Object> getListOfProducts(String str) {
		JsonPath jp = new JsonPath(str);

		// System.out.println(jp.getList("Manufacturers.Products").size());

		int size = jp.getList("Manufacturers.Products").size();
		List<Object> l = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			Object s = jp.getList("Manufacturers.Products").get(i);
			l.add(s);
		}
		return l;
	}
}

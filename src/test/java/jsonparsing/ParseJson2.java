package jsonparsing;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseJson2 {

	public static String str="{\r\n"
			+ "    \"name\": {\r\n"
			+ "        \"firstName\": \"Sameer\",\r\n"
			+ "        \"image\": \"birthday.png\"\r\n"
			+ "    },\r\n"
			+ "    \"posts\": [\r\n"
			+ "        {\r\n"
			+ "            \"post_id\": \"10123\",\r\n"
			+ "            \"author_name\": \"Subhakant\",\r\n"
			+ "            \"post_title\": \"How to parse JSON\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"post_id\": \"10124\",\r\n"
			+ "            \"author_name\": \"Rahul\",\r\n"
			+ "            \"post_title\": \"How to simulate json\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"post_id\": \"10124\",\r\n"
			+ "            \"author_name\": \"Rahul\",\r\n"
			+ "            \"post_title\": \"How to simulate json\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"post_id\": \"10124\",\r\n"
			+ "            \"author_name\": \"Subhakant\",\r\n"
			+ "            \"post_title\": \"How to simulate json\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"post_id\": \"10124\",\r\n"
			+ "            \"author_name\": \"Rahul\",\r\n"
			+ "            \"post_title\": \"How to simulate json\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "            \"post_id\": \"10124\",\r\n"
			+ "            \"author_name\": \"Sammer\",\r\n"
			+ "            \"post_title\": \"How to simulate json\"\r\n"
			+ "        }\r\n"
			+ "    ]\r\n"
			+ "}";
	
	public static void main(String[] args) {
		
		JSONObject obj=new JSONObject(str);//overall json
		//fetch firstName
		String fname=obj.getJSONObject("name").get("firstName").toString();
		//System.out.println(fname);
		
		JSONArray arr=obj.getJSONArray("posts");
		int size=arr.length();
		System.out.println(size);
		int countForRahul=0,countForSameer=0,countForSubhakant=0;
		
		for(int i=0;i<size;i++) {
			
			String authorName=arr.getJSONObject(i).get("author_name").toString();
			
			if(authorName.equals("Rahul")) {
				countForRahul++;
			}else if(authorName.equals("Sammer")) {
				countForSameer++;
			}else if(authorName.equals("Subhakant")) {
				countForSubhakant++;
			}
			
		}
		
		System.out.println(countForRahul);
		System.out.println(countForSameer);
		System.out.println(countForSubhakant);
		
		
	}

}

package nonbddresttestcasesusingtestng;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC04_PrintingAllHeaders {

	@Test
	void printAllHeaders() {

		RestAssured.baseURI = "https://maps.googleapis.com";

		RequestSpecification r = RestAssured.given();

		Response res = r.request(Method.GET,
				"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

		Headers allHeaders = res.headers(); // key-value pair---hashmap
		int count=0;
		
		HashMap<String,String> hm=new HashMap<>();

		for (Header header : allHeaders) {

			String headerkey = header.getName();
			String headerValue = header.getValue();
			
			hm.put(headerkey, headerValue);

			//System.out.println(headerkey + "------->" + headerValue);
			count++;
		}
		
		System.out.println("-------------------------------------------------");
		
		System.out.println(hm);
		System.out.println("Header count::"+count);

	}

}

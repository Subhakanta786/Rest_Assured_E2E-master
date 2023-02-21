package resttestcases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DatadrivenTest {
	
	ExcelOperations excel=new ExcelOperations("sheet1");
	@Test(dataProvider = "TestData")
	void postNewRecords(String name,String job) {
		
		//HashMap<String, String> testData=(HashMap<String, String>)obj;
		
		RestAssured.baseURI="https://reqres.in/api";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//we will add payload
		JSONObject requestParams=new JSONObject();
//		requestParams.put("name", testData.get("Name"));
//		requestParams.put("job",testData.get("Job"));
		requestParams.put("name", name);
		requestParams.put("job",job);
		
		//Add a header stating that payload is a JSON
		httpRequest.header("Content-Type", "application/json");
		
		//Add the JSON to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST request
		Response response=httpRequest.request(Method.POST, "/users");
		
		//capture response body typ perform validations
		String responseBody=response.getBody().asPrettyString();
		
		System.out.println(responseBody);
		
		//Assert.assertEquals(responseBody.contains(job), true);
		
		
	}
	
	
//	@DataProvider(name="TestData")
//	String[][] getData(){
//		
//		String[][] data= {
//				{"priye","singer"},
//				{"puju","dancer"},
//				{"pooja","learner"},
//				{"pojo","artist"}
//		};
//		
//		return data;
//	}
	
	// Dataprovider method --> return object array
		@DataProvider(name = "TestData")
		public Object[][] testDataSupplier(Method m) throws Exception {
			Object[][] obj = new Object[excel.getRowCount()][1];
			for (int i = 1; i <= excel.getRowCount(); i++) {
				HashMap<String, String> testData = excel.getTestDataInMap(i);
				obj[i - 1][0] = testData;
			}
			return obj;

		}
	
	

}

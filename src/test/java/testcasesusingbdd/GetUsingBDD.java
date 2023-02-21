package testcasesusingbdd;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUsingBDD {
	
	@Test
	void getBooks() {
		
		given()
		.when()
			.get("https://demoqa.com/BookStore/v1/books")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.assertThat().body("books[0].isbn", equalTo("9781449325862"))
			.assertThat().body("books[0].subTitle", equalTo("A Working Introduction"))
			.header("Content-Type", "application/json; charset=utf-8");
	}
}

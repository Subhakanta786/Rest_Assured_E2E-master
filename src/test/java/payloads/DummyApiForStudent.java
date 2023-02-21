package payloads;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

//{
//"accountNo": 110,
//"balance": 20.34,
//"firstName": "Krish",
//"lastName": "Lee",
//"emailAddress": "krish.lee@learningcontainer.com",
//"gender": "male"
//}

public class DummyApiForStudent {

	
	@Test
	void simplejsonobject() {
		
		Student ramesh=new Student();
		ramesh.setAccountNo(110);
		ramesh.setBalance(20.34);
		ramesh.setFirstName("Krish");
		ramesh.setLastName("Lee");
		ramesh.setEmailAddress("krish.lee@learningcontainer.com");
		ramesh.setGender("male");
		
		given().contentType(ContentType.JSON).body(ramesh).log().all().when().post();
	}

//	[
//	  {
//	    "accountNo": 110,
//	    "balance": 20.34,
//	    "firstName": "Krish",
//	    "lastName": "Lee",
//	    "emailAddress": "krish.lee@learningcontainer.com",
//	    "gender": "male"
//	  },
//	  {
//	    "accountNo": 200,
//	    "balance": 45.34,
//	    "firstName": "Hooda",
//	    "lastName": "Chopal",
//	    "emailAddress": "nesra.ee@learningcontainer.com",
//	    "gender": "female"
//	  }
//	]
	
	@Test
	void simpleJsonArray() {
		
		Student s1=new Student();
		s1.setAccountNo(110);
		s1.setBalance(20.34);
		s1.setFirstName("Krish");
		s1.setLastName("Lee");
		s1.setEmailAddress("krish.lee@learningcontainer.com");
		s1.setGender("male");
		
		Student s2=new Student();
		s2.setAccountNo(200);
		s2.setBalance(45.34);
		s2.setFirstName("Hooda");
		s2.setLastName("Chopal");
		s2.setEmailAddress("nesra.ee@learningcontainer.com");
		s2.setGender("female");
		
		List<Student> jsonArrayStudent=new ArrayList<>();
		jsonArrayStudent.add(s1);
		jsonArrayStudent.add(s2);
		
		given().contentType(ContentType.JSON).body(jsonArrayStudent).log().all().when().post();	
	}
	
	
	@Test
	void nestedJsonObject() {
		
		Teacher t=new Teacher();
		
		t.setId(1);
		
		Name n=new Name();
		n.setFirst_name("Raman");
		n.setLast_name("Sharma");
		
		t.setName(n);
		t.setMarried(false);
		t.setSalary(23.5);
		
	  given().contentType(ContentType.JSON).body(t).log().all().when().post();
		
	}

//{
//		  "first_name": "Raman",
//		  "last_name": "Sharma",
//		  "address": [
//		    {
//		      "street": 38,
//		      "city": "pune"
//		    },
//		    {
//		      "street": 45,
//		      "city": "chennai"
//		    }
//		  ],
//		  "gate": {
//		    "main": "rose",
//		    "side": false
//		  }
//}
	@Test
	void complexJson() {
		
		Employee emp=new Employee();
		
		emp.setFirst_name("Raman");
		emp.setLast_name("Sharma");
		
		Address ad1=new Address();
		ad1.setStreet(38);
		ad1.setCity("pune");
		
		Address ad2=new Address();
		ad2.setStreet(45);
		ad2.setCity("chennai");
		
		List<Address> allAdress=new ArrayList<>();
		allAdress.add(ad1);
		allAdress.add(ad2);
		
		emp.setAddress(allAdress);
		
		Gate gt=new Gate();
		gt.setMain("rose");
		gt.setSide(false);
		
		emp.setGate(gt);
		
		given().contentType(ContentType.JSON).body(emp).log().all().when().post();
		
	}
}

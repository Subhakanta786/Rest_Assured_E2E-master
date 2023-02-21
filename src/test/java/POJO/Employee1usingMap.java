package POJO;

import java.util.LinkedHashMap;
import java.util.Map;

//Employee
//
//id
//name
//mob.no
//gender
//department
//address

public class Employee1usingMap {

	public static void main(String[] args) {
		
		//it is one of the way to store data
		//disadvantage:- tight coupling of keys
		//using json file to store the data
		Map<String,Object> employee=new LinkedHashMap<>();
		employee.put("id", 1);
		employee.put("name", "Raman");
		employee.put("mob_no", "943097643");
		employee.put("gender", "male");
		employee.put("department", "CSE");
		employee.put("address", "Delhi");
		
		Map<String,Object> employee1=new LinkedHashMap<>();
		employee1.put("id", 1);
		employee1.put("name", "Raman");
		employee1.put("mob_no", "943097643");
		employee1.put("gender", "male");
		employee1.put("department", "CSE");
		employee1.put("address", "Delhi");
		
		Map<String,Object> employee2=new LinkedHashMap<>();
		employee2.put("id", 1);
		employee2.put("name", "Raman");
		employee2.put("mob_no", "943097643");
		employee2.put("gender", "male");
		employee2.put("department", "CSE");
		employee2.put("address", "Delhi");
		
		Map<String,Object> employee3=new LinkedHashMap<>();
		employee3.put("id", 1);
		employee3.put("name", "Raman");
		employee3.put("mob_no", "943097643");
		employee3.put("gender", "male");
		employee3.put("department", "CSE");
		employee3.put("address", "Delhi");
		employee3.put("", "Delhi");
		
		Map<String,Object> employee4=new LinkedHashMap<>();
		employee4.put("id", 1);
		employee4.put("name", "Raman");
		employee4.put("mob_no", "943097643");
		employee4.put("gender", "male");
		employee4.put("department", "CSE");
		employee4.put("address", "Delhi");
		
	}

}

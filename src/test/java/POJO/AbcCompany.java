package POJO;

public class AbcCompany {

	public static void main(String[] args) {

		// Reusabilty
//		Employee2 aman = new Employee2();
//		aman.id = 1;
//		aman.deptId = 100;
//		aman.address = "Delhi";
//		aman.gender = "male";
//		aman.mobile = "9322456";
//
//		Employee2 mukesh = new Employee2();
//		mukesh.id = 2;
//		mukesh.deptId = 200;
//		mukesh.address = "Pune";
//		mukesh.gender = "male";
//		mukesh.mobile = "944322456";
		
		Employee rahul=new Employee();
		rahul.setId(1);
		rahul.setDeptId(100);
		rahul.setAddress("Pune");
		rahul.setGender("male");
		rahul.setMobile("8674537238");
		
		System.out.println(rahul.getAddress());
	}

}

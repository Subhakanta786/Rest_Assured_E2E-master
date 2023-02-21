package payloads;

//{
//	  "id": 1,
//	  "name": {
//	    "first_name": "Raman",
//	    "last_name": "Sharma"
//	  },
//	  "married": false,
//	  "salary": 23.5
//}

public class Teacher {

	private int id;
	private boolean married;
	private double salary;
	private Name name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

}

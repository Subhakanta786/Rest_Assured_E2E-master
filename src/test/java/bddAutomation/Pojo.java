package bddAutomation;

public class Pojo extends Object {

	String name;
	double salary;
	char gender;
	boolean isVote;

	public Pojo(String name, double salary, char gender, boolean isVote) {
		super();
		this.name = name;
		this.salary = salary;
		this.gender = gender;
		this.isVote = isVote;
	}

	public Pojo() {

	}

	public static void main(String[] args) {
		Pojo p1 = new Pojo("Ram", 20000.0, 'M', false);
		p1.setGender('F');
		System.out.println(p1.getName() + "->" + p1.getSalary() + "->" + p1.getGender() + "->" + p1.getVote());

		// System.out.println();

		Pojo p2 = new Pojo();
		// System.out.println(p2.getName());
		p2.setName("Sita");
		p2.setSalary(30000.0);
		p2.setGender('F');
		p2.setVote(true);

		// System.out.println(p2.getName()+" "+p2.getSalary()+" "+p2.getGender()+"
		// "+p2.getVote());

		// System.out.println(p2.toString());

	}

	@Override
	public String toString() {
		return "Pojo [name=" + name + ", salary=" + salary + ", gender=" + gender + ", isVote=" + isVote + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public boolean getVote() {
		return isVote;
	}

	public void setVote(boolean isVote) {
		this.isVote = isVote;
	}

}

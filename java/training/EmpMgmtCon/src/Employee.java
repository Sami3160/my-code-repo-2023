
public class Employee {
	private String name;
	private int id;
	private double salary;
	private String department;
	
	public Employee(int id, String name, String department, double salary) {
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return id +" | "+name+" | "+department+" | "+salary;
	}
}

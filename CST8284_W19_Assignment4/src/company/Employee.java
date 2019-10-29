package company;
import java.io.Serializable;

/**Employee.java
 * @author Robleh Nur
 * @version 2018-12
 * Course: CST8284
 * Assignment due date: April 14, 2019
 *The Employee class is an abstract class with 3 subclasses called 
 *Manager Staff and Temp. 
 */

/*//Declaring variables
*/public abstract class Employee implements Serializable {

	/**
	 * Fields created to hold values passed to class
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int employeeNumber;
	private OurDate startDate;
	private double salary;

	/**
	 * no arg Constructor
	 * default initial values
	 */
	public Employee() {
		this("", -9, new OurDate(), -1);
	}

	/**
	 * Base constructor
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @throws BadInputException if an input exception happens
	 */
	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
//		if(name != (String)name) {
//			throw new BadInputException("Name must contain alphabetical characters only");
//		}
//		if (employeeNumber > 0) {
//			throw new BadInputException("Employee number must only contain numeric values and non negative numbers");
//		}
//		if(salary > 0) {
//			throw new BadInputException("Salary must only contain numeric values and non negative numbers");
//		}
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);

	}


	public OurDate getStartDate() {
		return startDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getEmployeeNumber() {
		return employeeNumber;
	}


	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}


	private void setStartDate(OurDate startDate) {
		this.startDate = startDate;
	}


	public double getSalary() {
		return salary;
	}


	private void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {

		String s = name + "\t\t" + employeeNumber + "\t\t" + startDate + "\t\t" + salary;

		return s;

	}


	@Override
	public boolean equals(Object obj) {

		if (getClass() == null || obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		Employee e = (Employee) obj;



		return (this.getName() == e.getName() && this.getStartDate() == e.getStartDate()
				&& this.getEmployeeNumber() == e.getEmployeeNumber() && this.getSalary() == e.getSalary());

	}
	
	/**
	 * abstract method to be overridden 
	 * in subclass for loading classes info
	 * @return void
	 */
	public abstract void loadExtraInfo();
	
	public abstract String getExtraInfo();
	
	public abstract void setExtraInfo(String s);
		
		
	

}

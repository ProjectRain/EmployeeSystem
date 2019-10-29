package company;

/**Staff.java
 * @author Robleh Nur
 * *@version 2018-12
 * Course: CST8284
 * Assignment due date: April 14, 2019
 *
 *Representing a abstraction of a Staff Employee
 */
import java.util.Scanner;


public class Staff extends Employee {
	/**
	 * The string tells you the department of the Employee
	 */
	
	private String department;
	
	/**
	 * no arg Constructor
	 */
	public Staff() {

	}
	
	/**
	 * Base constructor
	 * super up to parent class to get parameters
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @param department
	 */ 
	public Staff(String name, int emloyeeNumber, OurDate startDate, double salary, String department) {
		super(name, emloyeeNumber, startDate, salary);
		setDepartment(department);
	}
	
	/**
	 * A string is returned and it represents the department
	 * @return String
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * Passes the department variable to the constructor
	 * @param department
	 * @return void
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	
	/**
	 * Overridden from super class
	 * This method asks the user to input the department
	 * @return void
	 */
	@Override
	public void loadExtraInfo() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the department: ");
		String t = in.nextLine();
		in.close();
		setExtraInfo(t);

	}
	public void setExtraInfo(String s) {
		setDepartment(s);
	}
	
	public String getExtraInfo() {
		return getDepartment();
	}
	
	/**
	 * Formatters the data to set of Strings to pass to super class
	 * @return String
	 */
	@Override
	public String toString() {

		String s = getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t\t" + getSalary() + "\t\tTitle:" + department;

		return s;

	}

	/**
	 * Compares to objects
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Staff other = (Staff) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && this.getDepartment() == other.getDepartment());
	}

}
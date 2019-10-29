package company;

/**Manager.java
 * @author Robleh Nur
 * *@version 2018-12
 * Course: CST8284
 * Assignment due date: April 14, 2019
 *
 *Representing a abstraction of a Manager Employee
 */

import java.util.Scanner;

/**
 * The string tells you the title of the Employee
 */
public class Manager extends Employee {
	
	
	public String title;
	
	/**
	 * no arg Constructor
	 */
	public Manager() {
		
	}
	
	/**
	 * Base constructor
	 * super up to parent class to get parameters
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @param title
	 */
	public Manager(String name, int emloyeeNumber, OurDate startDate, double salary, String title) {
		super(name, emloyeeNumber, startDate, salary);
		setTitle(title);
	}
	
	/**
	 * A string is returned and it represents the title
	 * @return String
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Passes the title variable to the constructor
	 * @param department
	 * @return void
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Overridden from super class
	 * This method asks the user to input the manager title
	 * @return void
	 */
	@Override
	public void loadExtraInfo() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter manager's title: ");
		String t = in.nextLine();
		in.close();
		setExtraInfo(t);
	}
	
	public void setExtraInfo(String s) {
		setTitle(s);
	}
	
	public String getExtraInfo() {
		return getTitle();
	}
	
	/**
	 * Formatters the data to set of Strings to pass to super class
	 * @return String
	 */
	@Override
	public String toString() {

		String s = getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t\t" + getSalary() + "\t\tTitle:" +title;

		return s;

	}

	/**
	 * Compares to objects
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Manager other = (Manager) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && this.getTitle().equals(other.getTitle())); 
	}

}

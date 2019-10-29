package company;

/**Temp.java
 * @author Robleh Nur
 * *@version 2018-12
 * Course: CST8284
 * Assignment due date: April 14, 2019
 *
 *Representing a abstraction of a Temp Employee
 */

import java.util.Scanner;


public class Temp extends Employee {
	

	/**
	 * Field created to hold an OurDate object that represents the last day of the contract called endContractDate
	 */
	private OurDate endContractDate;
	
	/**
	 * no arg Constructor
	 * 
	 */
	public Temp() {

	}
	
	/**
	 * Base Constructor
	 * Super up to get the parameters in Employee
	 * @param name
	 * @param employeeNumber
	 * @param startDate
	 * @param salary
	 * @param endConstractDate
	 */
	public Temp(String name, int emloyeeNumber, OurDate startDate, double salary, OurDate endContractDate) {
		super(name, emloyeeNumber, startDate, salary);
		setEndContractDate(endContractDate);
	}
	/**
	 * returns an OurDate that represents the last date of a contract
	 * @return OurDate
	 */
	
	public OurDate getEndContractDate() {
		return endContractDate;
	}
	
	/**
	 * passes endContractDate variable to the constructor
	 * @param endContractDate
	 * @return void
	 */
	public void setEndContractDate(OurDate endContractDate) {
		this.endContractDate = endContractDate;
	}
	
	/**
	 * Overridden from super class
	 * This method asks the user to input the final date of the contract
	 * @return void
	 */
	@Override
	public void loadExtraInfo() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the contract end date: ");
		System.out.print("YEAR: ");
		int year = in.nextInt();

		System.out.print("MONTH: ");
		int month = in.nextInt();

		System.out.print("DAY: ");
		int day = in.nextInt();
		in.close();
		OurDate temp = new OurDate(day,month,year);
		setExtraInfo(temp);
	}
	
	public void setExtraInfo(OurDate s) {
		setEndContractDate(s);
	}
	
	public String getExtraInfo() {
		return getEndContractDate().toString();	
	}
	
	/**
	 * Formatters the data to set of Strings to pass to super class
	 * @return String
	 */
	@Override
	public String toString() {

		String s = getName() + "\t\t" + getEmployeeNumber() + "\t\t" + getStartDate() + "\t\t" + getSalary() + "\t\tEnd of Contract:" + endContractDate;

		return s;

	}

	/**
	 * Compares to objects
	 * @return boolean
	 */
	public boolean equals(Object obj) {
		if ((obj == null) || (this.getClass() != obj.getClass())) return false;
		Temp other = (Temp) obj;		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate()) && this.getEndContractDate().equals(other.getEndContractDate()));
	}

	@Override
	public void setExtraInfo(String s) {
		// TODO Auto-generated method stub
		
	}

}


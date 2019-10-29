package company;

import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**Company.java
 * @author Robleh Nur
 * *@version 2018-12
 * Course: CST8284
 * Assignment due date: April 14, 2019
 *
 *Represents the Company class
 */

//Declaring variables
public class Company {

	File robleh = new File("CurrentEmployees.emp");
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private int currentEmployee = 0;
	/**
	 * Company no arg constructor
	 */
	public Company() {

		//employees.add(new Temp("Alvin Spring", 14, new OurDate(2, 12, 2014), 150000.0, new OurDate(31, 03, 2019)));
		//employees.add(new Staff("Grant Barge", 21, new OurDate(18, 5, 2009), 40000.0, "Sales"));
		//employees.add(new Manager("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269.0, "Vice President"));

	}

	/**
	 * Method instantiates subclasses of Employee
	 * <p>
	 * The method uses a switch statement. The condition is passed by empType. 
	 * Each subclass is added to the employees Arraylist
	 * Otherwise returns null and no employee is added
	 * @param name
	 * @param employeeNumber
	 * @param date
	 * @param salary
	 * @param emptype
	 * @return Employee
	 */
	public Employee addEmployee(String name, int employeeNumber, OurDate startDate, double salary, int empType) {

		switch (empType) {
		case 1:
			Manager man = new Manager(name, employeeNumber, startDate, salary, "");

			return man;
		case 2:
			Staff staff = new Staff(name, employeeNumber, startDate, salary, "");

			return staff;
		case 3:
			OurDate date = new OurDate();
			Temp temp = new Temp(name, employeeNumber, startDate, salary, date);

			return temp;
		}

		return null;


	}

	/**
	 * Returns Arraylist's method of size() to get the size of employees ArrayList
	 * @return int
	 */
	public int currentNumberEmployees() {
		return employees.size();

	}

	/**
	 *Checks to see max employees
	 *has been reached in the employees Arraylist
	 * @return      whether the employee list is full
	 * @throws OutOfMemoryError  If an input or output 
	 *                      exception occurred	 
	 */
	public boolean isMaximumEmployees() {
		try {
			employees.add(new Manager());
			employees.remove(employees.size()-1);
			return false;
		}catch(OutOfMemoryError oome) {
			return true;
		}
	}
	/**
	 * Gets all the employees in an the ArrayList.
	 * @return ArrayList<Employee>
	 */
	public ArrayList<Employee> getEmployees() {
		return employees;

	}
	/**
	 * Find the senior employee by comparing the year, month and day. Save it into 
	 * "senior" and compare the next employee.
	 * @return Employee
	 */
	public Employee findSeniorEmployee() {

		Employee senior = employees.get(0);

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getStartDate().getYear() == senior.getStartDate().getYear()) {

				if (employees.get(i).getStartDate().getMonth() == senior.getStartDate().getMonth()) {

					if (employees.get(i).getStartDate().getDay() < senior.getStartDate().getDay())
						senior = employees.get(i);

				} else if (employees.get(i).getStartDate().getMonth() < senior.getStartDate().getMonth())
					senior = employees.get(i);

			} else if (employees.get(i).getStartDate().getYear() < senior.getStartDate().getYear()) {
				senior = employees.get(i);

			}
		}

		return senior;
	}

	/**
	 * Method deletes an employee using empNumber. 
	 * If empNumber isn't found returns null.
	 * If empNumber is found, removes the Employee obj from employees Arraylist
	 * Saves deleted employee under emp
	 * @param empNum
	 * @return Employee or null
	 */
	public Employee deleteEmployee(int empNum) {
		for (int i = 0; i < employees.size(); i++) {
			if (empNum == employees.get(i).getEmployeeNumber()) {
				Employee emp = employees.get(i);
				employees.remove(i);
				currentEmployee--;
				return emp;
			}
		}
		return null;
	}

	/**
	 * Searches through employees Arraylist to find an employee. 
	 * Uses empNum to find the employee with the same employee number
	 * @param empNum
	 * @return Employee or null
	 */
	public Employee findEmployee(int empNum) {
		for (int i = 0; i < employees.size(); i++) {
			if (empNum == employees.get(i).getEmployeeNumber()) {
				currentEmployee = i;
				return employees.get(i);
			}
		}
		return null;
	}

	/**
	 * Saves current employees list to file. 
	 * Writes employee Object to the file created. 
	 * Closes the file.
	 * @returns void
	 * @throws IOException  If an input or output 
	 *                      exception occurred
	 */
	public void saveEmployeesToFile() throws BadInputException {
		ArrayList<Employee> tmp = getEmployees();
		try (FileOutputStream file = new FileOutputStream("CurrentEmployees.emp");
				ObjectOutputStream output = new ObjectOutputStream(file);) {
			for (Employee i : tmp) {
				output.writeObject(i);
			}

			System.out.printf("Serialized data is saved in CurrentEmployees.emp\n");
		} catch (IOException i) {
			i.printStackTrace();

		}

	}
	/**
	 * Loads an employee Arraylist from file. 
	 * @return void
	 * @throws IOException
	 * @throws EOFException
	 * @throws ClassNotFoundException If an input or output 
	 *                      exception occurred
	 */
	public void loadEmployeesFromFile() throws BadInputException {
	      try {
	          FileInputStream fileIn = new FileInputStream("CurrentEmployees.emp");
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          
	          try {
	        	  while (true) {
	        		  if(isMaximumEmployees()) {
	        			  System.out.println("Maximum heap sized reached, unable to add new employees");
	        			  break;
	        		  }
		        	  employees.add((Employee) in.readObject());
		          }  
	          } catch (EOFException gx) {
	        	  System.out.println("End of file reached; Serialized data is loaded");
	          }  

	          in.close();
	          fileIn.close();
	       } catch (IOException rob) {
	    	   rob.getMessage();
	       } catch (ClassNotFoundException e) {
				e.printStackTrace();
	       }
		
	}

	public int getCurrentEmployeeValue() {
		// TODO Auto-generated method stub
		return currentEmployee;
	}

	public void setCurrentEmployeeValue(int i) {
		// TODO Auto-generated method stub
		if(i > (employees.size()-1) || i < 0) {
			throw new BadInputException("End of list");
		}else {
			currentEmployee = i;
		}
	}

	public Employee getCurrentEmployee() {
		return employees.get(currentEmployee);
	}

}

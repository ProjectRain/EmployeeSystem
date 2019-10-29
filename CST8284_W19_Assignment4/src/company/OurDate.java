package company;
/**OurDate.java
 * @author Robleh Nur
 * *@version 2018-12
 * Course: CST8284
 * Assignment due date: April 14, 2019
 *
 *Representing Date
 */

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.text.ParseException;


//Declaring variables
public class OurDate implements Serializable {
	/**
	 * Create an obj of Calendar to get a
	 * default value for each field created
	 */
	private static final Calendar CALENDAR = Calendar.getInstance();
	/**
	 * Fields created to hold instance of passed int,
	 * representing day, month, year
	 * 
	 */
	private int day;
	private int month;
	private int year;
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * <p>
	 * set the default fields to day, month, year
	 */
	public OurDate() { this(CALENDAR.get(Calendar.DATE), 
			   CALENDAR.get(Calendar.MONTH + 1), 
			   CALENDAR.get(Calendar.YEAR) ); }

	/**
	 * Initial constructor for OurDate
	 * @param day
	 * @param month
	 * @param year
	 */
	public OurDate(int day, int month, int year) {

		if(day < 1 && day > 31) {
			throw new BadInputException("Day must be between 1 and 31");
		}
		if(month < 1 && month > 12) {
			throw new BadInputException("Month must be between 1 and 12");
		}
		if(year < 1950 && year > 2020) {
			throw new BadInputException("Year must be between 1950 and 2020");
		}
		setDay(day);
		setMonth(month);
		setYear(year);
	}


	public int getDay() {

		return day;
	}


	private void setDay(int day) {

		this.day = day;
	}


	public int getMonth() {

		return month;
	}


	private void setMonth(int month) {

		this.month = month;
	}


	public int getYear() {

		return year;
	}


	private void setYear(int year) {

		this.year = year;
	}


	@Override
	public String toString() {

		return this.day + "/" + this.month + "/" + this.year;
	}

	@Override
	public boolean equals(Object obj) {

		if ((obj == null) || (this.getClass() != obj.getClass()))
			return false;
		OurDate other = (OurDate) obj;
		return (this.getDay() == other.getDay() && this.getMonth() == other.getMonth()
				&& this.getYear() == other.getYear());

	}
	
	public boolean setOurDate(String str) {
		boolean result = true;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			String[] dmy = str.split("/");
			setYear(Integer.parseInt(dmy[2]));
			setMonth(Integer.parseInt(dmy[1]));
			setDay(Integer.parseInt(dmy[0]));
			CALENDAR.setTime(dateFormat.parse(str));  // use calendar to check for impossible dates
			return result;
		} catch (NumberFormatException g) {
			throw new InputMismatchException("Bad input value; date " + str + " contains non-numeric value");
		} catch (IllegalArgumentException f) {
			throw new InputMismatchException("Bad data type passed to an internal method");
		}  catch (ParseException h) {
			throw new InputMismatchException("Date " + str + " not possible");
		} catch (RuntimeException e) {
			throw new InputMismatchException("General Runtime exception thrown setting start date");
		} 
	}
	

}

package company;

public class BadInputException extends java.lang.RuntimeException{

	private static String s;
	
	public BadInputException() {
		this(s);
	}
	
	
	public BadInputException(String message) {
		super(message);
	}


}

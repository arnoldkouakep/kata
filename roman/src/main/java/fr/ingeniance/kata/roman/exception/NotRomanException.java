package fr.ingeniance.kata.roman.exception;

public class NotRomanException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotRomanException() {
		super();
	}

	public NotRomanException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NotRomanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotRomanException(String arg0) {
		super(arg0);
	}

	public NotRomanException(Throwable arg0) {
		super(arg0);
	}

}

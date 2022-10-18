package fr.ingeniance.kata.foobarqix.exception;

public class NotFooBarQixException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFooBarQixException() {
		super();
	}

	public NotFooBarQixException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NotFooBarQixException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NotFooBarQixException(String arg0) {
		super(arg0);
	}

	public NotFooBarQixException(Throwable arg0) {
		super(arg0);
	}

	
	
}

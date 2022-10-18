package fr.ingeniance.kata.diamond.exception;

public class DiamondException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiamondException() {
		super();
	}

	public DiamondException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DiamondException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DiamondException(String arg0) {
		super(arg0);
	}

	public DiamondException(Throwable arg0) {
		super(arg0);
	}

	
	
}

package fr.ingeniance.kata.pricer.exception;

public class ItemErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemErrorException() {
		super();
	}

	public ItemErrorException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ItemErrorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ItemErrorException(String arg0) {
		super(arg0);
	}

	public ItemErrorException(Throwable arg0) {
		super(arg0);
	}
}

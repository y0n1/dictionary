package exceptions;

public class WordNotFoundException extends Exception {
	private static final long serialVersionUID = 3109653974872325910L;
	private static final String DEFAULT_MESSAGE = "Word not found!"; 
	
	public WordNotFoundException() {
		super(DEFAULT_MESSAGE);
	}

	public WordNotFoundException(String message) {
		super(message);
	}

	public WordNotFoundException(Throwable cause) {
		super(cause);
	}

	public WordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public WordNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

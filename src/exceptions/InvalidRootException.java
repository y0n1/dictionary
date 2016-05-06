package exceptions;

public class InvalidRootException extends Exception {
	private static final long serialVersionUID = 1707633774136136217L;
	private static final String DEFAULT_MESSAGE = "Invalid root node!";

	public InvalidRootException() {
		super(DEFAULT_MESSAGE);
	}

	public InvalidRootException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidRootException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRootException(String message) {
		super(message);
	}

	public InvalidRootException(Throwable cause) {
		super(cause);
	}

}

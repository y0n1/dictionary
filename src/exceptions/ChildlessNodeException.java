package exceptions;

public class ChildlessNodeException extends Exception {
	private static final long serialVersionUID = -7525067041798298321L;
	private static final String DEFAULT_MESSAGE = "This node has no children!";

	public ChildlessNodeException() {
		super(DEFAULT_MESSAGE);
	}

	public ChildlessNodeException(String message) {
		super(message);
	}

	public ChildlessNodeException(Throwable cause) {
		super(cause);
	}

	public ChildlessNodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChildlessNodeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package awantunai.test.exception;

public class FieldValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6453826770031424475L;

	public FieldValidationException() {
		super();
	}

	public FieldValidationException(String message) {
		super(message);
	}

	public FieldValidationException(Throwable cause) {
		super(cause);
	}

	public FieldValidationException(String message, Throwable cause) {
		super(message, cause);
	}

}

package bill.manager.utils;

/**
 * @author Troublem@ker
 */

public class AddExpensesException extends Exception {

	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public AddExpensesException(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}

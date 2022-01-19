package bill.manager.utils;

/**
 * @author Troublem@ker
 */

public class GroupFailedException extends Exception {

	
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public GroupFailedException(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}

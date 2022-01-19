/**
 * 
 */
package bill.manager.utils;

/**
 * @author Troublem@ker
 */
public class ContactMeException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public ContactMeException(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}

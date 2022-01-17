/**
 * 
 */
package bill.manager.utils;

/**
 * @author Troublem@ker
 */
public class AddBillException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String errorCode;

	public AddBillException(String errorCode, String cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}

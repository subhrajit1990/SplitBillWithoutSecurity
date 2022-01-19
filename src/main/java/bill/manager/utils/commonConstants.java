/**
 * 
 */
package bill.manager.utils;

/**
 * @author Troublem@ker
 */
public class commonConstants {

	private commonConstants() {

	}

	public static final String RSACALLFAILURE = "ABS_RSA_CALL_FAILURE";
	public static final String INCORRECTPAYLOAD = "ABS_RSA_PAYLOAD_INCORRECT";
	public static final String RSAAUTHENTICATEFAILED = "ABS_RSA_AUTH_FAILED";
	public static final String RSADENY = "ABS_RSA_DENY";
	public static final String RSALOCKOUT = "ABS_RSA_LOCKOUT";
	public static final String RSACHALLENGE = "ABS_RSA_CHALLENGE";
	public static final String RSANOTENROLLED = "NOTENROLLED";
	public static final String DATEERROR = "ABS_COM_110";
	public static final String SEVICETIMEDOUTERROR = "ABS_COM_450";
	public static final String CBSTIMEDOUT = "ABS_CBS_1000";
	public static final String SEVICENOTREACHABLEERROR = "ABS_COM_404";
	public static final String SERVICEERROR = "ABS_COM_460";
	public static final String CALCULATIONERROR = "ABS_PRE_260";
	public static final String PERSISTENCEERROR = "ABS_COM_510";
	public static final String PROCESSINGREQUESTERROR = "ABS_COM_600";
	public static final String NORECORD = "ABS_COM_NR100";
	public static final String DELETEBILLERSUCCESS = "ABS_PAY_003";
	public static final String DELETEBILLERPROCESSERROR = "ABS_PAY_001";
	public static final String NOCREDITCARD = "ABS_CARD_007";
	public static final String BLOCKCREDITCARD = "ABS_CARD_004";
	public static final String CREDITCARDPINRESET = "ABS_CARD_008";
	public static final String CREDITCARDSTATEMENT = "ABS_CARD_010";
	public static final String INSERTRECORD = "ABS_COM_100";
	public static final String REQUESTVALIDATIONERROR = "ABS_SERREQ_560";
	public static final String RECORDEXISTSERROR = "ABS_COM_512";
	public static final String TIMEFORMATINVALIDERROR = "ABS_COM_114";
	public static final String DATETIMEFORMATINVALIDERROR = "ABS_COM_116";
	public static final String NONEXISTANTCUSTOMERACCOUNTERROR = "ABS_CMN_007";
	public static final String BENMAXLMTEXD = "ABS_BEN_MAX_LMT_EXD";
	public static final String BENDAILYLMTEXD = "ABS_BEN_DAILY_LMT_EXD";
	public static final String BENMONTHLYLMTEXD = "ABS_BEN-MONTHLY-LMT-EXD";
	public static final String CUSTDAILYLMTEXD = "ABS_CUST_DAILY_LMT_EXD";
	public static final String CUSTMONTHLYLMTEXD = "ABS_CUST_MONTHLY_LMT_EXD";
	public static final String BANKMINLMTEXD = "ABS_BANK_MIN_LMT_EXD";
	public static final String BANKMAXLMTEXD = "ABS_BANK_MAX_LMT_EXD";
	public static final String BANKDAILYLMTEXD = "ABS_BANK_DAILY_LMT_EXD";
	public static final String BANKMONTHLYLMTEXD = "ABS_BANK_MONTHLY_LMT_EXD";
	public static final String LIMITMISSINGERROR = "ABS_LIM_200";
	public static final String DATAINSERTIONSUCCESS = "ABS_COM_001";
	public static final String DATAINSERTIONFAILURE = "ABS_COM_002";
	public static final String CUSTMINLMTEXD = "ABS_CUST_MIN_LMT_EXD";
	public static final String CUSTMAXLMTEXD = "ABS_CUST_MAX_LMT_EXD";
	public static final String CUSTMINLMTEX = "ABS_CUST_MIN_LMT_EXD";
	public static final String DATEFORMATINVALIDERROR = "ABS_COM_112";
	public static final String CBSHOSTERROR = "ABS_COM_470";
	public static final String TXNREFNODUPERR_HOSTID = "COM";
	public static final String TXNREFNODUPERR_HOSTERRCD = "001";

	// For Notification Only
	public static final String FAILURE = "1";
	public static final String SUCCESS = "0";
	public static final String TXNSUCCESS = "Success";
	public static final String TXNFAILED = "Failure";
	public static final String TXNSECURITYKEY = "securitykey";
	public static final String TXNDECRYPTFAILED = "Decryption Failed";
	public static final String TXNUSEREXITS = "User does not exist";
	public static final String TXNDISABLESIGN = "User is not registered for Transaction Signing.";
	public static final String TXNENABLESIGN = "User is registered for Transaction Signing.";
	public static final String TXNPROCCESSSIGN = "Request is already in progress";
	public static final String TXNINVALIDREQUEST = "Invalid Request";
	public static final String TXNUNEXPECTEDERR = "Unexpected error";

	public static final String TXNCODEEXTIT = "02";
	public static final String TXNSUCEESSCODE = "00";
	public static final String TXNDECYPTCODE = "04";
	public static final String TXNFILEDCODE = "01";
	public static final String TXNINVALIDCODE = "400";
	public static final String TXNDISABLEFALGCODE = "03";
	public static final String TXNTIMEOUTCODE = "408";
	public static final String TXNFAILEDCODE = "404";
	// End of Transaction Signing Constants
	public static final String SECURITY_USER = "user";
	public static final String SECURITY_CRED = "pwd";
	// For QR Pay

	/* Expense Module -- STARTS */
	public static final String EQUAL = "EQUAL";
	public static final String PERCENT = "PERCENT";
	public static final String EXACT = "EXACT";
	public static final String EXPENSE_DELETION = " Deletion successful";
	public static final String GROUP_FETCH_ERROR = " Unable to fetch the groups";
	public static final String GROUP_FETCH_SUCCESS = "Able to fetch the groups";
	public static final String GROUP_FETCH_NO_RECORD = "No Records availble";

	/* Expense Module -- ENDS */

}

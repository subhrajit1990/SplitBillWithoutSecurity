package bill.manager.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import bill.manager.model.ResponseHeader;

/**
 * @author Troublem@ker
 */

public class CommonUtils {

	public static final String FAILURE = commonConstants.FAILURE;
	public static final String SUCCESS = commonConstants.SUCCESS;
	

	private CommonUtils() {
	}

	public static void generateHeaderForSoapConnectionFailure(ResponseHeader responseHeader) {

		responseHeader.setResponseCode(FAILURE);
		responseHeader.setErrorCode(commonConstants.SEVICENOTREACHABLEERROR);
		responseHeader.setErrorMessage(commonConstants.SEVICENOTREACHABLEERROR);
	}

	public static void generateHeaderForNoResult(ResponseHeader responseHeader) {
		responseHeader.setHttpStatus(HttpStatus.OK);
		responseHeader.setErrorCode(commonConstants.NORECORD);
		responseHeader.setErrorMessage(commonConstants.NORECORD);
		responseHeader.setResponseCode(FAILURE);
	}

	public static void generateHeaderForDBError(ResponseHeader responseHeader) {
		responseHeader.setHttpStatus(HttpStatus.OK);
		responseHeader.setResponseCode(FAILURE);
		responseHeader.setErrorCode(commonConstants.PERSISTENCEERROR);
		responseHeader.setErrorMessage(commonConstants.PERSISTENCEERROR);
	}

	public static void generateHeaderForGenericError(ResponseHeader responseHeader) {
		responseHeader.setHttpStatus(HttpStatus.OK);
		responseHeader.setResponseCode(FAILURE);
		responseHeader.setErrorCode(commonConstants.PROCESSINGREQUESTERROR);
		responseHeader.setErrorMessage(commonConstants.PROCESSINGREQUESTERROR);
	}

	public static void generateHeaderForSuccess(ResponseHeader responseHeader) {
		responseHeader.setResponseCode(SUCCESS);
		responseHeader.setHttpStatus(HttpStatus.OK);
	}

	public static Timestamp currentTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return Timestamp.valueOf(localDateTime);

	}

}

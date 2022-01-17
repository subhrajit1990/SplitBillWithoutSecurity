/**
 * 
 */
package bill.manager.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class ResponseHeader {

	@ApiModelProperty(example = "0", allowableValues = "0, 1", position = 1, value = "Code to indicate status of service call for the given endpoint")
	@JsonProperty("ResponseCode")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String responseCode;
	
	@ApiModelProperty(example = "110", allowableValues = "110,560,450,404,460,260,510,600,NR100,DB_003,DB_001,CC_007,CC_004,CC_008,CC_007", position = 2, value = "Code to indicate the reason for failure, if any, for the given endpoint")
	@JsonProperty("ErrorCode")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorCode;
	
	@ApiModelProperty(example = "Service Not available", position = 3, value = "Message to indicate the reason for failure, if any, for the given endpoint", allowableValues = "110: Date and Time is invalid,560: Request Validation Failed,450: Timed out trying to reach external service,404: Unable to reach the service,460: Service Response Invalid,260: Calculation Error,510: Error Processing Request,600: Error Processing Request,NR100: No Record/Data Found,DB_003: Biller deleted successfully,DB_001: Error occured while deleting the biller,CC_007: No Credit Card Found,CC_004: Request has been raised to block the credit card,CC_008: PIN has been successfully reset,CC_007: No credit card statement found")
	@JsonProperty("ErrorMessage")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorMessage;
	
	@ApiModelProperty(example = "404", position = 4, value = "Message to indicate the reason for failure, if any, for the given endpoint", allowableValues = "110: Date and Time is invalid,560: Request Validation Failed,450: Timed out trying to reach external service,404: Unable to reach the service,460: Service Response Invalid,260: Calculation Error,510: Error Processing Request,600: Error Processing Request,NR100: No Record/Data Found,DB_003: Biller deleted successfully,DB_001: Error occured while deleting the biller,CC_007: No Credit Card Found,CC_004: Request has been raised to block the credit card,CC_008: PIN has been successfully reset,CC_007: No credit card statement found")
	@JsonProperty("httpStatus")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private HttpStatus httpStatus;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
	
}

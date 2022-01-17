/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class DeleteExpensesResponse {

	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${SplitBillRequest.deletionCode.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("deletionCode")
	private String deletionCode;

	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${SplitBillRequest.deletionMessage.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("deletionMessage")
	private String deletionMessage;

	public String getDeletionCode() {
		return deletionCode;
	}

	public void setDeletionCode(String deletionCode) {
		this.deletionCode = deletionCode;
	}

	public String getDeletionMessage() {
		return deletionMessage;
	}

	public void setDeletionMessage(String deletionMessage) {
		this.deletionMessage = deletionMessage;
	}

	@Override
	public String toString() {
		return "DeleteExpensesResponse [deletionCode=" + deletionCode + ", deletionMessage=" + deletionMessage + "]";
	}

}

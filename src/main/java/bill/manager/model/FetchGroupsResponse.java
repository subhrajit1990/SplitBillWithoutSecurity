/**
 * 
 */
package bill.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

public class FetchGroupsResponse {

	@ApiModelProperty(example = "12", position = 1, required = true, value = "${SplitBillRequest.groupId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groups")
	private List<Groups> groups;

	@ApiModelProperty(example = "10", position = 2, required = true, value = "${SplitBillRequest.statusCode.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("statusCode")
	private String statusCode;

	@ApiModelProperty(example = "Success", position = 3, required = true, value = "${SplitBillRequest.statusMessage.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("statusMessage")
	private String statusMessage;

	
	public List<Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "FetchGroupsResponse [groups=" + groups + ", statusCode=" + statusCode + ", statusMessage="
				+ statusMessage + "]";
	}
	
	

}

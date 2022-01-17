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

public class ToDoResponse {

	
	@ApiModelProperty(example = "SUC", position = 1, required = true, value = "${SplitBillRequest.groupStatus.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupStatus")
	private String groupStatus;

	public String getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}


}

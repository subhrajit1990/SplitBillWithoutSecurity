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
public class AddMembersResponse {

	
	@ApiModelProperty(example = "SUC", position = 1, required = true, value = "${SplitBillRequest.memberStatus.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("memberStatus")
	private String memberStatus;

	
	
	public String getMemberStatus() {
		return memberStatus;
	}



	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}



	@Override
	public String toString() {
		return "AddMembersResponse [memberStatus=" + memberStatus + "]";
	}
	
	
	

}

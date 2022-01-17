/**
 * 
 */
package bill.manager.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class AddMembersRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupId")
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${SplitBillRequest.groupId.value}")
	private String groupId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupMembers")
	@ApiModelProperty(example = "Subhrajit", position = 2, required = true, value = "${SplitBillRequest.members.value}")
	private List<Members> members = new ArrayList<>();

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<Members> getMembers() {
		return members;
	}

	public void setMembers(List<Members> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "AddMembersRequest [groupId=" + groupId + ", members=" + members + "]";
	}

	


}

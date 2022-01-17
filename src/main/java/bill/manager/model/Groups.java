/**
 * 
 */
package bill.manager.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class Groups {

	@ApiModelProperty(example = "12", position = 1, required = true, value = "${SplitBillRequest.groupId.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupId")
	private String groupId;

	@ApiModelProperty(example = "Dinner", position = 2, required = true, value = "${SplitBillRequest.groupName.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupName")
	private String groupName;

	@ApiModelProperty(example = "30-05-2021", position = 3, required = true, value = "${SplitBillRequest.createdDt.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("createdDt")
	private Timestamp createdDt;

	@ApiModelProperty(example = "Dinner", position = 4, required = true, value = "${SplitBillRequest.groupType.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupType")
	private String groupType;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Timestamp getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", groupName=" + groupName + ", createdDt=" + createdDt + ", groupType="
				+ groupType + "]";
	}

}

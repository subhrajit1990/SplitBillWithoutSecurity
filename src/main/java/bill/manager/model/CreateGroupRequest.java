package bill.manager.model;

import java.util.List;

import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

@PropertySource("classpath:/Swagger-SplitBill-Properties/SplitBill-rest.properties")
public class CreateGroupRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupName")
	@ApiModelProperty(example = "KL Trip", position = 1, required = true, value = "${SplitBillRequest.name.value}")
	private String groupName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupType")
	@ApiModelProperty(example = "Trip", position = 2, required = true, value = "${SplitBillRequest.groupType.value}")
	private String groupType;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupMembers")
	@ApiModelProperty(example = "Subhrajit", position = 3, required = true, value = "${SplitBillRequest.members.value}")
	List<Members> groupMembers;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("creatorAccountNumber")
	@ApiModelProperty(example = "102347865785643", position = 4, required = true, value = "${SplitBillRequest.creatorAccountNumber.value}")
	private String creatorAccountNumber;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	

	public List<Members> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(List<Members> groupMembers) {
		this.groupMembers = groupMembers;
	}

	public String getCreatorAccountNumber() {
		return creatorAccountNumber;
	}

	public void setCreatorAccountNumber(String creatorAccountNumber) {
		this.creatorAccountNumber = creatorAccountNumber;
	}
	

	
	
}

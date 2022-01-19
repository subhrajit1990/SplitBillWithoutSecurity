package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class CreateGroupRequestWrapper {

	
	@JsonProperty("createGroupRequest")
	private CreateGroupRequest createGroupRequest;

	public CreateGroupRequest getCreateGroupRequest() {
		return createGroupRequest;
	}

	public void setCreateGroupRequest(CreateGroupRequest createGroupRequest) {
		this.createGroupRequest = createGroupRequest;
	}

	
	
}

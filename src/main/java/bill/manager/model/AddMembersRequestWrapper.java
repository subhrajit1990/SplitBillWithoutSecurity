/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class AddMembersRequestWrapper {
	
	@JsonProperty("addMembersRequest")
	private AddMembersRequest addMembersRequest;

	public AddMembersRequest getAddMembersRequest() {
		return addMembersRequest;
	}

	public void setAddMembersRequest(AddMembersRequest addMembersRequest) {
		this.addMembersRequest = addMembersRequest;
	}
	
}

/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class ContactMeResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("createGroupResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CreateGroupResponse createGroupResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public CreateGroupResponse getCreateGroupResponse() {
		return createGroupResponse;
	}

	public void setCreateGroupResponse(CreateGroupResponse createGroupResponse) {
		this.createGroupResponse = createGroupResponse;
	}

	
	
}

/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class FetchGroupsResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("fetchGroupsResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private FetchGroupsResponse fetchGroupResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public FetchGroupsResponse getFetchGroupResponse() {
		return fetchGroupResponse;
	}

	public void setFetchGroupResponse(FetchGroupsResponse fetchGroupResponse) {
		this.fetchGroupResponse = fetchGroupResponse;
	}

	
}

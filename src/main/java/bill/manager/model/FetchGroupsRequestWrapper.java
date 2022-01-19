package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class FetchGroupsRequestWrapper {

	
	@JsonProperty("fetchGroupsRequest")
	private FetchGroupsRequest fetchGroupsRequest;

	public FetchGroupsRequest getFetchGroupsRequest() {
		return fetchGroupsRequest;
	}

	public void setFetchGroupsRequest(FetchGroupsRequest fetchGroupsRequest) {
		this.fetchGroupsRequest = fetchGroupsRequest;
	}

	
	
}

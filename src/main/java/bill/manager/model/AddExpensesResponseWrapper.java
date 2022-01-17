/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class AddExpensesResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("addMembersResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private AddExpensesListResponse addExpensesListResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public AddExpensesListResponse getAddExpensesListResponse() {
		return addExpensesListResponse;
	}

	public void setAddExpensesListResponse(AddExpensesListResponse addExpensesListResponse) {
		this.addExpensesListResponse = addExpensesListResponse;
	}

	@Override
	public String toString() {
		return "AddExpensesResponseWrapper [responseHeader=" + responseHeader + ", addExpensesListResponse="
				+ addExpensesListResponse + "]";
	}

	
}

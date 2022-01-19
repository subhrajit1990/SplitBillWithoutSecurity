/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class DeleteExpensesResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("deleteExpensesResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private DeleteExpensesResponse deleteExpensesResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public DeleteExpensesResponse getDeleteExpensesResponse() {
		return deleteExpensesResponse;
	}

	public void setDeleteExpensesResponse(DeleteExpensesResponse deleteExpensesResponse) {
		this.deleteExpensesResponse = deleteExpensesResponse;
	}

	@Override
	public String toString() {
		return "DeleteExpensesResponseWrapper [responseHeader=" + responseHeader + ", deleteExpensesResponse="
				+ deleteExpensesResponse + "]";
	}

	
	
	
	
}

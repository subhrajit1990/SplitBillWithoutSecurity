package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class FetchExpensesRequestWrapper {

	@JsonProperty("fetchExpensesRequest")
	private FetchExpense fetchExpensesRequest;

	public FetchExpense getFetchExpensesRequest() {
		return fetchExpensesRequest;
	}

	public void setFetchExpensesRequest(FetchExpense fetchExpensesRequest) {
		this.fetchExpensesRequest = fetchExpensesRequest;
	}

	
}

package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class AddExpensesRequestWrapper {

	@JsonProperty("addExpensesRequest")
	private Expense addExpensesRequest;

	public Expense getAddExpensesRequest() {
		return addExpensesRequest;
	}

	public void setAddExpensesRequest(Expense addExpensesRequest) {
		this.addExpensesRequest = addExpensesRequest;
	}

}

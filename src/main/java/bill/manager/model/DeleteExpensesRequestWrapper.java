package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class DeleteExpensesRequestWrapper {

	@JsonProperty("deleteExpensesRequest")
	private DeleteExpense deleteExpensesRequest;

	public DeleteExpense getDeleteExpensesRequest() {
		return deleteExpensesRequest;
	}

	public void setDeleteExpensesRequest(DeleteExpense deleteExpensesRequest) {
		this.deleteExpensesRequest = deleteExpensesRequest;
	}

	
	
}

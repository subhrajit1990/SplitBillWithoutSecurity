/**
 * 
 */
package bill.manager.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class AddExpensesListResponse {

	
	@ApiModelProperty(example = "No Bill Found", position = 1, required = true, value = "${SplitBillRequest.addExpensesListResponse.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("addExpensesListResponse")
	private Map<String,List<AddExpensesResponse>> addExpenseListResponse;

	public Map<String, List<AddExpensesResponse>> getAddExpenseListResponse() {
		return addExpenseListResponse;
	}

	public void setAddExpenseListResponse(Map<String, List<AddExpensesResponse>> addExpenseListResponse) {
		this.addExpenseListResponse = addExpenseListResponse;
	}

	@Override
	public String toString() {
		return "AddExpensesListResponse [addExpenseListResponse=" + addExpenseListResponse + "]";
	}
	
	


}

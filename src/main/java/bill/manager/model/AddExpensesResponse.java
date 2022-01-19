/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class AddExpensesResponse {

	
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${SplitBillRequest.paidBy.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("paidBy")
	private String paidBy;

	@ApiModelProperty(example = "DonalDuck", position = 2, required = true, value = "${SplitBillRequest.paidTo.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("paidTo")
	private String paidTo;
	
	
	@ApiModelProperty(example = "DonalDuck", position = 2, required = true, value = "${SplitBillRequest.paidTo.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("amount")
	private String amount;


	public String getPaidBy() {
		return paidBy;
	}


	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}


	public String getPaidTo() {
		return paidTo;
	}


	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "AddExpensesResponse [paidBy=" + paidBy + ", paidTo=" + paidTo + ", amount=" + amount + "]";
	}
	
	
	

}

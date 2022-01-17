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
public class Split {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("user")
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${SplitBillRequest.paidBy.value}")
	 private Members user;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("amount")
	@ApiModelProperty(example = "123", position = 2, required = true, value = "${SplitBillRequest.amount.value}")
	double amount;

	public Members getUser() {
		return user;
	}

	public void setUser(Members user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Split [user=" + user + ", amount=" + amount + "]";
	}
	

}

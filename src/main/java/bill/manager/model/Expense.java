/**
 * 
 */
package bill.manager.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class Expense {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupId")
	@ApiModelProperty(example = "1233", position = 1, required = true, value = "${SplitBillRequest.groupId.value}")
	private int id;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("amount")
	@ApiModelProperty(example = "123", position = 2, required = true, value = "${SplitBillRequest.amount.value}")
	private double amount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("paidBy")
	@ApiModelProperty(example = "Subhrajit", position = 3, required = true, value = "${SplitBillRequest.paidBy.value}")
	private String paidBy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("splits")
	@ApiModelProperty(example = "Subhrajit", position = 4, required = true, value = "${SplitBillRequest.splits.value}")
	private Map<String, Object> splits = new HashMap<>();

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("expenseType")
	@ApiModelProperty(example = "EQUAL", position = 5, required = true, value = "${SplitBillRequest.ExpenseType.value}")
	private String expenseType;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("billId")
	@ApiModelProperty(example = "1233", position = 6, required = true, value = "${SplitBillRequest.billId.value}")
	private String billId;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}

	public Map<String, Object> getSplits() {
		return splits;
	}

	public void setSplits(Map<String, Object> splits) {
		this.splits = splits;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", amount=" + amount + ", paidBy=" + paidBy + ", splits=" + splits
				+ ", expenseType=" + expenseType + ", billId=" + billId + "]";
	}

}

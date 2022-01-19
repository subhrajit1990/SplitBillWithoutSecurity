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
public class DeleteExpense {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("groupId")
	@ApiModelProperty(example = "1233", position = 1, required = true, value = "${SplitBillRequest.groupId.value}")
	private int id;

	
	@JsonProperty("billId")
	@ApiModelProperty(example = "1233", position = 6, required = true, value = "${SplitBillRequest.billId.value}")
	private String billId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

}

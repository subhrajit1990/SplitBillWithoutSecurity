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
public class Members {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("accountName")
	@ApiModelProperty(example = "KL Trip", position = 1, required = true, value = "${SplitBillRequest.accountName.value}")
	private String accountName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("memberAccountNumber")
	@ApiModelProperty(example = "102347865785643", position = 2, required = true, value = "${SplitBillRequest.memberAccountNumber.value}")
	private String memberAccountNumber;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getMemberAccountNumber() {
		return memberAccountNumber;
	}

	public void setMemberAccountNumber(String memberAccountNumber) {
		this.memberAccountNumber = memberAccountNumber;
	}

	@Override
	public String toString() {
		return "Members [accountName=" + accountName + ", memberAccountNumber=" + memberAccountNumber + "]";
	}
	
	

}

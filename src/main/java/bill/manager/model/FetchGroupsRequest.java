package bill.manager.model;

import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

@PropertySource("classpath:/Swagger-SplitBill-Properties/SplitBill-rest.properties")
public class FetchGroupsRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("creatorAccountNumber")
	@ApiModelProperty(example = "102347865785643", position = 1, required = true, value = "${SplitBillRequest.creatorAccountNumber.value}")
	private String creatorAccountNumber;

	public String getCreatorAccountNumber() {
		return creatorAccountNumber;
	}

	public void setCreatorAccountNumber(String creatorAccountNumber) {
		this.creatorAccountNumber = creatorAccountNumber;
	}

	@Override
	public String toString() {
		return "FetchGroupsRequest [creatorAccountNumber=" + creatorAccountNumber + "]";
	}

}

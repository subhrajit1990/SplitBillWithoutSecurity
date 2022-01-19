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
public class Status {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("status")
	@ApiModelProperty(example = "Welcome", position = 1, required = true, value = "Welcome")
	private String statusValue;

	public String getStatusValue() {
		return statusValue;
	}

	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

}

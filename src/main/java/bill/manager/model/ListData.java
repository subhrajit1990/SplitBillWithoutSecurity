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
public class ListData {
	
	@ApiModelProperty(example = "121", position = 1, required = true, value = "${SplitBillRequest.id.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("id")
	private long id;
	
	@ApiModelProperty(example = "Meeting at 3", position = 2, required = true, value = "${SplitBillRequest.id.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("text")
	private String text;
	
	@ApiModelProperty(example = "Meeting at 3", position = 3, required = true, value = "${SplitBillRequest.id.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("createdDate")
	private String createdDate;
	
	@ApiModelProperty(example = "Meeting at 3", position = 4, required = true, value = "${SplitBillRequest.id.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("updateDate")
	private String updateDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "ListData [id=" + id + ", text=" + text + ", createdDate=" + createdDate + ", updateDate=" + updateDate
				+ "]";
	}

	
	
}

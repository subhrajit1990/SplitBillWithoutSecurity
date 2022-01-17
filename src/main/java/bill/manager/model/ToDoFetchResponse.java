/**
 * 
 */
package bill.manager.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

public class ToDoFetchResponse {

	@ApiModelProperty(example = "121", position = 1, required = true, value = "${SplitBillRequest.id.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("id")
	private long id;

	@ApiModelProperty(example = "mobile", position = 2, required = true, value = "${SplitBillRequest.channel.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("channel")
	private String channel;

	@ApiModelProperty(example = "mobile", position = 3, required = true, value = "${SplitBillRequest.createdDt.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("createdDt")
	private String createdDt;

	@ApiModelProperty(example = "No Bill Found", position = 4, required = true, value = "${SplitBillRequest.listData.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("listData")
	private List<ListData> listData = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(String createdDt) {
		this.createdDt = createdDt;
	}

	public List<ListData> getListData() {
		return listData;
	}

	public void setListData(List<ListData> listData) {
		this.listData = listData;
	}

	@Override
	public String toString() {
		return "ToDoFetchResponse [id=" + id + ", channel=" + channel + ", createdDt=" + createdDt + ", listData="
				+ listData + "]";
	}

}

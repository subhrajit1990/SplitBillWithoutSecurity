package bill.manager.model;

import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

@PropertySource("classpath:/Swagger-SplitBill-Properties/SplitBill-rest.properties")
public class ToDoFetchRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoId")
	@ApiModelProperty(example = "1245323", position = 1, required = true, value = "${ToDoFetchRequest.toDoId.value}")
	private String toDoId;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("appId")
	@ApiModelProperty(example = "mobile", position = 2, required = true, value = "${ToDoAddRequest.appId.value}")
	private String appId;

	public String getToDoId() {
		return toDoId;
	}

	public void setToDoId(String toDoId) {
		this.toDoId = toDoId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

}

package bill.manager.model;

import java.util.List;

import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

@PropertySource("classpath:/Swagger-SplitBill-Properties/SplitBill-rest.properties")
public class ToDoAddRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoId")
	@ApiModelProperty(example = "1245323", position = 1, required = true, value = "${ToDoAddRequest.toDoId.value}")
	private String toDoId;
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoList")
	@ApiModelProperty(example = "Attend meeting at 3 PM", position = 2, required = true, value = "${ToDoAddRequest.toDoList.value}")
	List<ToDoListText> toDoList;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("appId")
	@ApiModelProperty(example = "mobile", position = 3, required = true, value = "${ToDoAddRequest.appId.value}")
	private String appId;

	public String getToDoId() {
		return toDoId;
	}

	public void setToDoId(String toDoId) {
		this.toDoId = toDoId;
	}

	public List<ToDoListText> getToDoList() {
		return toDoList;
	}

	public void setToDoList(List<ToDoListText> toDoList) {
		this.toDoList = toDoList;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "ToDoAddRequest [toDoId=" + toDoId + ", toDoList=" + toDoList + ", appId=" + appId + "]";
	}
	
	

}

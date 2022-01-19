package bill.manager.model;


import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

@PropertySource("classpath:/Swagger-SplitBill-Properties/SplitBill-rest.properties")
public class ToDoDeleteRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoId")
	@ApiModelProperty(example = "KL Trip", position = 1, required = true, value = "${ToDoDeleteRequest.toDoId.value}")
	private String toDoId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoListId")
	@ApiModelProperty(example = "Trip", position = 2, required = true, value = "${ToDoDeleteRequest.toDoListId.value}")
	private String toDoListId;

	public String getToDoId() {
		return toDoId;
	}

	public void setToDoId(String toDoId) {
		this.toDoId = toDoId;
	}

	public String getToDoListId() {
		return toDoListId;
	}

	public void setToDoListId(String toDoListId) {
		this.toDoListId = toDoListId;
	}
	
	
	
}

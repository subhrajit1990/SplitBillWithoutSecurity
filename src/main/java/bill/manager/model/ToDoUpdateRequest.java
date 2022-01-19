package bill.manager.model;


import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */

@PropertySource("classpath:/Swagger-SplitBill-Properties/SplitBill-rest.properties")
public class ToDoUpdateRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoId")
	@ApiModelProperty(example = "534534", position = 1, required = true, value = "${ToDoDeleteRequest.toDoId.value}")
	private String toDoId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDoListId")
	@ApiModelProperty(example = "323", position = 2, required = true, value = "${ToDoDeleteRequest.toDoListId.value}")
	private String toDoListId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("text")
	@ApiModelProperty(example = "Trip", position = 3, required = true, value = "${ToDoDeleteRequest.text.value}")
	private String text;
	

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	
}

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
public class ToDoListText {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("toDotext")
	@ApiModelProperty(example = "KL Trip", position = 1, required = true, value = "${ToDoList.toDotext.value}")
	private String toDotext;

	public String getToDotext() {
		return toDotext;
	}

	public void setToDotext(String toDotext) {
		this.toDotext = toDotext;
	}
	
	
}

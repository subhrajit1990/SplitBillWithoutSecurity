package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class ToDoAddRequestWrapper {

	
	@JsonProperty("toDoAddRequest")
	private ToDoAddRequest toDoAddRequest;

	public ToDoAddRequest getToDoAddRequest() {
		return toDoAddRequest;
	}

	public void setToDoAddRequest(ToDoAddRequest toDoAddRequest) {
		this.toDoAddRequest = toDoAddRequest;
	}
	
	
	
}

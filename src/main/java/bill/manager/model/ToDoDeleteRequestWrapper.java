package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class ToDoDeleteRequestWrapper {

	
	@JsonProperty("toDoDeleteRequest")
	private ToDoDeleteRequest toDoDeleteRequest;

	public ToDoDeleteRequest getToDoDeleteRequest() {
		return toDoDeleteRequest;
	}

	public void setToDoDeleteRequest(ToDoDeleteRequest toDoDeleteRequest) {
		this.toDoDeleteRequest = toDoDeleteRequest;
	}

	
}

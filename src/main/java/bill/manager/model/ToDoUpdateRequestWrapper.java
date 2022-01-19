package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class ToDoUpdateRequestWrapper {

	
	@JsonProperty("toDoUpdateRequest")
	private ToDoUpdateRequest toDoUpdateRequest;

	public ToDoUpdateRequest getToDoUpdateRequest() {
		return toDoUpdateRequest;
	}

	public void setToDoUpdateRequest(ToDoUpdateRequest toDoUpdateRequest) {
		this.toDoUpdateRequest = toDoUpdateRequest;
	}


}

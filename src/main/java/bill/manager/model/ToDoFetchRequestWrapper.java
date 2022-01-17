package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class ToDoFetchRequestWrapper {

	
	@JsonProperty("toDoFetchRequest")
	private ToDoFetchRequest toDoFetchRequest;

	public ToDoFetchRequest getToDoFetchRequest() {
		return toDoFetchRequest;
	}

	public void setToDoFetchRequest(ToDoFetchRequest toDoFetchRequest) {
		this.toDoFetchRequest = toDoFetchRequest;
	}

	
}

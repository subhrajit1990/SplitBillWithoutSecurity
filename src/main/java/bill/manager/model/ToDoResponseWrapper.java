/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class ToDoResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("toDoResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ToDoResponse toDoResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public ToDoResponse getToDoResponse() {
		return toDoResponse;
	}

	public void setToDoResponse(ToDoResponse toDoResponse) {
		this.toDoResponse = toDoResponse;
	}

}

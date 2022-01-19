/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class ToDoFetchResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("toDoFetchResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ToDoFetchResponse toDoFetchResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public ToDoFetchResponse getToDoFetchResponse() {
		return toDoFetchResponse;
	}

	public void setToDoFetchResponse(ToDoFetchResponse toDoFetchResponse) {
		this.toDoFetchResponse = toDoFetchResponse;
	}


	
}

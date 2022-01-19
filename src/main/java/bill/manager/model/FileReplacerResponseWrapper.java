/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class FileReplacerResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("fileReplacereResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private FileReplacerResponse fileReplacerResponse;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public FileReplacerResponse getFileReplacerResponse() {
		return fileReplacerResponse;
	}

	public void setFileReplacerResponse(FileReplacerResponse fileReplacerResponse) {
		this.fileReplacerResponse = fileReplacerResponse;
	}

}

package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */

public class FileReplacerRequestWrapper {

	@JsonProperty("fileReplacerRequest")
	private FileReplacerRequest fileReplacerRequest;

	public FileReplacerRequest getFileReplacerRequest() {
		return fileReplacerRequest;
	}

	public void setFileReplacerRequest(FileReplacerRequest fileReplacerRequest) {
		this.fileReplacerRequest = fileReplacerRequest;
	}
	
	

}

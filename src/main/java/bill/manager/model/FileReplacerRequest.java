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
public class FileReplacerRequest {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("firstFile")
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${FileReplacerRequest.firstFile.value}")
	private String firstFile;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("secondFile")
	@ApiModelProperty(example = "Subhrajit", position = 2, required = true, value = "${FileReplacerRequest.secondFile.value}")
	private String secondFile;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("validator")
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${FileReplacerRequest.validator.value}")
	private String validator;

	public String getFirstFile() {
		return firstFile;
	}

	public void setFirstFile(String firstFile) {
		this.firstFile = firstFile;
	}

	public String getSecondFile() {
		return secondFile;
	}

	public void setSecondFile(String secondFile) {
		this.secondFile = secondFile;
	}

	public String getValidator() {
		return validator;
	}

	public void setValidator(String validator) {
		this.validator = validator;
	}

}

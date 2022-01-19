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
public class GameCardResponse {

	
	@ApiModelProperty(example = "Subhrajit", position = 1, required = true, value = "${GameCardRes.cardIcon.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("cardIcon")
	private String cardIcon;

	public String getCardIcon() {
		return cardIcon;
	}

	public void setCardIcon(String cardIcon) {
		this.cardIcon = cardIcon;
	}


}

/**
 * 
 */
package bill.manager.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Troublem@ker
 */
public class GameCardsListResponse {

	
	@ApiModelProperty(example = "No cards found", position = 1, required = true, value = "${GameCardRes.gameCards.value}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("gameCardResponse")
	private List<GameCardResponse> gameCardResponse;

	public List<GameCardResponse> getGameCardResponse() {
		return gameCardResponse;
	}

	public void setGameCardResponse(List<GameCardResponse> gameCardResponse) {
		this.gameCardResponse = gameCardResponse;
	}

	
	
}

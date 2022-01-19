/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class GameCardsResponseWrapper {

	@JsonProperty("ResponseHeader")
	private ResponseHeader responseHeader;

	@JsonProperty("gameCardListResponse")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private GameCardsListResponse gameCardListResponse;

	
	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}


	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}


	public GameCardsListResponse getGameCardListResponse() {
		return gameCardListResponse;
	}


	public void setGameCardListResponse(GameCardsListResponse gameCardListResponse) {
		this.gameCardListResponse = gameCardListResponse;
	}


	@Override
	public String toString() {
		return "GameCardsResponseWrapper [responseHeader=" + responseHeader + ", gameCardListResponse="
				+ gameCardListResponse + "]";
	}

}

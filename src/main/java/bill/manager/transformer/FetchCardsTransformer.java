/**
 * 
 */
package bill.manager.transformer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import bill.manager.domain.FetchCardsTransformerResponse;

/**
 * @author Troublem@ker
 */
public class FetchCardsTransformer extends HystrixCommand<FetchCardsTransformerResponse> {
	private static final Logger logger = LogManager.getLogger(FetchCardsTransformer.class);
	private Integer httpStatus;
	private Integer timeout = 10000;
	private JSONObject hystrixPayload;

	public FetchCardsTransformer() {
		super(HystrixCommandGroupKey.Factory.asKey("FetchCardServiceGroup"));
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.FetchCardsTransformer.execution.isolation.thread.timeoutInMilliseconds", timeout);
	}

	@Override
	protected FetchCardsTransformerResponse run() throws Exception {
		System.out.println("calling this service");
		logger.info("calling this service");
		String uri = "";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		JSONObject hystrixFinalPayload = getpayload();
		HttpEntity<JSONObject> requestBody = new HttpEntity<>(hystrixFinalPayload, headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(uri, requestBody, FetchCardsTransformerResponse.class);
	}

	@Override
	protected FetchCardsTransformerResponse getFallback() {
		FetchCardsTransformerResponse fetchCardsTransformerResponse = new FetchCardsTransformerResponse();

		if (isResponseTimedOut()) {

		} else if (getHttpStatus() == 404) {

		} else {

		}

		System.out.println(" HELLO RESPONSE " + fetchCardsTransformerResponse.toString());
		return fetchCardsTransformerResponse;
	}

	/**
	 * @return
	 */
	private JSONObject getpayload() {
		return hystrixPayload;
	}

	/**
	 * @param finalPayload
	 */
	public void setPayload(JSONObject finalPayload) {
		this.hystrixPayload = finalPayload;

	}

	public Integer getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(Integer httpStatus) {
		this.httpStatus = httpStatus;
	}

}

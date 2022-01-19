/**
 * 
 */
package bill.manager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Troublem@ker
 */
public class ContactMeRequestWrapper {

	@JsonProperty("contactMeRequest")
	private ContactMeRequest contactMeRequest;

	public ContactMeRequest getContactMeRequest() {
		return contactMeRequest;
	}

	public void setContactMeRequest(ContactMeRequest contactMeRequest) {
		this.contactMeRequest = contactMeRequest;
	}
	

}

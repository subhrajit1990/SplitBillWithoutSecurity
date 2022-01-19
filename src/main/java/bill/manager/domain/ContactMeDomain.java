package bill.manager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Troublem@ker
 */

@Entity
@Table(name = "CONTACT_ME")
public class ContactMeDomain extends CommonEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "channel")
	private String channel;
	
	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "message")
	private String message;
	
	@Column(name="master_txn_no")
	private String masterTxnNo;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMasterTxnNo() {
		return masterTxnNo;
	}

	public void setMasterTxnNo(String masterTxnNo) {
		this.masterTxnNo = masterTxnNo;
	}
	
	
	
	
}

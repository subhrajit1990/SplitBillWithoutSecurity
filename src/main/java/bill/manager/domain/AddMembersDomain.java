package bill.manager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Troublem@ker
 */

@Entity
@Table(name = "SPLIT_ADD_MEMBERS")
@IdClass(MembersIdDomain.class)
public class AddMembersDomain extends CommonEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Id
	private String memberAccountNumber;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "master_txn_no")
	private String masterTxnNo;

	@Column(name = "channel")
	private String channel;

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberAccountNumber() {
		return memberAccountNumber;
	}

	public void setMemberAccountNumber(String memberAccountNumber) {
		this.memberAccountNumber = memberAccountNumber;
	}

	public String getMasterTxnNo() {
		return masterTxnNo;
	}

	public void setMasterTxnNo(String masterTxnNo) {
		this.masterTxnNo = masterTxnNo;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	
	

	@Override
	public String toString() {
		return "AddMembersDomain [id=" + id + ", memberAccountNumber=" + memberAccountNumber + ", accountName="
				+ accountName + ", masterTxnNo=" + masterTxnNo + ", channel=" + channel + "]";
	}

}

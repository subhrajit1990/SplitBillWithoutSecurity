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
@Table(name = "SPLIT_GROUP")
public class CreateGroupDomain extends CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "group_id",updatable=false)
	private Long id;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_type")
	private String groupType;
	
	@Column(name="members")
	private String members;
	
	@Column(name="creator_acct_number")
	private String creatorAccountNumber;
	
	@Column(name="master_txn_no")
	private String masterTxnNo;

	@Column(name="channel")
	private String channel;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public String getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members = members;
	}

	public String getCreatorAccountNumber() {
		return creatorAccountNumber;
	}

	public void setCreatorAccountNumber(String creatorAccountNumber) {
		this.creatorAccountNumber = creatorAccountNumber;
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

	@Override
	public String toString() {
		return "CreateGroupDomain [id=" + id + ", groupName=" + groupName + ", groupType=" + groupType + ", members="
				+ members + ", creatorAccountNumber=" + creatorAccountNumber + ", masterTxnNo=" + masterTxnNo
				+ ", channel=" + channel + "]";
	}



}

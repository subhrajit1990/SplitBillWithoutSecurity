/**
 * 
 */
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
@Table(name = "SPLIT_BILL")
@IdClass(BillsIdDomain.class)
public class AddBillDomain extends CommonEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Id
	private String billId;

	@Column(name = "master_txn_no")
	private String masterTxnNo;

	@Column(name = "channel")
	private String channel;

	@Column(name = "bill")
	private String bill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
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

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "AddBillDomain [id=" + id + ", billId=" + billId + ", masterTxnNo=" + masterTxnNo + ", channel="
				+ channel + ", bill=" + bill + "]";
	}

	
}

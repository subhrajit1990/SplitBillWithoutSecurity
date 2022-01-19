/**
 * 
 */
package bill.manager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Troublem@ker
 */
public class BillsIdDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "group_id",updatable=false)
	private Long id;

	@Id
	@Column(name="bill_id",updatable=false)
	private String billId;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BillsIdDomain other = (BillsIdDomain) obj;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}

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


public class MembersIdDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "group_id",updatable=false)
	private Long id;

	@Id
	@Column(name="member_acct_number")
	private String memberAccountNumber;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((memberAccountNumber == null) ? 0 : memberAccountNumber.hashCode());
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
		MembersIdDomain other = (MembersIdDomain) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (memberAccountNumber == null) {
			if (other.memberAccountNumber != null)
				return false;
		} else if (!memberAccountNumber.equals(other.memberAccountNumber))
			return false;
		return true;
	}
	
	

}

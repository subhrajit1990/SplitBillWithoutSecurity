/**
 * 
 */
package bill.manager.domain;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Troublem@ker
 */

@MappedSuperclass // A mapped superclass dont have table defination
public class CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CreationTimestamp
	@Column(name="created_dt",updatable=false, nullable=false)
	private Timestamp createdDt;
	
	@UpdateTimestamp
	@Column(name="updated_dt", nullable=false)
	private Timestamp updatedDt;


	public Timestamp getCreatedDt() {
		return createdDt;
	}


	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}


	public Timestamp getUpdatedDt() {
		return updatedDt;
	}


	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}


	
	
}

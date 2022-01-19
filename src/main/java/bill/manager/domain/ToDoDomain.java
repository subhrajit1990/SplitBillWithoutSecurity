/**
 * 
 */
package bill.manager.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Troublem@ker
 */
@Entity
@Table(name = "TO_DO")
public class ToDoDomain extends CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id")
	private long id;

	@Column(name = "master_txn_no")
	private String masterTxnNo;

	@Column(name = "channel")
	private String channel;

	@OneToMany(mappedBy = "toDoDomain", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ToDoListDomain> toDoList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<ToDoListDomain> getToDoList() {
		return toDoList;
	}

	public void setToDoList(Set<ToDoListDomain> toDoList) {
		this.toDoList = toDoList;
	}

}
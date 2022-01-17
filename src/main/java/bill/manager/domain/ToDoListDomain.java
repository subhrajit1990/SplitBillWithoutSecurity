/**
 * 
 */
package bill.manager.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Troublem@ker
 */
@Entity
@Table(name = "TO_DO_LIST")
public class ToDoListDomain extends CommonEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "to_do_list_id")
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "todo_id", nullable = false)
	private ToDoDomain toDoDomain;

	@Column(name = "to_do_list_text")
	private String toDoText;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ToDoDomain getToDoDomain() {
		return toDoDomain;
	}

	public void setToDoDomain(ToDoDomain toDoDomain) {
		this.toDoDomain = toDoDomain;
	}

	public String getToDoText() {
		return toDoText;
	}

	public void setToDoText(String toDoText) {
		this.toDoText = toDoText;
	}

	
}

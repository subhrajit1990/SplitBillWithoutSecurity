/**
 * 
 */
package bill.manager.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bill.manager.domain.ToDoListDomain;

/**
 * @author Troublem@ker
 */
@Repository
public interface ToDoList extends CrudRepository<ToDoListDomain,String> {

	/**
	 * @param toDoId
	 * @param toDoListId
	 */
	@Modifying
	@Query(value="DELETE FROM to_do_list where todo_id=:todo_id and to_do_list_id = :to_do_list_id", nativeQuery = true)
	void deleteByIdAnd(@Param("todo_id") long todo_id, @Param("to_do_list_id") long to_do_list_id);

}

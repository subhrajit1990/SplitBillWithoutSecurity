/**
 * 
 */
package bill.manager.service;

import org.springframework.stereotype.Component;

import bill.manager.model.ToDoAddRequest;
import bill.manager.model.ToDoDeleteRequest;
import bill.manager.model.ToDoFetchRequest;
import bill.manager.model.ToDoFetchResponse;
import bill.manager.model.ToDoResponse;
import bill.manager.model.ToDoUpdateRequest;

/**
 * @author Troublem@ker
 */
@Component
public interface IToDoService {
	
	public ToDoResponse toDoAdd(ToDoAddRequest toDoAddRequest, String channel, String masterTxnRefNo);
	
	public ToDoResponse toDoDelete(ToDoDeleteRequest toDoRequest, String channel, String masterTxnRefNo);

	public ToDoFetchResponse toDoFetch(ToDoFetchRequest toDoRequest, String channel, String masterTxnRefNo);

	/**
	 * @param toDoRequest
	 * @param channel
	 * @param masterTxnRefNo
	 * @return
	 */
	ToDoResponse toDoListDelete(ToDoDeleteRequest toDoRequest, String channel, String masterTxnRefNo);

	/**
	 * @param toDoUpdateRequest
	 * @param channel
	 * @param masterTxnRefNo
	 * @return
	 */
	ToDoResponse toDoListUpdate(ToDoUpdateRequest toDoUpdateRequest, String channel, String masterTxnRefNo);

}

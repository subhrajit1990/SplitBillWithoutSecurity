/**
 * 
 */
package bill.manager.service;

import org.springframework.stereotype.Component;

import bill.manager.model.Expense;
import bill.manager.model.FetchGroupsRequest;
import bill.manager.model.FetchGroupsResponse;
import bill.manager.model.AddExpensesListResponse;
import bill.manager.model.AddMembersRequest;
import bill.manager.model.AddMembersResponse;
import bill.manager.model.CreateGroupRequest;
import bill.manager.model.CreateGroupResponse;
import bill.manager.model.DeleteExpensesResponse;
import bill.manager.utils.AddBillException;
import bill.manager.utils.GroupFailedException;

/**
 * @author Troublem@ker
 */

@Component
public interface IBillManagerService {

	public CreateGroupResponse createGroup(CreateGroupRequest addGroupRequest, String channel, String masterTxnRefNo)
			throws GroupFailedException;

	public AddExpensesListResponse addExpenses(Expense addExpensesRequest, String channel, String masterTxnNo)
			throws AddBillException;

	/**
	 * @param addMembersRequest
	 * @return
	 */
	public AddMembersResponse addmembers(AddMembersRequest addMembersRequest, String channel, String masterTxnRefNo);
	
	public DeleteExpensesResponse deleteExpenses(int id);
	
	public FetchGroupsResponse fetchGroups(FetchGroupsRequest fetchGroupsRequest, String channel, String masterTxnRefNo);
}

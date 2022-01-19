/**
 * 
 */
package bill.manager.repo;

import java.util.LinkedList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bill.manager.domain.AddBillDomain;

/**
 * @author Troublem@ker
 */
@Repository
public interface CreateBill extends CrudRepository<AddBillDomain, String> {

	/**
	 * @param parseLong
	 * @return
	 */
	LinkedList<AddBillDomain> findById(long parseLong);

	/**
	 * @param id
	 */
	void deleteById(long id);

	/**
	 * @param groupId
	 * @param billId
	 * @return
	 */
	LinkedList<AddBillDomain> findByIdAndBillId(long groupId, String billId);

}

package bill.manager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bill.manager.domain.AddMembersDomain;


/**
 * @author Troublem@ker
 */

@Repository
public interface AddMembers extends CrudRepository<AddMembersDomain,String> {

	/**
	 * @param addMembersDomain
	 */


}
 
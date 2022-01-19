package bill.manager.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bill.manager.domain.ContactMeDomain;

/**
 * @author Troublem@ker
 */

@Repository
public interface ContactMe extends CrudRepository<ContactMeDomain,String> {

	/**
	 * @param addMembersDomain
	 */


}
 
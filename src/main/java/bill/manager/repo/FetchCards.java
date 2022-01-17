/**
 * 
 */
package bill.manager.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bill.manager.domain.GetCardsDomain;



/**
 * @author Troublem@ker
 */
@Repository
public interface FetchCards extends CrudRepository<GetCardsDomain,String> {

	/**
	 * @param channel
	 * @return
	 */
	ArrayList<GetCardsDomain> findAllByChannel(String channel);

}

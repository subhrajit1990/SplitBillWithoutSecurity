/**
 * 
 */
package bill.manager.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bill.manager.domain.ToDoDomain;

/**
 * @author Troublem@ker
 */
@Repository
public interface ToDo extends CrudRepository<ToDoDomain, String> {

	/**
	 * @param parseLong
	 * @param appId
	 * @return
	 */
	ToDoDomain findByIdAndChannel(long parseLong, String appId);

	/**
	 * @param parseLong
	 */
	void deleteById(long parseLong);

}

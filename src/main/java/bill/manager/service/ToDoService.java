/**
 * 
 */
package bill.manager.service;

import java.util.ArrayList;
import java.util.Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bill.manager.domain.ToDoDomain;
import bill.manager.domain.ToDoListDomain;

import bill.manager.model.ListData;
import bill.manager.model.ToDoAddRequest;
import bill.manager.model.ToDoDeleteRequest;
import bill.manager.model.ToDoFetchRequest;
import bill.manager.model.ToDoFetchResponse;
import bill.manager.model.ToDoListText;
import bill.manager.model.ToDoResponse;
import bill.manager.model.ToDoUpdateRequest;
import bill.manager.repo.ToDo;
import bill.manager.repo.ToDoList;
import bill.manager.utils.CommonUtils;
import bill.manager.utils.commonConstants;

/**
 * @author Troublem@ker
 */

// https://www.baeldung.com/hibernate-one-to-many

@Service
public class ToDoService implements IToDoService {

	private static final Logger logger = LogManager.getLogger(ToDoService.class);

	@Autowired
	private ToDo todo;

	@Autowired
	private ToDoList todoList;

	/*
	 * (non-Javadoc)
	 * 
	 * @see bill.manager.service.IToDoService#toDoAdd(bill.manager.model.
	 * ToDoAddRequest, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public ToDoResponse toDoAdd(ToDoAddRequest toDoAddRequest, String channel, String masterTxnRefNo) {

		ToDoDomain toDoDomain = new ToDoDomain();
		ToDoResponse toDoResponse = new ToDoResponse();
		Set<ToDoListDomain> toDoListDomain = new HashSet<>();
		try {
			toDoDomain.setChannel(channel);
			toDoDomain.setCreatedDt(CommonUtils.currentTime());
			toDoDomain.setMasterTxnNo(masterTxnRefNo);

			for (ToDoListText toDoListEntries : toDoAddRequest.getToDoList()) {
				ToDoListDomain toDoListValues = new ToDoListDomain();
				toDoListValues.setCreatedDt(CommonUtils.currentTime());
				toDoListValues.setToDoText(toDoListEntries.getToDotext());
				toDoListValues.setToDoDomain(toDoDomain);
				toDoListDomain.add(toDoListValues);
			}

			toDoDomain.setToDoList(toDoListDomain);
			todo.save(toDoDomain);
			String insertedId = Long.toString(toDoDomain.getId());
			logger.info("inserted id ::: " + insertedId);

			if (insertedId == null || insertedId.isEmpty()) {
				toDoResponse.setGroupStatus(commonConstants.FAILURE);
			} else {
				toDoResponse.setGroupStatus(commonConstants.SUCCESS);
			}

		} catch (Exception e) {
			logger.error(" error occurred :: " + e.toString());
			toDoResponse.setGroupStatus(commonConstants.FAILURE);
		}

		return toDoResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bill.manager.service.IToDoService#toDoDelete(bill.manager.model.
	 * ToDoDeleteRequest, java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional
	public ToDoResponse toDoListDelete(ToDoDeleteRequest toDoRequest, String channel, String masterTxnRefNo) {
		ToDoResponse toDoResponse = new ToDoResponse();
		try {
			todoList.deleteByIdAnd(Long.parseLong(toDoRequest.getToDoId()),
					Long.parseLong(toDoRequest.getToDoListId()));
			toDoResponse.setGroupStatus(commonConstants.SUCCESS);
		} catch (Exception e) {
			logger.error(" error occurred :: " + e.toString());
			toDoResponse.setGroupStatus(commonConstants.FAILURE);
		}
		return toDoResponse;
	}

	@Override
	@Transactional
	public ToDoResponse toDoDelete(ToDoDeleteRequest toDoRequest, String channel, String masterTxnRefNo) {
		ToDoResponse toDoResponse = new ToDoResponse();
		try {
			todo.deleteById(Long.parseLong(toDoRequest.getToDoId()));
			toDoResponse.setGroupStatus(commonConstants.SUCCESS);
		} catch (Exception e) {
			logger.error(" error occurred :: " + e.toString());
			toDoResponse.setGroupStatus(commonConstants.FAILURE);
		}
		return toDoResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see bill.manager.service.IToDoService#toDoFetch(bill.manager.model.
	 * ToDoFetchRequest, java.lang.String, java.lang.String)
	 */
	@Override
	public ToDoFetchResponse toDoFetch(ToDoFetchRequest toDoRequest, String channel, String masterTxnRefNo) {
		ToDoFetchResponse toDoFetchResponse = new ToDoFetchResponse();
		ToDoDomain toDoDomain = null;
		Set<ToDoListDomain> toDoListDomain = null;
		try {
			toDoDomain = todo.findByIdAndChannel(Long.parseLong(toDoRequest.getToDoId()), toDoRequest.getAppId());

			toDoFetchResponse.setChannel(toDoDomain.getChannel());
			toDoFetchResponse.setCreatedDt(toDoDomain.getCreatedDt().toString());
			toDoFetchResponse.setId(toDoDomain.getId());
			toDoListDomain = toDoDomain.getToDoList();
			logger.info("size :: " + toDoListDomain.size());

			List<ListData> tempListData = Collections.synchronizedList(new ArrayList<>());
			Iterator<ToDoListDomain> itr = toDoListDomain.iterator();
			
			while (itr.hasNext()) {
				ToDoListDomain tempListToDo = itr.next();
				ListData tempLD = new ListData();
				tempLD.setText(tempListToDo.getToDoText());
				tempLD.setId(tempListToDo.getId());
				tempLD.setCreatedDate(tempListToDo.getCreatedDt().toString());
				tempLD.setUpdateDate(tempListToDo.getUpdatedDt().toString());
				tempListData.add(tempLD);
			}
			
			toDoFetchResponse.setListData(tempListData);

		} catch (Exception e) {
			logger.error(" error occurred :: " + e.toString());
		}
		logger.info(toDoFetchResponse.toString());
		return toDoFetchResponse;
	}

	@Override
	@Transactional
	public ToDoResponse toDoListUpdate(ToDoUpdateRequest toDoUpdateRequest, String channel, String masterTxnRefNo) {
		ToDoResponse toDoResponse = new ToDoResponse();
		try {

			ToDoListDomain toDoListValues = new ToDoListDomain();
			toDoListValues.setUpdatedDt(CommonUtils.currentTime());
			toDoListValues.setToDoText(toDoUpdateRequest.getText());
			toDoListValues.setId(Long.parseLong(toDoUpdateRequest.getToDoListId()));
			todoList.save(toDoListValues);

			toDoResponse.setGroupStatus(commonConstants.SUCCESS);

		} catch (Exception e) {
			logger.error(" error occurred :: " + e.toString());
			toDoResponse.setGroupStatus(commonConstants.FAILURE);
		}
		return toDoResponse;
	}

}

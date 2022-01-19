/**
 * 
 */
package bill.manager.controller;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bill.manager.model.ResponseHeader;
import bill.manager.model.ToDoAddRequestWrapper;
import bill.manager.model.ToDoDeleteRequestWrapper;
import bill.manager.model.ToDoFetchRequestWrapper;
import bill.manager.model.ToDoFetchResponse;
import bill.manager.model.ToDoFetchResponseWrapper;
import bill.manager.model.ToDoResponse;
import bill.manager.model.ToDoResponseWrapper;
import bill.manager.model.ToDoUpdateRequestWrapper;
import bill.manager.service.ToDoService;
import bill.manager.utils.CommonUtils;
import bill.manager.utils.commonConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Troublem@ker
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/todo/api/")
@Api(tags = "To Do list", value = "/todo/api/")
public class ToDoController {

	private static final Logger logger = LogManager.getLogger(ToDoController.class);

	@Autowired
	private ToDoService toDoService;

	
	@ApiResponses({ @ApiResponse(code = 200, message = "To Do API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "To Do Add API is not reachable") })
	@ApiOperation(value = "To Do Add", notes = "To Do Add")
	@PostMapping(value = "/addList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoResponseWrapper> toDoAdd(@RequestBody ToDoAddRequestWrapper toDoAddRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the add list request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ToDoResponseWrapper toDoAddResponseWrapper = new ToDoResponseWrapper();
		ToDoResponse toDoAddResponse = new ToDoResponse();
		try {
			toDoAddResponse = toDoService.toDoAdd(toDoAddRequestWrapper.getToDoAddRequest(), channel, masterTxnRefNo);
			if (toDoAddResponse.getGroupStatus().equalsIgnoreCase(commonConstants.SUCCESS)) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during add list execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		toDoAddResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the add list request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(toDoAddResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "To Do List Delete API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "To Do List Delete API is not reachable") })
	@ApiOperation(value = "To Do List Delete", notes = "To Do List Delete")
	@PostMapping(value = "/toDoListDelete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoResponseWrapper> toDoListDelete(
			@RequestBody ToDoDeleteRequestWrapper toDoListDeleteRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the delete list request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ToDoResponseWrapper toDoListDeleteResponseWrapper = new ToDoResponseWrapper();
		ToDoResponse toDoListDeleteResponse = new ToDoResponse();
		try {
			toDoListDeleteResponse = toDoService.toDoListDelete(toDoListDeleteRequestWrapper.getToDoDeleteRequest(),
					channel, masterTxnRefNo);
			if (toDoListDeleteResponse.getGroupStatus().equalsIgnoreCase(commonConstants.SUCCESS)) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during  delete list service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		toDoListDeleteResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the  delete list request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(toDoListDeleteResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "To Do  Delete API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "To Do  Delete API is not reachable") })
	@ApiOperation(value = "To Do Delete", notes = "To Do  Delete")
	@PostMapping(value = "/toDoDelete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoResponseWrapper> toDoDelete(
			@RequestBody ToDoDeleteRequestWrapper toDoDeleteRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the delete list request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ToDoResponseWrapper toDoDeleteResponseWrapper = new ToDoResponseWrapper();
		ToDoResponse toDoDeleteResponse = new ToDoResponse();
		try {
			toDoDeleteResponse = toDoService.toDoListDelete(toDoDeleteRequestWrapper.getToDoDeleteRequest(), channel,
					masterTxnRefNo);
			if (toDoDeleteResponse.getGroupStatus().equalsIgnoreCase(commonConstants.SUCCESS)) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during  delete list service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		toDoDeleteResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the  delete list request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(toDoDeleteResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "To Do Fetch API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "To Do Fetch API is not reachable") })
	@ApiOperation(value = "To Do Fetch", notes = "To Do Fetch")
	@PostMapping(value = "/toDoFetch", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoFetchResponseWrapper> toDoFetch(
			@RequestBody ToDoFetchRequestWrapper toDoFetchRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the fetch list request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ToDoFetchResponseWrapper toDoFetchResponseWrapper = new ToDoFetchResponseWrapper();
		ToDoFetchResponse toDoFetchResponse = new ToDoFetchResponse();
		try {
			toDoFetchResponse = toDoService.toDoFetch(toDoFetchRequestWrapper.getToDoFetchRequest(), channel,
					masterTxnRefNo);
			logger.info(" final response :: " + toDoFetchResponse.getChannel() + " :: " + toDoFetchResponse.toString());
			if (!Objects.isNull(toDoFetchResponse.getId())) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
				toDoFetchResponseWrapper.setToDoFetchResponse(toDoFetchResponse);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);

			}
		} catch (Exception e) {
			logger.error("exception happened during fetch list service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		toDoFetchResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the  fetch list request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(toDoFetchResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "To Do Update API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "To Do Update API is not reachable") })
	@ApiOperation(value = "To Do Update", notes = "To Do Update")
	@PostMapping(value = "/toDoUpdate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ToDoResponseWrapper> toDoUpdate(
			@RequestBody ToDoUpdateRequestWrapper toDoUpdateRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the update list request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		ToDoResponseWrapper toDoUpdateResponseWrapper = new ToDoResponseWrapper();
		ToDoResponse toDoUpdateResponse = new ToDoResponse();
		try {
			toDoUpdateResponse = toDoService.toDoListUpdate(toDoUpdateRequestWrapper.getToDoUpdateRequest(), channel,
					masterTxnRefNo);
			if (toDoUpdateResponse.getGroupStatus().equalsIgnoreCase(commonConstants.SUCCESS)) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during update list service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		toDoUpdateResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the update list request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(toDoUpdateResponseWrapper, httpStatus);

	}

}

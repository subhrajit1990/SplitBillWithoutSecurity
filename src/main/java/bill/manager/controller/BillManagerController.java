/**
 * 
 */
package bill.manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bill.manager.model.AddExpensesListResponse;
import bill.manager.model.AddExpensesRequestWrapper;
import bill.manager.model.AddExpensesResponseWrapper;
import bill.manager.model.AddMembersRequestWrapper;
import bill.manager.model.AddMembersResponse;
import bill.manager.model.AddMembersResponseWrapper;
import bill.manager.model.CreateGroupRequestWrapper;
import bill.manager.model.CreateGroupResponse;
import bill.manager.model.CreateGroupResponseWrapper;
import bill.manager.model.DeleteExpensesRequestWrapper;
import bill.manager.model.DeleteExpensesResponse;
import bill.manager.model.DeleteExpensesResponseWrapper;
import bill.manager.model.FetchCardsRequestWrapper;
import bill.manager.model.FetchExpensesRequestWrapper;
import bill.manager.model.FetchGroupsRequestWrapper;
import bill.manager.model.FetchGroupsResponse;
import bill.manager.model.FetchGroupsResponseWrapper;
import bill.manager.model.GameCardsListResponse;
import bill.manager.model.GameCardsResponseWrapper;
import bill.manager.model.ResponseHeader;
import bill.manager.model.Status;
import bill.manager.service.BillManagerService;
import bill.manager.service.MiscellaneousService;
import bill.manager.utils.AddBillException;
import bill.manager.utils.CommonUtils;
import bill.manager.utils.commonConstants;
import bill.manager.utils.GroupFailedException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Troublem@ker
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/expenses/api/")
@Api(tags = "Bill Management", value = "/expenses/api/")
public class BillManagerController {

	private static final Logger logger = LogManager.getLogger(BillManagerController.class);

	@Autowired
	private BillManagerService billManagerService;

	@Autowired
	private MiscellaneousService miscellaneousService;

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Biller API reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Biller API not reachable") })
	@ApiOperation(value = "Status", notes = "Heloow")
	@GetMapping(value = "/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Status> serviceStatus() throws JSONException {
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		Status status = new Status();
		status.setStatusValue("Welcome");
		return new ResponseEntity<>(status, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Create Group API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Create Group API is not reachable") })
	@ApiOperation(value = "Group Creation", notes = "Create Group")
	@PostMapping(value = "/createGroup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CreateGroupResponseWrapper> groupCreation(
			@RequestBody CreateGroupRequestWrapper createGroupRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel)
			throws GroupFailedException {
		logger.info("Started the execution for the create group request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		CreateGroupResponseWrapper createGroupResponseWrapper = new CreateGroupResponseWrapper();
		CreateGroupResponse createGroupResponse = new CreateGroupResponse();
		try {
			createGroupResponse = billManagerService.createGroup(createGroupRequestWrapper.getCreateGroupRequest(),
					channel, masterTxnRefNo);
			if (createGroupResponse.getGroupStatus().equalsIgnoreCase(commonConstants.SUCCESS)) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during create group service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		createGroupResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the create group request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(createGroupResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Group API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Fetch Group API is not reachable") })
	@ApiOperation(value = "Fetch Creation", notes = "Fetch Group")
	@PostMapping(value = "/fetchGroups", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FetchGroupsResponseWrapper> fetchGroups(
			@RequestBody FetchGroupsRequestWrapper fetchGroupsRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the fetch group request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		FetchGroupsResponseWrapper fetchGroupsResponseWrapper = new FetchGroupsResponseWrapper();
		FetchGroupsResponse fetchGroupsResponse = new FetchGroupsResponse();
		try {
			fetchGroupsResponse = billManagerService.fetchGroups(fetchGroupsRequestWrapper.getFetchGroupsRequest(),
					channel, masterTxnRefNo);
			if (fetchGroupsResponse.getStatusCode().equalsIgnoreCase(commonConstants.SUCCESS)) {
				fetchGroupsResponseWrapper.setFetchGroupResponse(fetchGroupsResponse);
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else if (fetchGroupsResponse.getStatusCode().equalsIgnoreCase(commonConstants.NORECORD)) {
				CommonUtils.generateHeaderForNoResult(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during fetch group service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		fetchGroupsResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the fetch group request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(fetchGroupsResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Add Expenses API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Add Expenses API is not reachable") })
	@ApiOperation(value = "Add Expenses", notes = "Add Expenses")
	@PostMapping(value = "/addExpenses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddExpensesResponseWrapper> addExpenses(
			@RequestBody AddExpensesRequestWrapper addExpensesRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel)
			throws AddBillException {
		logger.info("Started the execution for the add expenses request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		AddExpensesResponseWrapper addExpensesResponseWrapper = new AddExpensesResponseWrapper();
		try {
			AddExpensesListResponse addExpensesListResponse = billManagerService
					.addExpenses(addExpensesRequestWrapper.getAddExpensesRequest(), channel, masterTxnRefNo);
			logger.info("addExpensesResponse :: " + addExpensesListResponse.toString());
			if (!addExpensesListResponse.getAddExpenseListResponse().isEmpty()) {
				addExpensesResponseWrapper.setAddExpensesListResponse(addExpensesListResponse);
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForNoResult(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during add expenses service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		addExpensesResponseWrapper.setResponseHeader(responseHeader);

		logger.info("Finished the execution for the add expenses request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(addExpensesResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Fetch Expenses API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Add Expenses API is not reachable") })
	@ApiOperation(value = "Fetch Expenses", notes = "Fetch Expenses")
	@PostMapping(value = "/fetchExpenses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddExpensesResponseWrapper> fetchExpenses(
			@RequestBody FetchExpensesRequestWrapper fetchExpensesRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the fetch expenses request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		AddExpensesResponseWrapper fetchExpensesResponseWrapper = new AddExpensesResponseWrapper();
		try {
			AddExpensesListResponse fetchExpensesListResponse = billManagerService.fetchExpenses(
					fetchExpensesRequestWrapper.getFetchExpensesRequest().getId(),
					fetchExpensesRequestWrapper.getFetchExpensesRequest().getBillId());
			logger.info("addExpensesResponse :: " + fetchExpensesListResponse.toString());
			if (!fetchExpensesListResponse.getAddExpenseListResponse().isEmpty()) {
				fetchExpensesResponseWrapper.setAddExpensesListResponse(fetchExpensesListResponse);
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForNoResult(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during fetch expenses service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		fetchExpensesResponseWrapper.setResponseHeader(responseHeader);

		logger.info("Finished the execution for the fetch expenses request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(fetchExpensesResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete Expenses API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Delete Expenses API is not reachable") })
	@ApiOperation(value = "Delete Expenses", notes = "Delete Expenses")
	@PostMapping(value = "/deleteExpenses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DeleteExpensesResponseWrapper> deleteExpenses(
			@RequestBody DeleteExpensesRequestWrapper deleteExpensesRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the delete expenses request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		DeleteExpensesResponseWrapper deleteExpensesResponseWrapper = new DeleteExpensesResponseWrapper();
		try {
			DeleteExpensesResponse deleteExpensesResponse = billManagerService
					.deleteExpenses(deleteExpensesRequestWrapper.getDeleteExpensesRequest().getId());
			logger.info("deleteExpensesResponse :: " + deleteExpensesResponse.toString());

			if (deleteExpensesResponse.getDeletionCode().equalsIgnoreCase(commonConstants.SUCCESS)) {

				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForNoResult(responseHeader);
			}
			deleteExpensesResponseWrapper.setDeleteExpensesResponse(deleteExpensesResponse);
		} catch (Exception e) {
			logger.error("exception happened during Delete expenses service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		deleteExpensesResponseWrapper.setResponseHeader(responseHeader);

		logger.info("Finished the execution for the delete expenses request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(deleteExpensesResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Add Members API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Add Members API is not reachable") })
	@ApiOperation(value = "Add Members", notes = "Add Members")
	@PostMapping(value = "/addMembers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AddMembersResponseWrapper> addMembers(
			@RequestBody AddMembersRequestWrapper addMembersRequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the add members request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		AddMembersResponseWrapper addMembersResponseWrapper = new AddMembersResponseWrapper();
		AddMembersResponse addMembersResponse = new AddMembersResponse();

		try {
			addMembersResponse = billManagerService.addmembers(addMembersRequestWrapper.getAddMembersRequest(), channel,
					masterTxnRefNo);
			if (addMembersResponse.getMemberStatus().equalsIgnoreCase(commonConstants.SUCCESS)) {
				CommonUtils.generateHeaderForSuccess(responseHeader);
			} else {
				CommonUtils.generateHeaderForGenericError(responseHeader);
			}
		} catch (Exception e) {
			logger.error("exception happened during add member service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		addMembersResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the add members request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(addMembersResponseWrapper, httpStatus);

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "deleteAllData API reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "deleteAllData API not reachable") })
	@ApiOperation(value = "deleteAllData", notes = "Delete All Data")
	@GetMapping(value = "/deleteAllAppData", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletAllAppData() {
		logger.info("Deletion for all data started");
		try {
			billManagerService.deleteAllData();
		} catch (Exception e) {
			logger.error("Exception occurred during Deletion for all data ");
		}
		return "Hellow";

	}

	
	@ApiResponses({ @ApiResponse(code = 200, message = "Get Cards API is reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Get Cards API is not reachable") })
	@ApiOperation(value = "Get Cards", notes = "Get Cards")
	@PostMapping(value = "/getCards", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameCardsResponseWrapper> getCards(

			@RequestBody FetchCardsRequestWrapper fetchCardsrequestWrapper,
			@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel) {
		logger.info("Started the execution for the get cards request with masterTxnRefNo :: " + masterTxnRefNo);
		HttpStatus httpStatus = null;
		httpStatus = HttpStatus.OK;
		ResponseHeader responseHeader = new ResponseHeader();
		GameCardsResponseWrapper gameCardsResponseWrapper = new GameCardsResponseWrapper();
		GameCardsListResponse gameCardsResponse = new GameCardsListResponse();
		try {
			gameCardsResponse = miscellaneousService.fetchCards(channel, masterTxnRefNo);
			if (gameCardsResponse.getGameCardResponse().isEmpty()) {

				CommonUtils.generateHeaderForNoResult(responseHeader);

			} else {
				CommonUtils.generateHeaderForSuccess(responseHeader);
				gameCardsResponseWrapper.setGameCardListResponse(gameCardsResponse);
			}

		} catch (Exception e) {
			logger.error("exception happened during get cards service execution :: " + e.getStackTrace());
			CommonUtils.generateHeaderForGenericError(responseHeader);
		}
		gameCardsResponseWrapper.setResponseHeader(responseHeader);
		logger.info("Finished the execution for the get cards request with masterTxnRefNo :: " + masterTxnRefNo);
		return new ResponseEntity<>(gameCardsResponseWrapper, httpStatus);

	}

}

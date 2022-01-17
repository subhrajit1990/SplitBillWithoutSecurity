/**
 * 
 */
package bill.manager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import bill.manager.model.FileReplacerRequestWrapper;
import bill.manager.model.FileReplacerResponse;
import bill.manager.model.FileReplacerResponseWrapper;
import bill.manager.model.ResponseHeader;
import bill.manager.service.MiscellaneousService;
import bill.manager.utils.CommonUtils;
import bill.manager.utils.FileReplacerException;


/**
 * @author Troublem@ker
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/Misc/api/")
@Api(tags = "Miscellaneous", value = "/Misc/api/")
public class MiscellaneousController {

	private static final Logger logger = LogManager.getLogger(MiscellaneousController.class);

	@Autowired
	private MiscellaneousService miscellaneousService;

	
	@ApiResponses({ @ApiResponse(code = 200, message = "deleteAllData API reachable"),
			@ApiResponse(code = 408, message = "Service Timed Out"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "deleteAllData API not reachable") })
	@ApiOperation(value = "deleteAllData", notes = "Delete All Data")
	@GetMapping(value = "/deleteAllAppData", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deletAllAppData() {
		logger.info("Deletion for all data started");
		try {
			miscellaneousService.deleteAllData();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Exception occurred during Deletion for all data ");
		}
		return "Hellow";

	}
	
	
	@ApiResponses({ @ApiResponse(code = 200, message = "Add Expenses API is reachable"),
		@ApiResponse(code = 408, message = "Service Timed Out"),
		@ApiResponse(code = 500, message = "Internal Server Error"),
		@ApiResponse(code = 404, message = "File Replacer API is not reachable") })
@ApiOperation(value = "Replacing context of the files", notes = "Replacing context of the file")
@PostMapping(value = "/fileReplacer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<FileReplacerResponseWrapper> fileReplacer(
		@RequestBody FileReplacerRequestWrapper fileReplaceRequestWrapper,
		@RequestHeader("masterTxnRefNo") String masterTxnRefNo, @RequestHeader("channel") String channel)
		throws FileReplacerException {
	logger.info("Started the execution for the file replacer request with masterTxnRefNo :: " + masterTxnRefNo);
	HttpStatus httpStatus = null;
	httpStatus = HttpStatus.OK;
	ResponseHeader responseHeader = new ResponseHeader();
	FileReplacerResponseWrapper fileReplacerResponseWrapper = new FileReplacerResponseWrapper();
	try {
		FileReplacerResponse fileReplacerResponse = miscellaneousService
				.fileReplace(fileReplaceRequestWrapper.getFileReplacerRequest(), channel, masterTxnRefNo);
		logger.info("fileReplaceResponse :: " + fileReplacerResponse.toString());
		if (fileReplacerResponse.equals(null)) {
			fileReplacerResponseWrapper.setFileReplacerResponse(fileReplacerResponse);;
			CommonUtils.generateHeaderForSuccess(responseHeader);
		} else {
			CommonUtils.generateHeaderForNoResult(responseHeader);
		}
	} catch (Exception e) {
		logger.error("exception happened during add expenses service execution :: " + e.getStackTrace());
		CommonUtils.generateHeaderForGenericError(responseHeader);
	}
	fileReplacerResponseWrapper.setResponseHeader(responseHeader);

	logger.info("Finished the execution for the file replacer request with masterTxnRefNo :: " + masterTxnRefNo);
	return new ResponseEntity<>(fileReplacerResponseWrapper, httpStatus);

}


	

}

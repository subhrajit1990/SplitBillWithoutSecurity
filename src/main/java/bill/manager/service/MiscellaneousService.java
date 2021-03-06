/**
 * 
 */
package bill.manager.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bill.manager.domain.ContactMeDomain;
import bill.manager.domain.GetCardsDomain;
import bill.manager.model.ContactMeRequest;
import bill.manager.model.FileReplacerRequest;
import bill.manager.model.FileReplacerResponse;
import bill.manager.model.GameCardResponse;
import bill.manager.model.GameCardsListResponse;
import bill.manager.repo.AddMembers;
import bill.manager.repo.ContactMe;
import bill.manager.repo.CreateBill;
import bill.manager.repo.CreateGroup;
import bill.manager.repo.FetchCards;
import bill.manager.utils.CommonUtils;
import bill.manager.utils.ContactMeException;

/**
 * @author Troublem@ker
 */

@Service
public class MiscellaneousService implements IMiscellaneousService {

	private static final Logger logger = LogManager.getLogger(MiscellaneousService.class);

	@Autowired
	private CreateGroup addGroup;

	@Autowired
	private AddMembers addMembers;

	@Autowired
	private CreateBill createBill;

	@Autowired
	private FetchCards fetchCards;

	@Autowired
	private ContactMe contactMe;

	/**
	 * 
	 */
	public void deleteAllData() {
		logger.info("Deletion started");
		addGroup.deleteAll();
		addMembers.deleteAll();
		createBill.deleteAll();
		logger.info("Deletion ends");
	}

	/**
	 * @param channel
	 * @param masterTxnRefNo
	 * @return
	 */
	public GameCardsListResponse fetchCards(String channel, String masterTxnRefNo) {
		GameCardsListResponse GameCardsResponse = new GameCardsListResponse();
		ArrayList<GetCardsDomain> fetchCardsRes = null;
		try {
			fetchCardsRes = fetchCards.findAllByChannel(channel);
			if (fetchCardsRes.isEmpty()) {

			} else {
				List<GameCardResponse> gameCardsRes = Collections.synchronizedList(new ArrayList<>());
				Iterator<GetCardsDomain> itr = fetchCardsRes.iterator();
				while (itr.hasNext()) {
					GameCardResponse gCardRes = new GameCardResponse();
					GetCardsDomain fc = itr.next();
					gCardRes.setCardIcon(fc.getIconName());
					gameCardsRes.add(gCardRes);
				}

				GameCardsResponse.setGameCardResponse(gameCardsRes);
			}
		} catch (Exception e) {
			logger.error("Error occurred :: " + e.toString());
		}
		return GameCardsResponse;
	}

	/**
	 * @param fileReplacerRequest
	 * @param channel
	 * @param masterTxnRefNo
	 * @return
	 */
	public FileReplacerResponse fileReplace(FileReplacerRequest fileReplacerRequest, String channel,
			String masterTxnRefNo) {

		try (FileReader file = new FileReader(fileReplacerRequest.getFirstFile());
				BufferedReader reader = new BufferedReader((file));
				FileWriter fos = new FileWriter(new File("/PATH/"))) {

			String line;
			String replaceCriteria = fileReplacerRequest.getValidator();
			while ((line = reader.readLine()) != null) {
				String[] splitedString = line.split("=");
				StringBuilder tempData = modifyFile(fileReplacerRequest.getSecondFile(), splitedString[0],
						splitedString[1], replaceCriteria);
				if (tempData.length() != 0)
					fos.write(tempData.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Error occurred :: " + e.toString());
		}
		return null;
	}

	static StringBuilder modifyFile(String filePath, String oldString, String newString, String replaceCriteria)
			throws IOException {
		File fileToBeModified = new File(filePath);

		StringBuilder myStringBuffer = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));) {

			String line = reader.readLine();
			String[] replaceStrings = replaceCriteria.split(" ");
			logger.info(" line :: " + line + " older string " + oldString + "  new string ::" + newString);
			while (line != null) {

				Pattern p = Pattern.compile("\\b" + oldString + "\\b");
				Matcher m = p.matcher(line);

				if (m.find()) {

					for (int i = 0; i < replaceStrings.length; i++) {
						line = line.replaceAll(replaceStrings[i], "");
					}

					myStringBuffer
							.append(String.valueOf(line).replaceAll(oldString, newString) + System.lineSeparator());
				}

				line = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
			logger.error("Error occurred :: " + e.toString());

		}
		return myStringBuffer;
	}

	/**
	 * @param contactMeRequest
	 * @param masterTxnRefNo
	 * @param channel
	 * @throws ContactMeException 
	 */
	public void contactMeService(ContactMeRequest contactMeRequest, String masterTxnRefNo, String channel) throws ContactMeException  {

		try {
			ContactMeDomain contactMeDomain = new ContactMeDomain();
			contactMeDomain.setChannel(channel);
			contactMeDomain.setCreatedDt(CommonUtils.currentTime());
			contactMeDomain.setEmail(contactMeRequest.getEmail());
			contactMeDomain.setMasterTxnNo(masterTxnRefNo);
			contactMeDomain.setName(contactMeRequest.getName());
			contactMeDomain.setPhoneNumber(contactMeRequest.getPhoneNumber());
			contactMeDomain.setMessage(contactMeRequest.getMessage());
			contactMe.save(contactMeDomain);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error occurred :: " + e.getStackTrace());
			throw new ContactMeException("CON_ME", "Exception");
		}

	}

}

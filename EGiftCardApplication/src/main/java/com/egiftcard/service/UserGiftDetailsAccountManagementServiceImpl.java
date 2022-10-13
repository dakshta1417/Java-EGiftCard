package com.egiftcard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.UserGiftDetailsNotFoundException;
import com.egiftcard.exception.DuplicateUserGiftIdException;
import com.egiftcard.dao.IUserGiftDetailsAccountManagementServiceRepository;

@Service
public class UserGiftDetailsAccountManagementServiceImpl implements IUserGiftDetailsAccountManagementService {

	@Autowired
	private IUserGiftDetailsAccountManagementServiceRepository userGiftDetailsRepo;

	public UserGiftDetailsAccountManagementServiceImpl(
			IUserGiftDetailsAccountManagementServiceRepository userGiftDetailsRepo) {
		super();
		this.userGiftDetailsRepo = userGiftDetailsRepo;
	}

	@Override
	public List<UserGiftDetails> getAllUserGiftDetails() {
		return userGiftDetailsRepo.findAll();
	}

	@Override
	public UserGiftDetails getUserGiftDetails(int userGiftId) throws UserGiftDetailsNotFoundException {
		return userGiftDetailsRepo.findById(userGiftId)
				.orElseThrow(() -> new UserGiftDetailsNotFoundException("User Gift Card Details not found!"));
	}

	@Override
	public UserGiftDetails addUserGiftDetails(UserGiftDetails userGiftDetails) throws DuplicateUserGiftIdException {
		Optional<UserGiftDetails> userDet = userGiftDetailsRepo.findById(userGiftDetails.getUserGiftId());
		if (userDet.isPresent()) {
			throw new DuplicateUserGiftIdException(
					"User gift details " + userGiftDetails.getUserGiftId() + " already exists!");
		}
		return userGiftDetailsRepo.save(userGiftDetails);
	}

	@Override
	public UserGiftDetails updateUserGiftDetailsById(UserGiftDetails userGiftDetails, int userGiftId)
			throws UserGiftDetailsNotFoundException {
		UserGiftDetails existingUserGiftDet = userGiftDetailsRepo.findById(userGiftId)
				.orElseThrow(() -> new UserGiftDetailsNotFoundException("User Gift Card Details not found!"));
		existingUserGiftDet.setCardIssueDate(userGiftDetails.getCardIssueDate());
		existingUserGiftDet.setCardReloadable(userGiftDetails.isCardReloadable());
		existingUserGiftDet.setDeliveryType(userGiftDetails.getDeliveryType());
		existingUserGiftDet.setGiftCardAmount(userGiftDetails.getGiftCardAmount());
		existingUserGiftDet.setRecepientName(userGiftDetails.getRecepientName());
		existingUserGiftDet.setRecepientEmail(userGiftDetails.getRecepientEmail());
		existingUserGiftDet.setReceipientMobile(userGiftDetails.getReceipientMobile());
		existingUserGiftDet.setScheduleDelivery(userGiftDetails.getScheduleDelivery());
		existingUserGiftDet.setGiftCard(userGiftDetails.getGiftCard());
		existingUserGiftDet.setUser(userGiftDetails.getUser());
		existingUserGiftDet.setPersonalize(userGiftDetails.getPersonalize());
		return userGiftDetailsRepo.save(existingUserGiftDet);
	}

	@Override
	// @Transactional
	public String deleteUserGiftDetailsById(int userGiftId) throws UserGiftDetailsNotFoundException {
		UserGiftDetails userGiftDetails = userGiftDetailsRepo.findById(userGiftId)
				.orElseThrow(() -> new UserGiftDetailsNotFoundException("User Gift Card Details not found!"));
		userGiftDetails.setPersonalize(null);
		userGiftDetails.setUser(null);
		userGiftDetails.setGiftCard(null);
		userGiftDetailsRepo.deleteById(userGiftId);
		return "User Gift Card Details deleted successfully!";
	}

}

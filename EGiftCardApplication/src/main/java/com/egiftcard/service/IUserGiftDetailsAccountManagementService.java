package com.egiftcard.service;

import java.util.List;

import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.DuplicateUserGiftIdException;
import com.egiftcard.exception.UserGiftDetailsNotFoundException;

//UserGiftDetailsAccountManagement Service Interface
public interface IUserGiftDetailsAccountManagementService {
	List<UserGiftDetails> getAllUserGiftDetails();

	UserGiftDetails getUserGiftDetails(int userGiftId) throws UserGiftDetailsNotFoundException;

	UserGiftDetails addUserGiftDetails(UserGiftDetails userGiftDetails) throws DuplicateUserGiftIdException;

	UserGiftDetails updateUserGiftDetailsById(UserGiftDetails userGiftDetails, int userGiftId)
			throws UserGiftDetailsNotFoundException;

	String deleteUserGiftDetailsById(int userGiftId) throws UserGiftDetailsNotFoundException;
}

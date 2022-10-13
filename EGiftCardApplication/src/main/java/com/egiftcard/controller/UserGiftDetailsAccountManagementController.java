package com.egiftcard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egiftcard.entity.UserGiftDetails;
import com.egiftcard.exception.DuplicateUserGiftIdException;
import com.egiftcard.exception.UserGiftDetailsNotFoundException;
import com.egiftcard.service.IUserGiftDetailsAccountManagementService;

@RestController
@RequestMapping("/api/usergiftdetails")
public class UserGiftDetailsAccountManagementController {

	@Autowired
	private IUserGiftDetailsAccountManagementService userGiftDetailsManagementService;

	public UserGiftDetailsAccountManagementController(
			IUserGiftDetailsAccountManagementService userGiftDetailsAcccountManagementService) {
		super();
		this.userGiftDetailsManagementService = userGiftDetailsAcccountManagementService;
	}

	// http://localhost:8080/EGiftCardApp/api/usergiftdetails
	@GetMapping
	public List<UserGiftDetails> getAllUserGiftDetails() {
		return userGiftDetailsManagementService.getAllUserGiftDetails();
	}

	// http://localhost:8080/EGiftCardApp/api/usergiftdetails/
	@GetMapping("{user_gift_id}")
	public ResponseEntity<UserGiftDetails> getUserGiftDetails(@PathVariable("user_gift_id") int userGiftId)
			throws UserGiftDetailsNotFoundException {
		return new ResponseEntity<>(userGiftDetailsManagementService.getUserGiftDetails(userGiftId), HttpStatus.OK);
	}

	// http://localhost:8080/EGiftCardApp/api/usergiftdetails
	@PostMapping
	public ResponseEntity<UserGiftDetails> addUserGiftDetails(@Valid @RequestBody(required = false) UserGiftDetails u)
			throws DuplicateUserGiftIdException {
		return new ResponseEntity<>(userGiftDetailsManagementService.addUserGiftDetails(u), HttpStatus.CREATED);
	}

	// http://localhost:8080/EGiftCardApp/api/usergiftdetails
	@PutMapping("{user_gift_id}")
	public ResponseEntity<UserGiftDetails> updateUserGiftDetailsById(@PathVariable("user_gift_id") int userGiftId,
			@Valid @RequestBody(required = false) UserGiftDetails userGiftDetails)
			throws UserGiftDetailsNotFoundException {
		return new ResponseEntity<>(
				userGiftDetailsManagementService.updateUserGiftDetailsById(userGiftDetails, userGiftId), HttpStatus.OK);
	}

	// http://localhost:8080/EGiftCardApp/api/usergiftdetails/
	@DeleteMapping("{user_gift_id}")
	public String deleteUserGiftDetailsById(@PathVariable("user_gift_id") int userGiftId)
			throws UserGiftDetailsNotFoundException {
		userGiftDetailsManagementService.deleteUserGiftDetailsById(userGiftId);
		return "Deleted Successfully!";
	}

}

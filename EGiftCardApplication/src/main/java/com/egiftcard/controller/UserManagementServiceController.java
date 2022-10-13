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

import com.egiftcard.entity.User;
import com.egiftcard.exception.InvalidUserIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoSuchUserException;
import com.egiftcard.service.IUserManagementService;

@RestController
@RequestMapping("/api/user")
public class UserManagementServiceController {

	@Autowired
	private IUserManagementService userServiceCtrl;
	
	// http://localhost:8080/EGiftCardApp/api/user/Id
	@GetMapping("/Id/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId) throws NoSuchUserException {
		User user = userServiceCtrl.getUserById(userId);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// http://localhost:8080/EGiftCardApp/api/user/firstName
	@GetMapping("/firstName/{firstName}")
	public ResponseEntity<List<User>> searchByFirstName(@PathVariable("firstName") String firstName) {

		return new ResponseEntity<List<User>>(userServiceCtrl.searchByFirstName(firstName), HttpStatus.FOUND);
	}


	// http://localhost:8080/EGiftCardApp/api/user/Email
	@GetMapping("/Email/{email}")
	public ResponseEntity<User> searchByEmail(@PathVariable("email") String email) {
		return new ResponseEntity<User>(userServiceCtrl.getUserByEmail(email), HttpStatus.FOUND);
	}

	// http://localhost:8080/EGiftCardApp/api/user
	@PutMapping(value = "/{userId}")
	public ResponseEntity<User> updateUserById(@Valid @RequestBody User user, @PathVariable("userId") int userId)
			throws NoSuchUserException {
		return new ResponseEntity<User>(userServiceCtrl.updateUserById(user, userId), HttpStatus.OK);
	}

	// http://localhost:8080/EGiftCardApp/api/user/forgetPassword/
	@PutMapping("/forgetPassword/{email}")
	public ResponseEntity<User> changePassword(@Valid @RequestBody User user, @PathVariable("email") String email)
			throws NoSuchUserException {
		return new ResponseEntity<User>(userServiceCtrl.changePassword(user, email), HttpStatus.NOT_FOUND);
	}

	// http://localhost:8080/EGiftCardApp/api/user
	@PostMapping
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws InvalidUserIdException {
		return new ResponseEntity<User>(userServiceCtrl.registerUser(user), HttpStatus.CREATED);
	}

	// http://localhost:8080/EGiftCardApp/api/user
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable("userId") int userId) throws NoDataException {
		if (userId == 0)
			throw new NoDataException("data not available");
		else {
			userServiceCtrl.deleteUserById(userId);
			return new ResponseEntity<String>("Deleted user with id " + userId + " successfully", HttpStatus.OK);
		}

	}
	//http://localhost:8080/EGiftCardApp/api/user/loginUser/
	@GetMapping(value = "/loginUser/{email}/{password}")
	public ResponseEntity<User> loginUser(@PathVariable String email, @PathVariable String password) {

		return new ResponseEntity<User>(userServiceCtrl.login(email, password),HttpStatus.OK);

	}


	@GetMapping(value = "/logoutUser/{email}/{password}")
	public ResponseEntity<User> logoutUser(@PathVariable String email, @PathVariable String password) {

		return new ResponseEntity<User>(userServiceCtrl.logout(email,password),HttpStatus.OK);

	}
}

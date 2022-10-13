package com.egiftcard.service;

import java.util.List;

import com.egiftcard.entity.User;
import com.egiftcard.exception.InvalidUserIdException;
import com.egiftcard.exception.NoDataException;
import com.egiftcard.exception.NoSuchUserException;

//UserManagement Service Interface
public interface IUserManagementService {

	List<User> getAllUsers() throws NoDataException;

	User getUserById(int userId) throws NoSuchUserException;

	User registerUser(User user) throws InvalidUserIdException;

	String deleteUserById(int userId) throws NoDataException;

	User updateUserById(User user, int userId) throws NoSuchUserException;

	User changePassword(User user, String email) throws NoSuchUserException;

	List<User> searchByFirstName(String firstName);

	User getUserByEmail(String email);

	User login(String email, String password);
	User logout(String email, String password);
}

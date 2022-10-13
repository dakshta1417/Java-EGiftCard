package com.egiftcard.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.User;

//Repository Interface for UserManagementService
@Repository
public interface IUserManagementServiceRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public List<User> findByFirstName(String firstName);
	
	User findByEmailAndPassword(String email, String password);

}

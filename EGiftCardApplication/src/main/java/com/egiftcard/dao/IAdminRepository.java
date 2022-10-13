package com.egiftcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egiftcard.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmail(String email);
	public Admin deleteByEmail(String email);
	public Admin findByEmailAndPassword(String email,String password);
}

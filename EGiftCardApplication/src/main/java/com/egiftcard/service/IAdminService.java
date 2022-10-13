package com.egiftcard.service;

import java.util.List;

import com.egiftcard.entity.Admin;

//Admin service Interface
public interface IAdminService {

	Admin getAdminByEmail(String email);
	List<Admin> getAllAdmin();
	Admin registerAdmin(Admin admin);
	Admin updateAdmin(Admin admin,String email);
	Admin deleteAdmin(String email);
	Admin adminChangePassword(Admin admin,String email);
	Admin loginAdmin(String email,String password);
	Admin logoutAdmin(String email, String password);
}

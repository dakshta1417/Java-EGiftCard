package com.egiftcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiftcard.dao.IAdminRepository;
import com.egiftcard.entity.Admin;

@Service
public class AdminServiceImplementation implements IAdminService{

	@Autowired
	private IAdminRepository adminRepo;

	@Override
	public Admin getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepo.findByEmail(email);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepo.findAll();
	}

	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin, String email) {
		// TODO Auto-generated method stub;
		Admin preAdmin=adminRepo.findByEmail(email);
		preAdmin.setAdminFirstName(admin.getAdminFirstName());
		preAdmin.setAdminLastName(admin.getAdminLastName());
		preAdmin.setAge(admin.getAge());
		preAdmin.setContact(admin.getContact());
		preAdmin.setEmail(admin.getEmail());
		return adminRepo.save(preAdmin);
	}

	@Override
	public Admin deleteAdmin(String email) {
		// TODO Auto-generated method stub
		return adminRepo.deleteByEmail(email);
	}

	@Override
	public Admin adminChangePassword(Admin admin, String email) {
		// TODO Auto-generated method stub
		Admin preAdmin=adminRepo.findByEmail(email);
		preAdmin.setPassword(admin.getPassword());
		return adminRepo.save(preAdmin);
	}

	@Override
	public Admin loginAdmin(String email, String password) {
		Admin preAdmin=adminRepo.findByEmailAndPassword(email, password);
		return preAdmin;
	}

	@Override
	public Admin logoutAdmin(String email, String password) {
		Admin preAdmin=adminRepo.findByEmailAndPassword(email, password);
		preAdmin=null;
		return preAdmin;
	}
	
	
}

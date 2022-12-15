package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.model.Admin;
import com.masai.repo.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	
//	@Override
//	public Admin createAdmin(Admin admin) throws AdminException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

	@Override
	public Admin registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		return adminDao.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> admin2 = adminDao.findById(admin.getAdminId()) ;
		if(admin2.isEmpty()) {
			throw new  AdminException("Admin is Not Found") ;
		}
		
		return adminDao.save(admin) ;
	}

	@Override
	public Admin getAdminById(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminDao.findById(adminId) ;
		if(admin.isEmpty()) {
			throw new AdminException("Admin is Not Found with Id "+ adminId);
			
		}
		return admin.get();
		
//		return null;
	}

	@Override
	public Admin deleteAdminById(Integer adminId) throws AdminException {
		// TODO Auto-generated method stub
		Optional<Admin> admin = adminDao.findById(adminId) ;
		if(admin.isEmpty()) {
			throw new AdminException("Admin is Not Found with Id "+ adminId);
			
		}
		adminDao.delete(admin.get());
		
		return admin.get();
	}

}

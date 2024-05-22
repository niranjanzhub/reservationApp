package org.nirz.reservationApp.Dao;

import org.nirz.reservationApp.model.Admin;
import org.nirz.reservationApp.respository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
@Autowired
	private AdminRepository adminRepository;

public Admin saveAdmin(Admin admin) {
	return adminRepository.save(admin);
}
	
	
}

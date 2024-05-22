package org.nirz.reservationApp.Dao;

import java.util.List;
import java.util.Optional;

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

public Optional<Admin> getAdminById(int id) {
	
	return adminRepository.findById(id);
}

public List<Admin> getAdmins() {
	
	return adminRepository.findAll();
}



public void deleteAdminById(int id) {
	
	adminRepository.deleteById(id);	
}
	
	

}

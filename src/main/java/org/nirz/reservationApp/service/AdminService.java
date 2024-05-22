package org.nirz.reservationApp.service;

import java.util.List;
import java.util.Optional;

import org.nirz.reservationApp.Dao.AdminDao;
import org.nirz.reservationApp.Dto.ResponseStructure;
import org.nirz.reservationApp.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AdminService {

	@Autowired
	private	AdminDao adminDao;


	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		structure.setMessage("New Admin Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(adminDao.saveAdmin(admin));
		return ResponseEntity.status(HttpStatus.CREATED).body(structure);
	}


	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> admin =adminDao.getAdminById(id);
		if(admin.isPresent())
		{
			structure.setMessage("Admin Found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(admin.get());
			return ResponseEntity.status(HttpStatus.FOUND).body(structure);
		} else {
			structure.setMessage("Admin Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
		}
	}

	public ResponseEntity<ResponseStructure<List<Admin>>> getAdmins() {	
		ResponseStructure<List<Admin>> structure=new ResponseStructure<>();
		structure.setMessage("List of Admins");
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setData(adminDao.getAdmins());
		return ResponseEntity.status(HttpStatus.FOUND).body(structure);
	}


	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int id) {
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> admin =adminDao.getAdminById(id);
		if(admin.isPresent())
		{
			structure.setMessage("Admin Found and deleted");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(admin.get());
			adminDao.deleteAdminById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body(structure);
		} else {
			structure.setMessage("Admin Not Found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(structure);
		}
	}


	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(String email, String password) {
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> admin =adminDao.verifyAdmin(email,password);
		if(admin.isPresent())
		{
			structure.setMessage("Admin Verified");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(admin.get());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		} else {
			structure.setMessage("Invalid credentials");
			structure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
			structure.setData(null);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(structure);
		}
	}

	
	
	public ResponseEntity<ResponseStructure<Admin>> verifyAdmin(long phone, String password) {
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> admin =adminDao.verifyAdmin(phone,password);
		if(admin.isPresent())
		{
			structure.setMessage("Admin Verified");
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setData(admin.get());
			return ResponseEntity.status(HttpStatus.OK).body(structure);
		} else {
			structure.setMessage("Invalid credentials");
			structure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
			structure.setData(null);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(structure);
		}
	}
	

}
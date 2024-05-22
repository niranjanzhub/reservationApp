package org.nirz.reservationApp.service;

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
	
}

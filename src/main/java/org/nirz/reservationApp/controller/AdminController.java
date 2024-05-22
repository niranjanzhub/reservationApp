package org.nirz.reservationApp.controller;

import java.util.List;

import org.nirz.reservationApp.Dto.ResponseStructure;
import org.nirz.reservationApp.model.Admin;
import org.nirz.reservationApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {
@Autowired
private AdminService adminService	;
	
@PostMapping("/new")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	
}

@GetMapping("/getAdmin/{id}")
public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int id){
	return adminService.getAdminById(id);

}

@GetMapping("/getAdmins")
public ResponseEntity<ResponseStructure<List<Admin>>> getAdmins(){
	return adminService.getAdmins();

}


}

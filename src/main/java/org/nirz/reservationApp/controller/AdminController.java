package org.nirz.reservationApp.controller;

import org.nirz.reservationApp.Dto.ResponseStructure;
import org.nirz.reservationApp.model.Admin;
import org.nirz.reservationApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
private AdminService adminService	;
	
@PostMapping("/new")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	
}
}

package com.cabway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cabway.exceptions.AdminException;
import com.cabway.model.Admin;
import com.cabway.services.AdminService;

@RestController
//@RequestMapping("/adminService")
public class AdminController {

	@Autowired
	private AdminService aService;

	@PostMapping("/admins")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) throws AdminException {

		Admin ad = aService.insertAdmin(admin);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);

	}

	@PutMapping("/admins")
	public ResponseEntity<Admin> updatedAdmin(@RequestBody Admin admin) throws AdminException {

		Admin ad = aService.updateAdminDetails(admin);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("/admins/{aid}")
	public ResponseEntity<Admin> deletedAdmin(@PathVariable("aid") Integer adminId) throws AdminException {

		Admin ad = aService.deleteAdminDetails(adminId);

		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);

	}

}

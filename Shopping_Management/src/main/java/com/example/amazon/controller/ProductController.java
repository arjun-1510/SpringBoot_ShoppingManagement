package com.example.amazon.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.amazon.dto.Admin;
import com.example.amazon.dto.Product;
import com.example.amazon.dto.Sigup;
import com.example.amazon.service.ProductService;
import com.example.amazon.util.ResponseBody;
import com.example.amazon.util.ResponseEntity;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	@PostMapping("/amazon/save")
	public ResponseBody<Product> save(@RequestBody Product p) {
		
		
		
		return service.save(p);
	}
	
	
	@PostMapping("/amazon/sigup")
	public ResponseBody<Sigup> savesigup(@RequestBody Sigup  s) {
		
		
		
		return service.savesign(s);
	}
	
	@GetMapping("/amazon/getbyid")
	public ResponseBody<Product> getbyid(@RequestParam(value="id") int id) {
		
		return service.getbyid(id);
	}
	
	@PutMapping("/amazon/update/{id}")
	public ResponseBody<Product> update(@PathVariable("id") int  id ,@RequestBody Product p) {
		
		return service.update(p, id);
	}
	
	@GetMapping("/amazon/login")
	public ResponseEntity<String>  login(@RequestParam(value = "email") String email ,@RequestParam(value="password")String password)  {
		
		
		
		return service.login(email, password);
	}
	
	
	
	/***************************************** Admin Page */
	
	@PostMapping("/amazon/admin/sigup")
	public ResponseBody<Admin> adminSave(@RequestBody Admin admin) {
		
		return service.SaveAdmin(admin);
	}
	
	
	@GetMapping("/amazon/admin/login")
	public ResponseBody<String > adminLogin(@RequestParam(value = "email") String email,@RequestParam(value = "password") String password) {
		
		
		
		return service.adminLogin(email, password);
	}
	
	@PutMapping("/amazon/admin/logout")
	public String adminLogout() {
		
		
		
		return service.adminLogout();
	}
	
	@PutMapping("/amazon/user/logout")
	public String userLogout() {
		
		
		
		return service.userLogout();
	}
	
	
	@GetMapping("/amazon/user/forgotPassword")
	public String  forgotPasword(@RequestParam(value = "email")   String email,@RequestParam(value = "contact")   long ph) {
		
		
		return service.forgot(email, ph);
	}
	
	@PutMapping("/amazon/user/changePassword")
	public String  changepassword(@RequestParam(value = "otp")   int otp , @RequestParam(value = "email") String email,@RequestParam(value = "password")   String password) {
		
		
		return service.chagepassword(otp,email, password);
		
	}
	
	

}

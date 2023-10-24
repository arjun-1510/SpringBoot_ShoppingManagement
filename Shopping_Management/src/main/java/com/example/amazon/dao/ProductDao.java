package com.example.amazon.dao;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.amazon.dto.Admin;
import com.example.amazon.dto.Product;
import com.example.amazon.dto.Sigup;
import com.example.amazon.repository.AdminRepository;
import com.example.amazon.repository.ProductRepository;
import com.example.amazon.repository.SigupReppsitory;


@Repository
public class ProductDao {
	
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	SigupReppsitory srepo;
	
	@Autowired
	AdminRepository arepo;
	
	
	
	public Product save(Product p) {
		
		
		return repo.save(p);
	}
	
	
	public Product getbyid(int id) {
		
		return repo.findById(id).get();
		
	}
	
	public Product update(Product p) {
		
		return repo.save(p);
	}
	
	public Sigup savesigup(Sigup s) {
		return srepo.save(s);
	}
	
	public Sigup login(String email) {
		
		  Sigup s =     srepo.findByEmail(email);
		  
		  return s;
	}
	
	public Admin adminSave(Admin a ) {
		
		return arepo.save(a);
	}
	
	public Admin adminLogin(String email) {
		
		return arepo.findByEmail(email);
	}
	
	public Sigup forgot(String email) {
		
		  Sigup s =     srepo.findByEmail(email);
		  
		  return s;
	}
	
	public Sigup forgotchange(String password) {
		
  Sigup s =     srepo.findByPassword(password);
		  
		  return s;
		
	}
	
	public Sigup chageemail(String email) {
		
		return srepo.findByEmail(email);
	}
	
	public void chagePasswordAndEmail(Sigup s) {
		
		srepo.save(s);
	}

}

package com.example.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.amazon.dto.Admin;

public interface AdminRepository  extends JpaRepository<Admin, Integer>{
	
	
	public Admin findByEmail(String email);

}

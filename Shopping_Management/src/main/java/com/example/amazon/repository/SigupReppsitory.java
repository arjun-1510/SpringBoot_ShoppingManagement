package com.example.amazon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.amazon.dto.Sigup;

public interface SigupReppsitory extends JpaRepository<Sigup, Long> {
	
	
	public Sigup  findByEmail(String email);
	
	public Sigup findByPassword(String password);

}

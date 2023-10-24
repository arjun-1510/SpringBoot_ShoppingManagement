package com.example.amazon.util;

import java.util.Date;


import org.springframework.stereotype.Component;

import com.example.amazon.dto.Sigup;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	
	private static final String secret = "this is screate" ;
	
	
	
	public  String generateJwt( ) {
		
		Sigup s = new Sigup();
		
		String l =String.valueOf(s.getId()) ;
		
		Date date = new Date();
		
		Claims claims = Jwts.claims().setIssuedAt(date);
		
		
		Jwts.builder().setClaims(claims).compact();
		
		return Jwts.builder().setClaims(claims).compact();
		
	}
	
	

}

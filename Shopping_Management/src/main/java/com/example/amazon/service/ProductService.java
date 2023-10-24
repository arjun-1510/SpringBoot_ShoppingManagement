package com.example.amazon.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.amazon.dao.ProductDao;
import com.example.amazon.dto.Admin;
import com.example.amazon.dto.Product;
import com.example.amazon.dto.Sigup;
import com.example.amazon.util.JwtUtils;
import com.example.amazon.util.ResponseBody;
import com.example.amazon.util.ResponseEntity;

@Service
public class ProductService {
	
	static boolean verification = false;
	static boolean adminVerification = false;
	int otp;
	
	
	@Autowired
	ProductDao dao;
	
	@Autowired
	 JwtUtils ken;
	
	
	
	
	public ResponseBody<Product> save (Product p) {
		
		
		if(adminVerification==true) {
		
		
		ResponseBody<Product> r = new ResponseBody<Product>();
		r.setStatus(HttpStatus.CREATED.value());
		r.setData(dao.save(p));
		r.setMsg("Data Saved Sucessfully");
		
		
		return r;
		
		} 
			ResponseBody<Product> re = new ResponseBody<Product>();
			re.setStatus(HttpStatus.BAD_REQUEST.value());
			
			re.setMsg("Admin Only Insert Product or Plaese Login Admin");
			
		
		return re ;
		
		
	}
	
	
public ResponseBody<Sigup> savesign (Sigup s) {
		
		
		ResponseBody<Sigup> r = new ResponseBody<Sigup>();
		r.setStatus(HttpStatus.CREATED.value());
		r.setData(dao.savesigup(s));
		r.setMsg("Sign up Sucessfully");
		
		
		return r;
		
	}
	
	public ResponseBody<Product> getbyid(int id) {
		
		if(verification ==true) {
		
		ResponseBody<Product> r = new ResponseBody<Product>();
		r.setStatus(HttpStatus.OK.value());
		r.setData(dao.getbyid(id));
		r.setMsg("Data Founded Sucessfully");
		
		return r;
		
		}else {
			ResponseBody<Product> r = new ResponseBody<Product>();
			r.setStatus(HttpStatus.LOCKED.value());
			//r.setData(dao.getbyid(id));
			r.setMsg("Login First");
			
			return r;
			
		}
	}
	
	public ResponseBody<Product> update(Product p ,int id) {
		
		
		if(adminVerification==true) {
		
		ResponseBody<Product> r = new ResponseBody<Product>();
		p.setId(id);
		
		r.setStatus(HttpStatus.CREATED.value());
		r.setMsg("Data Update Sucessfully");
		r.setData(dao.update(p));
		
		return r;
		
		}
		
		ResponseBody<Product> re = new ResponseBody<Product>();
		re.setStatus(HttpStatus.BAD_REQUEST.value());
		
		re.setMsg("Admin Only Insert Product or Plaese Login Admin");
		
	
	return re ;
		
		
	}
	
	public  ResponseEntity<String>  login(String email,String password) {
		
		email.toLowerCase();
		
		char [] ch = email.toCharArray();
		
		
		ResponseEntity<String> r = new ResponseEntity<String>();
		ResponseEntity<String> re = new ResponseEntity<String>();
		re.setStatus(HttpStatus.BAD_REQUEST.value());
		re.setMsg("Login Failed");
		
		
		
				
			Sigup s = 	dao.login(email);
			
			if(s.getEmail().equals(email)) {
			
			if(s.getPassword().equals(password)) {
				
				 //String token =    ken.generateJwt();
				 
				 
				
				r.setStatus(HttpStatus.OK.value());
				r.setMsg("Login Sucessfully");
				
		      
				verification = true;
			
		         // r.setData(token);
				
				
				
				return r;
			}
			}
				
			
		
		
		return re;
		
	}
	
	
	/*                              Admin Page         */
	
	
	public ResponseBody<Admin> SaveAdmin(Admin a )  {
		
DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		
		LocalDateTime now = LocalDateTime.now();
		
		
		a.setDate(dtf.format(now));
		
		
		
		
		
		ResponseBody<Admin> r = new ResponseBody<Admin>();
		
		r.setStatus(HttpStatus.CREATED.value());
		r.setMsg("Admin Signup Suessfully");
		r.setData(dao.adminSave(a));
		
		
		return r;
	}
	
	
	public ResponseBody<String> adminLogin(String email,String password) {
		
	Admin admin = 	dao.adminLogin(email);
	
	if(admin.getEmail().equals(email)) {
		
		
		if(admin.getPassword().equals(password)) {
			
			ResponseBody<String> r = new ResponseBody<String>();
			
			r.setStatus(HttpStatus.OK.value());
			r.setMsg("Login Sucessfully");
			
			adminVerification=true;
		
			
			return r;
		}else {
			
         ResponseBody<String> r = new ResponseBody<String>();
			
			r.setStatus(HttpStatus.OK.value());
			r.setMsg("Invalid Password");
			
			
			return r;
		}
		
		
	}else {
		
ResponseBody<String> re = new ResponseBody<String>();
		
		re.setStatus(HttpStatus.OK.value());
		re.setMsg("Invalid Admin Email");
		//r.setData(dao.adminSave(a));
		
		return re;
		
	}
	
	
	
		
	}
	
	
	
		
		
	public String adminLogout() {
		
		if(adminVerification != false) {
			adminVerification=false;
			return "Logout Sucessfully";
		}
		else {
			return "Your Already Logout ";
		}
		
		
	}	
	
public String userLogout() {
		
		if(verification != false) {
			verification=false;
			return "Logout Sucessfully";
		}
		else {
			return "Your Already Logout ";
		}
		
		
	}	




/**********************************************************Forgot Password*/


public String forgot(String email,long ph) {
	
	
	
	Sigup s =  dao.forgot(email);
	
	
	if( s != null) {
		if(s.getContact()==ph) {
			
			otp =otp();
			
			
			
			
			return "Your Otp is : " + otp;
		}else {
			return "Invalid Phone Number";
		}
		
	}else {
		return "Invalid Email";
	}
	
	
}


public static  int otp() {
	
	
	return (int) (Math.random() * 9000) + 1000;
}



public String chagepassword(int o ,String email,String password) {
	
	if(this.otp ==o) {
		Sigup s =  dao.chageemail(email);
		
		if(s != null) {
			
		s.setPassword(password);
		
		dao.chagePasswordAndEmail(s);
		
			return "Password Changed sucessfully ";
			
		}else {
			return "Invalid Email";
		}
		
		
		
		
		
	}
	
	return "Invalid Otp";
	
	
	
}












			
			
			
			
		
	
	

}

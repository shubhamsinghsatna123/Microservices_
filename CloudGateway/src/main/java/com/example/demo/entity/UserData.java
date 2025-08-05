package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="SHUBHAM_CUSTOMER")
public class UserData {
	
	@Id
	private String email;
	private String password;
	private String role;
	private String name;
	private Long mobile;
	

}

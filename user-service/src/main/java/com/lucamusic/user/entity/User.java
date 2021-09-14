package com.lucamusic.user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	Long id;
	String fullName;
	String email;
	String password;
	Date registerDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Long id, String fullName, String email, String password, Date registerDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.registerDate = registerDate;
	}
}

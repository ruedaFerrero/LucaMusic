package com.lucamusic.user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
* Nombre de la clase: User

 * Esta clase es la entidad (Objeto Usuario)

 * @author:Emanuel

 * @version: 14/09/2021/v1

 
 */

 
@Entity
@Data
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

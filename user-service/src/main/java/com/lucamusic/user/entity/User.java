package com.lucamusic.user.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Nombre de la clase: User

 * Esta clase es la entidad (Objeto Usuario)

 * @author:Emanuel

 * @version: 14/09/2021/v1

 
 */

@Entity 
@Data
@Table(name = "users") @Builder @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(updatable = false)
	private Long id;
        @Column(nullable = false)
	private String fullName;
        @Column(nullable = false)
	private String email;
        @Column(nullable = false)
	private String password;
        @Column(nullable = false)
	private LocalDate registerDate;
        @Column(nullable = false)
        private String status;

	
}

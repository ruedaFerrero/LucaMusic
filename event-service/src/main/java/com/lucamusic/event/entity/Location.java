package com.lucamusic.event.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	Long id;
	String name;
	String place;
	String address;
	Integer capacity;



	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Location(Long id, String name, String place, String address, Integer capacity) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.address = address;
		this.capacity = capacity;
	}


	






}

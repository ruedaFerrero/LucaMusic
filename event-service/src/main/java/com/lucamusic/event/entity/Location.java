package com.lucamusic.event.entity;

import java.io.Serializable;

import lombok.Data;


@Data
public class Location implements Serializable {

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

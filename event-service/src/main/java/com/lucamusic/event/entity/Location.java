package com.lucamusic.event.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", place=" + place + ", address=" + address + ", capacity="
				+ capacity + "]";
	}







}

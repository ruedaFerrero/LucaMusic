package com.lucamusic.event.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Event {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	public Event() {
	}
	
	public Event(Long id, String name) {
		super();
		this.id=id;
		this.name=name;
	}
}

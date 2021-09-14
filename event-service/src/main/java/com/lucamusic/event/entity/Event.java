package com.lucamusic.event.entity;



import lombok.Data;


public class Event {

	
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

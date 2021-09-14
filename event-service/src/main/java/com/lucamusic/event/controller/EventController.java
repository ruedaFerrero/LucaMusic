package com.lucamusic.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.event.entity.Event;
import com.lucamusic.event.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService serv;
	
	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody Event event){
		Event eventCreate = serv.createEvent(event);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventCreate);
	}
	
	@PutMapping
	public ResponseEntity<Event> deleteEvent(@RequestBody Event event){
		Event eventDeleted = serv.deleteEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(eventDeleted);
	}
	
	@PutMapping
	public ResponseEntity<Event> modifyEvent(@RequestBody Event event){
		Event eventUpdated = serv.modifyEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(eventUpdated);
	}
}

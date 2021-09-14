package com.lucamusic.event.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucamusic.event.entity.Event;
import com.lucamusic.event.service.EventService;

/**
 * EventController
 * Clase Controller del microservicio, redirecciona según las peticiones realizadas por el cliente.
 * @version 1.0 Septiembre 2021
 * @author Jose Antonio, Edgar*/

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService serv;
	
	/**
	 * Metodo para crear un nuevo evento
	 * @param event Event
	 * @return respuesta 201, CREATED
	 * @author Jose Antonio*/
	@PostMapping
	public ResponseEntity<Event> createEvent(@RequestBody Event event){
		Event eventCreate = serv.createEvent(event);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventCreate);
	}
	
	/**
	 * Metodo para recuperar un listado completo de los eventos
	 * @return List<Event>
	 * @author Jose Antonio*/
	@GetMapping
	public ResponseEntity<List<Event>> getEvents(){
		List<Event> events = new ArrayList<>();
		events = serv.getEvents();
		if(events.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(events);
	}
	
	/**
	 * Metodo para recuperar un evento por id
	 * @param ObjectId id
	 * @return Event
	 * @author Jose Antonio*/
	@GetMapping("/{id}")
	public Event getEventById(@PathVariable ObjectId id){
	return serv.getEventById(id);
	}
	
	/**
	 * Metodo para eliminar un evento
	 * @param event Event
	 * @return ResponseEntity 200, OK
	 * @author Edgar*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Event> deleteEvent(@RequestBody Event event){
		Event eventDeleted = serv.deleteEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(eventDeleted);
	}
	
	/**
	 * Metodo para modificar un evento
	 * @param event Event
	 * @return ResponseEntity 200, OK
	 * @author Edgar*/
	@PutMapping("/{id}")
	public ResponseEntity<Event> modifyEvent(@RequestBody Event event){
		Event eventUpdated = serv.modifyEvent(event);
		return ResponseEntity.status(HttpStatus.OK).body(eventUpdated);
	}
}

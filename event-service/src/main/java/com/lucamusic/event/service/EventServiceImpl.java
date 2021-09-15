package com.lucamusic.event.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.event.entity.Event;
import com.lucamusic.event.repository.EventRepository;

import java.util.List;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public Event createEvent(Event event) {
		Event eventDB = eventRepository.findByName(event.getName());
		if(eventDB != null){
			System.out.println(event.getId());
			return eventDB;
		}

		log.info("Creating event...");
		event.setStatus("CREATED");
		return eventRepository.save(event);
	}

	@Override
	public List<Event> getEvents(){
		return eventRepository.findAll();
	}
        @Override
	public List<Event> eventsByStatus(String status){
		return eventRepository.findAllByStatus(status);
	}
	
	@Override
	public Event getEventById(String id) {
		return eventRepository.findById(id).orElse(null);
	}

	@Override
	public Event deleteEvent(Event event) {
		Event eventDB = getEventById(event.getId());
		if (eventDB == null){
            return null;
		}
		log.info("Deleting event...");
		eventDB.setStatus("DELETED");
        return eventRepository.save(eventDB);
	}

	@Override
	public Event modifyEvent(Event event) {
		Event eventDB = getEventById(event.getId());
		if (eventDB == null){
			return null;
		}

		log.info("Modifying event...");
		if(event.getName() != null){
			eventDB.setName(event.getName());
		}
		if(event.getShortDescription() != null){
			eventDB.setShortDescription(event.getShortDescription());
		}
		if(event.getLongDescription() != null){
			eventDB.setLongDescription(event.getLongDescription());
		}
		if(event.getPhotoUrl() != null){
			eventDB.setPhotoUrl(event.getPhotoUrl());
		}
		if(event.getDate() != null){
			eventDB.setDate(event.getDate());
		}
		if(event.getLocation() != null){
			eventDB.setLocation(event.getLocation());
		}
		if(event.getPrices() != null){
			eventDB.setPrices(event.getPrices());
		}
		if(event.getMusicStyle() != null){
			eventDB.setMusicStyle(event.getMusicStyle());
		}
		if(event.getTicketsSold() != null){
			eventDB.setTicketsSold(event.getTicketsSold());
		}
		return eventRepository.save(eventDB);
	}
}

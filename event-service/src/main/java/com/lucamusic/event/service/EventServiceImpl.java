package com.lucamusic.event.service;

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.event.entity.Event;
import com.lucamusic.event.repository.EventRepository;

import java.util.List;
import java.util.Optional;

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
		Optional<Event> eventDB = eventRepository.findById(event.getId());
                if (eventDB == null){
                    log.error("Deleting event error...");
                    return eventDB.get();
                }
		//return eventDB.orElseGet(() -> {
                log.info("Deleting event...");
                event.setStatus("DELETED");
                return eventRepository.save(event);
		//});
		/*return eventDB.orElseGet(() -> {
			log.info("Deleting event...");
			event.setStatus("DELETED");
			return eventRepository.save(event);
		});*/
	}

	@Override
	public Event modifyEvent(Event event) {
		Optional<Event> eventDB = eventRepository.findById(event.getId());
                if (eventDB == null){
                    log.error("Modifying event error...");
                    return eventDB.get();
                }
                
                log.info("Modifying event...");
                return eventRepository.save(event);
	}
}

package com.lucamusic.event.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucamusic.event.entity.Event;
import com.lucamusic.event.repository.EventRepository;

import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public Event createEvent(Event event) {
		Optional<Event> eventDB = eventRepository.findById(event.getId());
		return eventDB.orElseGet(() -> {
			log.info("Creating event...");
			event.setStatus("CREATED");
			return eventRepository.save(event);
		});
	}
}

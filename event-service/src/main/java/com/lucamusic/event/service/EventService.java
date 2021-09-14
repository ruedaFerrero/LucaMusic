package com.lucamusic.event.service;

import com.lucamusic.event.entity.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
	public Event createEvent(Event event);
}

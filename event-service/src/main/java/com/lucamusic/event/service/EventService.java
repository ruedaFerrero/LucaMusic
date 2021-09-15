package com.lucamusic.event.service;

import java.util.List;
import com.lucamusic.event.entity.Event;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

public interface EventService {
	public Event createEvent(Event event);
	public List<Event> getEvents();
	public Event getEventById(String id);
	public Event deleteEvent(Event event);
	public Event modifyEvent(Event event);
	public List<Event> eventsByStatus(String status);
}

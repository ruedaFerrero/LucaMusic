package com.lucamusic.event.repository;

import com.lucamusic.event.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, Long> {
    public Event findByName(String name);
}

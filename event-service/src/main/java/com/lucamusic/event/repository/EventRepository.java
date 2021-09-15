package com.lucamusic.event.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.event.entity.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{
	public List<Event> findAll();
	public Event findByName(String name);
        public List<Event> findAllByStatus(String status);
}

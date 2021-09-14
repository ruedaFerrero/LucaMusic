package com.lucamusic.event.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.event.entity.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, String>{
	public List<Event> findAll();
}

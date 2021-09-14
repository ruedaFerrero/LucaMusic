package com.lucamusic.event.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.event.entity.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, ObjectId>{
	public List<Event> findAll();
}

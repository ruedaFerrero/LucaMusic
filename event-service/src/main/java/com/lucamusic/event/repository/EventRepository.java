package com.lucamusic.event.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucamusic.event.entity.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, Long>{
	
	public Optional<Event> findById(Long id);
	public List<Event> findAll();

}

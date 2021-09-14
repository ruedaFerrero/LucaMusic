package com.lucamusic.event.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.Map;

@Data
@Document(value = "events") @Builder
public class Event {
	@MongoId
	private String id;
	private String name;
	private String shortDescription;
	private String longDescription;
	private String photoUrl;
	private Date date;
	private Location location;
	Map<String, Double> prices;
	private String musicStyle;
	private Integer ticketsSold = 0;
}

package com.lucamusic.event.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Location implements Serializable {
	private String name;
	private String place;
	private String address;
	private Integer capacity;
}

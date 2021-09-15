package com.lucamusic.event.entity;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data @Builder
public class Location implements Serializable {
	@NotNull
	private String name;
	@NotNull
	private String address;
	@NotNull
	private Integer capacity;
}

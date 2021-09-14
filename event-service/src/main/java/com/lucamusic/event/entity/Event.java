package com.lucamusic.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "events")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Event implements Serializable {
    @Id
    private Long id;
    private String name;
    private Double money;
    private Location location;
}
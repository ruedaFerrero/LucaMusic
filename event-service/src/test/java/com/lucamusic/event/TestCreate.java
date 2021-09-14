package com.lucamusic.event;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.lucamusic.event.controller.EventController;
import com.lucamusic.event.entity.Event;
import com.lucamusic.event.repository.EventRepository;
import com.lucamusic.event.service.EventService;
import com.lucamusic.event.service.EventServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
public class TestCreate {
	
	@Autowired
	private MockMvc mockMvc;
	
	@TestConfiguration
	static class TestCreateConfiguration{
		@Bean
		public EventService eventService() {
			return new EventServiceImpl();
		}
		
	}
	
	@Autowired
	private EventService eventService;
	
	@MockBean
	private EventRepository eventRepository;
	
	
	@Test
	void assertEventToCreateHasName() throws Exception {
		Event event = new Event(1L,"Tomorrowland");
		
		when(eventService.createEvent(event)).thenReturn(event);
		
		mockMvc
			.perform(post("/add"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("/add")));

	}

}

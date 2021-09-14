//package com.lucamusic.event;
//
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.Date;
//
//import org.bson.types.ObjectId;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lucamusic.event.controller.EventController;
//import com.lucamusic.event.entity.Event;
//import com.lucamusic.event.entity.Location;
//import com.lucamusic.event.repository.EventRepository;
//import com.lucamusic.event.service.EventService;
//import com.lucamusic.event.service.EventServiceImpl;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(EventController.class)
//public class TestCreate {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@TestConfiguration
//	static class TestCreateConfiguration{
//		@Bean
//		public EventService eventService() {
//			return new EventServiceImpl();
//		}
//
//	}
//
//	@Autowired
//	private EventService eventService;
//
//	@MockBean
//	private EventRepository eventRepository;
//
//
//	@Test
//	void assertEventisCreated() throws Exception {
//
//		Location location = Location.builder()
//										.address("a")
//										.capacity(5000)
//										.name("b")
//										.place("c")
//										.build();
//		Event event = Event.builder()
//						.date(new Date())
//						.id(new ObjectId())
//						.location(location)
//						.longDescription("long")
//						.shortDescription("short")
//						.musicStyle("style")
//						.name("nombre")
//						.photoUrl("photoUrl")
//						.status("status")
//						.ticketsSold(7)
//						.prices(null)
//						.build();
//
//
//		when(eventService.createEvent(event)).thenReturn(event);
//
//
//		mockMvc
//			.perform(post("/events")
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(asJsonString(event)))
//			.andExpect(status().isCreated());
//
//	}
//
//	public static String asJsonString(final Event event) {
//	    try {
//	        return new ObjectMapper().writeValueAsString(event);
//	    } catch (Exception e) {
//	        throw new RuntimeException(e);
//	    }
//	}
//
//}

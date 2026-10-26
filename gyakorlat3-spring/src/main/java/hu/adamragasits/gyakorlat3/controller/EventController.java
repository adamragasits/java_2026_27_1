package hu.adamragasits.gyakorlat3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hu.adamragasits.gyakorlat3.dto.NewEventShape;
import hu.adamragasits.gyakorlat3.model.Event;
import hu.adamragasits.gyakorlat3.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	private final EventService eventService;
	
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Event>> getEvents() {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEvents());
	}
	
	
	@PostMapping
	public ResponseEntity<String> createNewEvent(
			@RequestBody NewEventShape body
	) {
		return ResponseEntity.ok().body(eventService.createNewEvent(body));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<String> patchEvent(
			@RequestBody NewEventShape body,
			@PathVariable Long id
	) {
		return ResponseEntity.ok().body(eventService.patchEvent(body, id));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEvent(
			@PathVariable Long id
	) {
		return ResponseEntity.ok().body(eventService.deleteEvent(id));
	}
}

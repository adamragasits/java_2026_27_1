package hu.adamragasits.gyakorlat3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hu.adamragasits.gyakorlat3.dto.NewEventShape;
import hu.adamragasits.gyakorlat3.model.Event;
import hu.adamragasits.gyakorlat3.repository.EventRepository;

@Service
public class EventService {
	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}
	
	public String createNewEvent(NewEventShape body) {
		if(body.title() == null || body.description() == null) {
			return "hiányzó adatok";
		}
		
		Event e = new Event();
		e.title = body.title();
		e.description = body.description();
		
		eventRepository.save(e);
		return "siker";
	}
	
	public String patchEvent(NewEventShape body, Long id) {
		Optional<Event> event = eventRepository.findById(id);
		if(event.isEmpty()) {
			return "Nincs ilyen azonosítójú esemény!";
		}
		
		Event event2 = event.get();
		
		if(body.title() != null) {
			event2.title = body.title();
		}
		
		if(body.description() != null) {
			event2.description = body.description();
		}
		
		eventRepository.save(event2);
		return "Siker";
	}
	
	
	public String deleteEvent(Long id) {
		if(!eventRepository.existsById(id)) {
			return "Nem létezik ilyen esemény!";
		}
		
		eventRepository.deleteById(id);
		return "Siker";
	}
}

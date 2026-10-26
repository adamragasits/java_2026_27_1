package hu.adamragasits.gyakorlat3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.adamragasits.gyakorlat3.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	boolean existsById(Long id);
}

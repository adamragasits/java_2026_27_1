package hu.adamragasits.gyakorlat3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column
	public String title;
	
	@Column
	public String description;
	
}

package gyakorlat1;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Check;

import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(length = 100)
	public String name;
	
	@Column
	public Instant starts_at;
	
	@Column
	@Check(constraints = "capacity > 0")
	public Long capacity;
	
	@OneToMany(
		mappedBy = "event",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	public List<Booking> bookings = new ArrayList<>();
	
	
}

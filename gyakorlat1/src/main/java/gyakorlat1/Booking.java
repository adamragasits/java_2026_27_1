package gyakorlat1;

import java.time.Instant;

import org.hibernate.annotations.Check;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(length = 100)
	public String customer;
	
	@Column
	@Check(constraints = "seats > 0")
	public Long seats;
	
	@ManyToOne(
		fetch = FetchType.EAGER,
		optional = false
	)
	@JoinColumn(name = "event_id")
	public Event event;
}

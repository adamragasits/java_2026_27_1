package gyakorlat1;

import java.time.Instant;

import jakarta.persistence.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("workflow");
	
		Event e = new Event();
		e.capacity = 250L;
		e.name = "Java október 8";
		e.starts_at = Instant.now();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
}

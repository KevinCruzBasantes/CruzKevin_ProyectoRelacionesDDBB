package ec.edu.uce.Aerolinea.Aerolinea.repository;

import ec.edu.uce.Aerolinea.Aerolinea.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}

package ec.edu.uce.Aerolinea.Aerolinea.repository;

import ec.edu.uce.Aerolinea.Aerolinea.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline,Long> {
}

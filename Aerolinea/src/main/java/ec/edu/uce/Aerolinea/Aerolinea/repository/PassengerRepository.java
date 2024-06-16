package ec.edu.uce.Aerolinea.Aerolinea.repository;

import ec.edu.uce.Aerolinea.Aerolinea.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}

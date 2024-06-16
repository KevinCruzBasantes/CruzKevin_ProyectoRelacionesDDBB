package ec.edu.uce.Aerolinea.Aerolinea.repository;

import ec.edu.uce.Aerolinea.Aerolinea.models.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo,Long> {
}

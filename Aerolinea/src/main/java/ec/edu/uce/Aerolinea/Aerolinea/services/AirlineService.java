package ec.edu.uce.Aerolinea.Aerolinea.services;
import ec.edu.uce.Aerolinea.Aerolinea.models.Airline;
import ec.edu.uce.Aerolinea.Aerolinea.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepository;

    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    public Optional<Airline> getAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    public void deleteAirline(Long id) {
        airlineRepository.deleteById(id);
    }

    public void updateAirline(Long id, Airline updatedAirline) {
        Optional<Airline> existingAirline = airlineRepository.findById(id);
        if (existingAirline.isPresent()) {
            Airline airline = existingAirline.get();
            airline.setName(updatedAirline.getName());
            airlineRepository.save(airline);
        } else {
            throw new RuntimeException("Airline not found!");
        }
    }
}

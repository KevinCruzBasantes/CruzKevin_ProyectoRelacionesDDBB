package ec.edu.uce.Aerolinea.Aerolinea.services;

import ec.edu.uce.Aerolinea.Aerolinea.models.Passenger;
import ec.edu.uce.Aerolinea.Aerolinea.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    public void updatePassenger(Long id, Passenger updatedPassenger) {
        Optional<Passenger> existingPassenger = passengerRepository.findById(id);
        if (existingPassenger.isPresent()) {
            Passenger passenger = existingPassenger.get();
            passenger.setName(updatedPassenger.getName());
            passenger.setPassengerInfo(updatedPassenger.getPassengerInfo());
            passenger.setFlight(updatedPassenger.getFlight());
            passenger.setFlights(updatedPassenger.getFlights()); // Actualizar la lista de vuelos
            passengerRepository.save(passenger);
        } else {
            throw new RuntimeException("Passenger not found!");
        }
    }
}


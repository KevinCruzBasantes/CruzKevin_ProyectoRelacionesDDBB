package ec.edu.uce.Aerolinea.Aerolinea.services;

import ec.edu.uce.Aerolinea.Aerolinea.models.Flight;
import ec.edu.uce.Aerolinea.Aerolinea.models.Passenger;
import ec.edu.uce.Aerolinea.Aerolinea.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public void updateFlight(Long id, Flight updatedFlight) {
        Optional<Flight> existingFlight = flightRepository.findById(id);
        if (existingFlight.isPresent()) {
            Flight flight = existingFlight.get();
            flight.setFlightNumber(updatedFlight.getFlightNumber());
            flight.setAirline(updatedFlight.getAirline());
            flight.setPassengers(updatedFlight.getPassengers()); // Actualizar la lista de pasajeros
            flightRepository.save(flight);
        } else {
            throw new RuntimeException("Flight not found!");
        }
    }

    // Método para añadir un pasajero a un vuelo
    public void addPassengerToFlight(Long flightId, Passenger passenger) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            List<Passenger> passengers = flight.getPassengers();
            passengers.add(passenger);
            flight.setPassengers(passengers);
            flightRepository.save(flight);
        } else {
            throw new RuntimeException("Flight not found!");
        }
    }
}



package ec.edu.uce.Aerolinea.Aerolinea;

import ec.edu.uce.Aerolinea.Aerolinea.models.Airline;
import ec.edu.uce.Aerolinea.Aerolinea.models.Flight;
import ec.edu.uce.Aerolinea.Aerolinea.models.Passenger;
import ec.edu.uce.Aerolinea.Aerolinea.models.PassengerInfo;
import ec.edu.uce.Aerolinea.Aerolinea.repository.AirlineRepository;
import ec.edu.uce.Aerolinea.Aerolinea.repository.FlightRepository;

import ec.edu.uce.Aerolinea.Aerolinea.services.AirlineService;
import ec.edu.uce.Aerolinea.Aerolinea.services.FlightService;
import ec.edu.uce.Aerolinea.Aerolinea.services.PassengerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class AerolineaApplication implements CommandLineRunner {
	@Autowired
	private AirlineService airlineService;

	@Autowired
	private FlightService flightService;

	@Autowired
	private PassengerService passengerService;
	public static void main(String[] args) {


		SpringApplication.run(AerolineaApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		// Crear algunas aerolíneas
		Airline airline1 = new Airline(null, "American Airlines");
		Airline airline2 = new Airline(null, "Latam Airlines");

		// Guardar las aerolíneas utilizando el servicio
		airlineService.saveAirline(airline1);
		airlineService.saveAirline(airline2);

		// Crear algunos vuelos asociados a las aerolíneas
		Flight flight1 = new Flight(null, "AA123");
		Flight flight2 = new Flight(null, "DL456");

		// Asignar las aerolíneas a los vuelos
		flight1.setAirline(airline1);
		flight2.setAirline(airline2);

		// Guardar los vuelos utilizando el servicio
		flightService.saveFlight(flight1);
		flightService.saveFlight(flight2);

		// Crear algunos pasajeros y su información asociada
		PassengerInfo info1 = new PassengerInfo(null, "andrea.d@mail.com", "1234567890", null);
		PassengerInfo info2 = new PassengerInfo(null, "jennifer.s@mail.com", "0987654321", null);

		Passenger passenger1 = new Passenger(null, "Andrea Diaz", info1, null);
		Passenger passenger2 = new Passenger(null, "Jennifer Santos", info2, null);

		// Asignar la información de pasajero a los pasajeros
		passenger1.setPassengerInfo(info1);
		passenger2.setPassengerInfo(info2);

		// Asignar vuelos a los pasajeros
		List<Flight> flightsPassenger1 = new ArrayList<>();
		flightsPassenger1.add(flight1);
		passenger1.setFlights(flightsPassenger1);

		List<Flight> flightsPassenger2 = new ArrayList<>();
		flightsPassenger2.add(flight2);
		passenger2.setFlights(flightsPassenger2);

		// Guardar los pasajeros utilizando el servicio de PassengerService
		passengerService.savePassenger(passenger1);
		passengerService.savePassenger(passenger2);

		// Agregar pasajeros a los vuelos usando el servicio de FlightService
		flightService.addPassengerToFlight(flight1.getId(), passenger1);
		flightService.addPassengerToFlight(flight2.getId(), passenger2);




	}
}

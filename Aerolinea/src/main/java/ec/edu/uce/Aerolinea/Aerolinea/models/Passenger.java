package ec.edu.uce.Aerolinea.Aerolinea.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_info_id")
    private PassengerInfo passengerInfo;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToMany
    @JoinTable(
            name = "passenger_flight",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private List<Flight> flights;

    public Passenger() {
    }

    public Passenger(Long id, String name, PassengerInfo passengerInfo, Flight flight) {
        this.id = id;
        this.name = name;
        this.passengerInfo = passengerInfo;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public PassengerInfo getPassengerInfo() {
        return passengerInfo;
    }

    public void setPassengerInfo(PassengerInfo passengerInfo) {
        this.passengerInfo = passengerInfo;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}


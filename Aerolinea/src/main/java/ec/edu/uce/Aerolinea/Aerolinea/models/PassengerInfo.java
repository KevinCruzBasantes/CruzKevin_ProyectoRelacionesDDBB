package ec.edu.uce.Aerolinea.Aerolinea.models;

import jakarta.persistence.*;

@Entity
public class PassengerInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;

    @OneToOne(mappedBy = "passengerInfo")
    private Passenger passenger;

    public PassengerInfo() {
    }

    public PassengerInfo(Long id, String email, String phone, Passenger passenger) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.passenger = passenger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

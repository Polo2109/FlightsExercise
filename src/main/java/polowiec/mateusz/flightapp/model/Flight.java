package polowiec.mateusz.flightapp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flightId;
    private Integer flightNumber;
    private String departureAirportIATACode;
    private String arrivalAirportIATACode;
    private String departureDate;
    @OneToMany(mappedBy = "flight", cascade = CascadeType.MERGE)
    private List<Baggage> baggage = new ArrayList<>();
    @OneToMany(mappedBy = "flight", cascade = CascadeType.MERGE)
    private List<Cargo> cargo = new ArrayList<>();

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public void setDepartureAirportIATACode(String departureAirportIATACode) {
        this.departureAirportIATACode = departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public void setArrivalAirportIATACode(String arrivalAirportIATACode) {
        this.arrivalAirportIATACode = arrivalAirportIATACode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public List<Baggage> getBaggage() {
        return baggage;
    }

    public void setBaggage(List<Baggage> baggages) {
        this.baggage = baggages;
    }

    public List<Cargo> getCargo() {
        return cargo;
    }

    public void setCargo(List<Cargo> cargos) {
        this.cargo = cargos;
    }
    public void updateBaggageFlightId(List<Baggage> baggage){
        baggage.forEach(p ->{
            p.setFlight(this);
        });
    }
    public void updateCargoFlightId(List<Cargo> cargo){
        cargo.forEach(p ->{
            p.setFlight(this);
        });
    }
}

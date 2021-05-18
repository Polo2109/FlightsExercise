package polowiec.mateusz.flightapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polowiec.mateusz.flightapp.model.Flight;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findByFlightNumberAndDepartureDate(Integer flightNumber, String departureDate);

    List<Flight> findAllByArrivalAirportIATACodeAndDepartureDate(String airportCode, String departureDate);

    List<Flight> findAllByDepartureAirportIATACodeAndDepartureDate(String airportCode, String departureDate);
}

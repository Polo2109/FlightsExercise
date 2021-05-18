package polowiec.mateusz.flightapp.service;

import org.springframework.stereotype.Service;
import polowiec.mateusz.flightapp.dto.AirportInformations;
import polowiec.mateusz.flightapp.dto.Weights;
import polowiec.mateusz.flightapp.model.Flight;
import polowiec.mateusz.flightapp.repository.FlightRepository;
import polowiec.mateusz.flightapp.utility.FlightUtil;

import java.util.List;

@Service
public class FlightService {

    private FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void save(List<Flight> flights) {
        flights.forEach(p -> {
            p.updateBaggageFlightId(p.getBaggage());
            p.updateCargoFlightId(p.getCargo());
            flightRepository.save(p);
        });
    }

    public Weights getWeights(Integer flightNumber, String date) {
        Weights weights = new Weights();
        Flight flight = flightRepository.findByFlightNumberAndDepartureDate(flightNumber, date);
        weights.setBaggageWeight(FlightUtil.baggageWeightCalculator(flight));
        weights.setCargoWeight(FlightUtil.cargoWeightCalculator(flight));
        weights.setTotalWeight(weights.getBaggageWeight() + weights.getCargoWeight());
        return weights;
    }

    public AirportInformations getAirportInformations(String airportCode, String date) {
        AirportInformations airportInformations = new AirportInformations();
        List<Flight> arrivalFlights = flightRepository.findAllByArrivalAirportIATACodeAndDepartureDate(airportCode, date);
        List<Flight> departureFlights = flightRepository.findAllByDepartureAirportIATACodeAndDepartureDate(airportCode, date);
        airportInformations.setBaggageArriving(
                FlightUtil.baggageAmountCalculator(arrivalFlights));
        airportInformations.setBaggageDeparting(
                FlightUtil.baggageAmountCalculator(departureFlights));

        airportInformations.setFlightsArriving(FlightUtil.numberOfFlights(arrivalFlights));
        airportInformations.setFlightsDeparting(FlightUtil.numberOfFlights(departureFlights));
        return airportInformations;
    }
}

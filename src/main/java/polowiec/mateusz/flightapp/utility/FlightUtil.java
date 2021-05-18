package polowiec.mateusz.flightapp.utility;

import polowiec.mateusz.flightapp.dto.Weights;
import polowiec.mateusz.flightapp.model.Baggage;
import polowiec.mateusz.flightapp.model.Cargo;
import polowiec.mateusz.flightapp.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightUtil {

    private static final double LBTOKG = 0.45359237;

    public static int baggageAmountCalculator(List<Flight> flights) {
        int baggageAmount = 0;
        for (Flight aF : flights) {
            for (Baggage baggage : aF.getBaggage()) {
                baggageAmount += baggage.getPieces();
            }
        }
        return baggageAmount;
    }
    public static List<Integer> numberOfFlights (List<Flight> flights){
        return flights.stream()
                .map(Flight::getFlightNumber)
                .collect(Collectors.toList());
    }
    public static double baggageWeightCalculator(Flight flight) {
        double weight = 0;
        List<Baggage> baggage = flight.getBaggage();
        for (Baggage b : baggage) {
            if (b.getWeightUnit().equals("lb"))
                weight += (b.getWeight() * LBTOKG);
            else
                weight += b.getWeight();
        }
        return weight;
    }
    public static double cargoWeightCalculator(Flight flight) {
        double weight = 0;
        List<Cargo> cargos = flight.getCargo();
        for (Cargo c : cargos) {
            if (c.getWeightUnit().equals("lb"))
                weight += (c.getWeight() * LBTOKG);
            else
                weight += c.getWeight();
        }
        return weight;
    }
}

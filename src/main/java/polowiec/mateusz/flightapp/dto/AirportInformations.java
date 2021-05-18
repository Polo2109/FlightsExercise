package polowiec.mateusz.flightapp.dto;

import java.util.List;

public class AirportInformations {

    private List<Integer> flightsDeparting;
    private List<Integer> flightsArriving;
    private Integer baggageArriving;
    private Integer baggageDeparting;

    public List<Integer> getFlightsDeparting() {
        return flightsDeparting;
    }

    public void setFlightsDeparting(List<Integer> flightsDeparting) {
        this.flightsDeparting = flightsDeparting;
    }

    public List<Integer> getFlightsArriving() {
        return flightsArriving;
    }

    public void setFlightsArriving(List<Integer> flightsArriving) {
        this.flightsArriving = flightsArriving;
    }

    public Integer getBaggageArriving() {
        return baggageArriving;
    }

    public void setBaggageArriving(Integer baggageArriving) {
        this.baggageArriving = baggageArriving;
    }

    public Integer getBaggageDeparting() {
        return baggageDeparting;
    }

    public void setBaggageDeparting(Integer baggageDeparting) {
        this.baggageDeparting = baggageDeparting;
    }
}

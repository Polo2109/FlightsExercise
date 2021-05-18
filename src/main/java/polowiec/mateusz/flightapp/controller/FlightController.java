package polowiec.mateusz.flightapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import polowiec.mateusz.flightapp.dto.AirportInformations;
import polowiec.mateusz.flightapp.dto.Weights;
import polowiec.mateusz.flightapp.model.Flight;
import polowiec.mateusz.flightapp.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/weights")
    public ResponseEntity<Weights> getWeights (@RequestParam Integer flightNumber, @RequestParam String date){
        return ResponseEntity.ok(flightService.getWeights(flightNumber, date));
    }
    @GetMapping("/info")
    public ResponseEntity<AirportInformations> getInformations (@RequestParam String airportCode, @RequestParam String date){
        return ResponseEntity.ok(flightService.getAirportInformations(airportCode, date));
    }
}

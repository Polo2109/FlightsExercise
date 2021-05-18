package polowiec.mateusz.flightapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import polowiec.mateusz.flightapp.model.Flight;
import polowiec.mateusz.flightapp.service.FlightService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class FlightAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(FlightService flightService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Flight>> typeReference = new TypeReference<List<Flight>>() {};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/flight.json");
            try{
                List<Flight> flights = mapper.readValue(inputStream, typeReference);
                flightService.save(flights);
                System.out.println("Flights saved!!!");
            }catch (IOException e){
                System.out.println("Unable to save flights" + e.getMessage());
            }
        };
    }

}

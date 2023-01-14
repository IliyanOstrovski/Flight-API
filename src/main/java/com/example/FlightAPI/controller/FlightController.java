package com.example.FlightAPI.controller;
import com.example.FlightAPI.model.Flights;
import com.example.FlightAPI.model.dto.StatsDTO;
import com.example.FlightAPI.repository.FlightRepository;
import com.example.FlightAPI.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api-flights/")
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flights> getAllFlights() {
        return flightRepository.findAll();
    }

    @GetMapping("/flights/{id}")
    ResponseEntity<?> getFLight(@PathVariable Long id) {
        Optional<Flights> group = flightRepository.findById(id);
        return group.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/statistics")
    ResponseEntity<StatsDTO> getStatisticsFlights() {
        return ResponseEntity.ok(flightService.getStatistics());
    }

    @PostMapping("/flights")
    ResponseEntity<Flights> createFlight(@Valid @RequestBody Flights flights) throws URISyntaxException {
        Flights result = flightRepository.save(flights);
        return ResponseEntity.created(new URI("/api-flights/flights/" + result.getId()))
                .body(result);
    }

    @PutMapping("/flights/{id}")
    ResponseEntity<Flights> updateFlight(@Valid @RequestBody Flights flights) {
        Flights result = flightRepository.save(flights);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Flights> deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

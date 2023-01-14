package com.example.FlightAPI.controller;
import com.example.FlightAPI.model.Flights;
import com.example.FlightAPI.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FlightControllerTest {
    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightController flightController;

    @Test
    void createFlightWhenFlightIsCreatedThenReturn201() throws URISyntaxException {
        Flights flights =
                new Flights(1, 1, 1200.0, LocalDateTime.now(), LocalDateTime.now(), "RETURN");
        when(flightRepository.save(flights)).thenReturn(flights);
        ResponseEntity<Flights> response = flightController.createFlight(flights);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getFlightWhenFlightIsNotFoundThenReturn404() {
        when(flightRepository.findById(1L)).thenReturn(java.util.Optional.empty());
        assertEquals(404, flightController.getFLight(1L).getStatusCodeValue());
    }

    @Test
    void getFlightWhenFlightIsFoundThenReturn200() {
        Flights flights =
                new Flights(1, 12922, 192.2, LocalDateTime.now(), LocalDateTime.now(), "RETURN");
        when(flightRepository.findById(1L)).thenReturn(java.util.Optional.of(flights));

        ResponseEntity<?> response = flightController.getFLight(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getAllFlightsShouldReturnAllFlights() {
        List<Flights> flights = new ArrayList<>();
        flights.add(new Flights(1, 11232, 190.0, LocalDateTime.now(), LocalDateTime.now(), "RETURN"));
        flights.add(new Flights(2, 26542, 250.0, LocalDateTime.now(), LocalDateTime.now(), "ONEWAY"));
        when(flightRepository.findAll()).thenReturn(flights);

        List<Flights> result = flightController.getAllFlights();

        assertEquals(2, result.size());
        verify(flightRepository, times(1)).findAll();
    }

    @Test
    void updateFlightWhenFlightIsUpdatedThenReturn200() {
        Flights flights =
                new Flights(1, 19122, 550.0, LocalDateTime.now(), LocalDateTime.now(), "RETURN");
        when(flightRepository.save(flights)).thenReturn(flights);

        ResponseEntity<Flights> responseEntity = flightController.updateFlight(flights);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(flights, responseEntity.getBody());
    }
}
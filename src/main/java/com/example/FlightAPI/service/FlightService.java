package com.example.FlightAPI.service;
import com.example.FlightAPI.model.dto.StatsDTO;
import com.example.FlightAPI.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public StatsDTO getStatistics(){
        StatsDTO statsDTO = flightRepository.getStatistics();
        return statsDTO;

    }
}

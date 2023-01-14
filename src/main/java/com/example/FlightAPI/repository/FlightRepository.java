package com.example.FlightAPI.repository;
import com.example.FlightAPI.model.Flights;
import com.example.FlightAPI.model.dto.StatsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flights, Long> {

    @Query(value = "SELECT new com.example.FlightAPI.model.dto.StatsDTO(" +
            "SUM(f.amount), " +
            "AVG(f.amount), " +
            "MAX(f.amount), " +
            "MIN(f.amount), " +
            "COUNT(f.id)) " +
            "FROM Flights as f")
    StatsDTO getStatistics();

}


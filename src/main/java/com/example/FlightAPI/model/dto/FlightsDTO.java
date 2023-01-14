package com.example.FlightAPI.model.dto;
import java.time.LocalDateTime;

public class FlightsDTO {

    private long id;
    private int orderNumber;
    private Double amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String type;

    public FlightsDTO(long id, int orderNumber, Double amount, LocalDateTime startDate, LocalDateTime endDate, String type) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.amount = amount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

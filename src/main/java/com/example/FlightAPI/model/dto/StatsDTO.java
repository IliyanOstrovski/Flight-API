package com.example.FlightAPI.model.dto;

public class StatsDTO {
    private Double sum;
    private Double avg;
    private Double max;
    private Double min;
    private Long id;

    public StatsDTO(Double sum, Double avg, Double max, Double min, Long id) {
        this.sum = sum;
        this.avg = avg;
        this.max = max;
        this.min = min;
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double avg) {
        this.avg = avg;
    }

    public Double getMax() {
        return max;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}




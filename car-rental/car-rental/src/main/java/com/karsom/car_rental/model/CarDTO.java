package com.karsom.car_rental.model;

import java.math.BigDecimal;

public class CarDTO {
    private String make;
    private String model;
    private boolean availability;
    private BigDecimal pricePerDay;


    // Constructor
    public CarDTO(String make, String model, boolean availability, BigDecimal pricePerDay) {
        this.make = make;
        this.model = model;
        this.availability = availability;
        this.pricePerDay = pricePerDay;
    }

    // Getters
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getAvailability() {
        return availability ? "Available" : "Not Available"; }
    public String getPricePerDay() { return "RM" + pricePerDay + " per Day"; }
}


package com.karsom.car_rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cars")
@Lazy
public class Car {

    // Key ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    @JsonProperty("car_id")
    private Long carId;

    // Main Attributes
    @Column(name = "car_type")
    @JsonProperty("car_type")
    private String type;

    @JsonProperty("make")
    private String make;

    @JsonProperty("model")
    private String model;

    @JsonProperty("description")
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    @JsonProperty("manufacture")
    private LocalDate manufacture;

    @JsonProperty("availability")
    private boolean availability;

    @Column(name = "price_per_day")
    @JsonProperty("price_per_day")
    private BigDecimal pricePerDay;

    // Physical Attributes
    @JsonProperty("color")
    private String color;

    @JsonProperty("mileage")
    private int mileage;

    @Column(name = "fuel_type")
    @JsonProperty("fuel_type")
    private String fuelType;

    @Column(name = "License_plate")
    @JsonProperty("license_plate")
    private String licensePlate;

    @Column(name = "Seating_capacity")
    @JsonProperty("seating_capacity")
    private int seatingCapacity;

    @Column(name = "daily_rate")
    @JsonProperty("daily_rate")
    private BigDecimal dailyRate;

    // Constructor
    public Car(Long carId, String type, String make, String model, String description, LocalDate manufacture, boolean availability, BigDecimal pricePerDay, String color, int mileage, String fuelType, String licensePlate, int seatingCapacity, BigDecimal dailyRate) {
        this.carId = carId;
        this.type = type;
        this.make = make;
        this.model = model;
        this.description = description;
        this.manufacture = manufacture;
        this.availability = availability;
        this.pricePerDay = pricePerDay;
        this.color = color;
        this.mileage = mileage;
        this.fuelType =fuelType;
        this.licensePlate = licensePlate;
        this.seatingCapacity = seatingCapacity;
        this.dailyRate = dailyRate;
    }

    public Car() {}

    // Getters
    public Long getCarId() { return  carId; }
    public String getType() { return type; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getDescription() { return description; }
    public LocalDate getManufacture() { return manufacture; }
    public boolean getAvailability() { return availability; }
    public BigDecimal getPricePerDay() { return pricePerDay; }
    public String getColor() { return color; }
    public int getMileage() { return mileage; }
    public String getFuelType() { return fuelType; }
    public String getLicensePlate() { return licensePlate; }
    public int getSeatingCapacity() { return seatingCapacity; }
    public BigDecimal getDailyRate() { return dailyRate; }

    // Setters
    public void setCarId(Long carId) { this.carId = carId; }
    public void setType(String type) { this.type = type; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setDescription(String description) { this.description = description; }
    public void setManufacture(LocalDate manufacture) { this.manufacture = manufacture; }
    public void setAvailability(boolean availability) { this.availability = availability; }
    public void setPricePerDay(BigDecimal pricePerDay) { this.pricePerDay = pricePerDay; }
    public void setColor(String color) { this.color = color; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setSeatingCapacity(int seatingCapacity) { this.seatingCapacity = seatingCapacity; }
    public void setDailyRate(BigDecimal dailyRate) { this.dailyRate = dailyRate; }

}

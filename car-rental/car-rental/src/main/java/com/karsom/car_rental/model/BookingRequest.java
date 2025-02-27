package com.karsom.car_rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class BookingRequest {

    @NotNull
    private int carId;

    @NotNull
    private int customerId;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

    // Getters
    public int getCarId() { return carId; }
    public int getCustomerId() { return customerId; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalDate getReturnDate() { return returnDate; }

    // Setters
    public void setCarId(int carId) { this.carId = carId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}


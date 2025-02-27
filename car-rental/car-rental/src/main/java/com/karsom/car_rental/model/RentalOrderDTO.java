package com.karsom.car_rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RentalOrderDTO {
    private int orderId;
    private CarDTO car;
    private CustomerDTO customer;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate rentalDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate returnDate;
    private BigDecimal totalCost;

    public RentalOrderDTO(int orderId, CarDTO car, CustomerDTO customer, LocalDate rentalDate, LocalDate returnDate, BigDecimal totalCost) {
        this.orderId = orderId;
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public CarDTO getCar() { return car; }
    public CustomerDTO getCustomer() { return customer; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public String getTotalCost() { return "RM" + totalCost; }
}

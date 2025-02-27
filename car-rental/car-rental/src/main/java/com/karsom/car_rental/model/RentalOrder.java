package com.karsom.car_rental.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class RentalOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Customer customer;

    @JsonProperty("rental_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate rentalDate;

    @JsonProperty("return_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate returnDate;

    @JsonProperty("total_cost")
    private BigDecimal totalCost;


    // Constructors
    public RentalOrder() {
    }

    public RentalOrder(Car car, Customer customer, LocalDate rentalDate, LocalDate returnDate, BigDecimal totalCost) {
        this.car = car;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public LocalDate getRentalDate() { return rentalDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public BigDecimal getTotalCost() { return totalCost; }

    // Setters
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public void setCar(Car car) { this.car = car; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

}

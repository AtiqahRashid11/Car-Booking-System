package com.karsom.car_rental.controller;

import com.karsom.car_rental.model.*;
import com.karsom.car_rental.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class RentalOrderController {

    private final RentalOrderService service;

    @Autowired
    public RentalOrderController(RentalOrderService rentalOrderService) {
        this.service = rentalOrderService;
    }

    @GetMapping("/list")
    public List<RentalOrderDTO> getALLOrder() {
        return service.getALLOrder();
    }

    @PostMapping("/book")
    public ResponseEntity<String> bookCar(@Valid @RequestBody BookingRequest request) {
        if (request.getRentalDate() == null || request.getReturnDate() == null) {
            throw new IllegalArgumentException("Rental and return dates cannot be null");
        }

        RentalOrder order = service.createBooking(
                request.getCarId(),
                request.getCustomerId(),
                request.getRentalDate(),
                request.getReturnDate()
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Booking created with ID: " + order.getOrderId());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentalOrder(@PathVariable int id) {
        service.deleteOrder(id);
        return ResponseEntity.ok("Customer deleted successfully with ID: " + id);
    }

}

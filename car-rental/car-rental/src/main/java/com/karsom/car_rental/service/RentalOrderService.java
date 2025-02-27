package com.karsom.car_rental.service;

import com.karsom.car_rental.exception.OrderNotFoundException;
import com.karsom.car_rental.model.*;
import com.karsom.car_rental.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Lazy
public class RentalOrderService {

    private final RentalOrderRepository rentalOrderRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public RentalOrderService(RentalOrderRepository rentalOrderRepository, CarRepository carRepository, CustomerRepository customerRepository) {
        this.rentalOrderRepository = rentalOrderRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    // Method to get all order list
    public List<RentalOrderDTO> getALLOrder() {
        List<RentalOrderDTO> collect = rentalOrderRepository.findAll()
                .stream()
                .map(order -> new RentalOrderDTO(
                        order.getOrderId(),
                        new CarDTO(order.getCar().getMake(), order.getCar().getModel(), order.getCar().getAvailability(), order.getCar().getPricePerDay()),
                        new CustomerDTO(order.getCustomer().getFirstName(), order.getCustomer().getLastName(), order.getCustomer().getPhoneNumber(), order.getCustomer().getEmailAddress()),
                        order.getRentalDate(),
                        order.getReturnDate(),
                        order.getTotalCost()
                ))
                .collect(Collectors.toList());
        return collect;
    }


    // Method to create booking
    public RentalOrder createBooking(int carId, int customerId, LocalDate rentalDate, LocalDate returnDate) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found with ID: " + carId));

        if (!car.getAvailability()) {
            throw new RuntimeException("Car is not available for booking.");
        }

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        BigDecimal totalCost = car.getPricePerDay().multiply(
                new BigDecimal(rentalDate.until(returnDate).getDays())
        );

        RentalOrder order = new RentalOrder(car, customer, rentalDate, returnDate, totalCost);
        car.setAvailability(false);  // Mark car as unavailable
        carRepository.save(car); // Save updated car availability
        return rentalOrderRepository.save(order);
    }

    // Method to delete mapping
    public void deleteOrder(int id) {
        if (!rentalOrderRepository.existsById(id)) {
            throw new OrderNotFoundException("Customer not found with ID: " + id);
        } else {
            rentalOrderRepository.deleteById(id);
        }
    }

}



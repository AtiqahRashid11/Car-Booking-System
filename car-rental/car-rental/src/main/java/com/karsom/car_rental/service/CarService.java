package com.karsom.car_rental.service;

import com.karsom.car_rental.model.*;
import com.karsom.car_rental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Lazy
public class CarService {

    private final CarRepository repository;

    @Autowired
    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    // Method to fetch all of the Car Data
    public List<Car> getALLCars() {
        List<Car> cars = repository.findAll();
        System.out.println("Fetched cars: " + cars);
        return cars;
    }

    // Method to fetch limited Car Data to display for client
    public List<CarDTO> getFilteredCars() {
        return repository.findAll()
                .stream()
                .map(car -> new CarDTO(car.getMake(), car.getModel(), car.getAvailability(), car.getPricePerDay()))
                .collect(Collectors.toList());
    }
}

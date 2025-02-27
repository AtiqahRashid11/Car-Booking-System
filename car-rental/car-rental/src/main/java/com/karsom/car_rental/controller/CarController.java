package com.karsom.car_rental.controller;

import com.karsom.car_rental.model.Car;
import com.karsom.car_rental.model.CarDTO;
import com.karsom.car_rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService service;

    @Autowired
    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping("/list-explicit")
    public List<Car> getALLCars(){
        return service.getALLCars();
    }

    @GetMapping("/list")
    public List<CarDTO> getFilteredCars() {
        return service.getFilteredCars();
    }

}

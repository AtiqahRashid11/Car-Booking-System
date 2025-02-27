package com.karsom.car_rental.repository;

import com.karsom.car_rental.model.Car;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Lazy
public interface CarRepository extends JpaRepository<Car, Integer> {
}
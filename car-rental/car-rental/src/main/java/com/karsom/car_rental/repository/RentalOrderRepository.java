package com.karsom.car_rental.repository;

import com.karsom.car_rental.model.RentalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface RentalOrderRepository extends JpaRepository<RentalOrder, Integer> {
}

package com.tqsLab5.CarInformationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository=carRepository;
    }

    public Car getCarDetails(String name) {
        return  carRepository.findByName(name);
    }
}

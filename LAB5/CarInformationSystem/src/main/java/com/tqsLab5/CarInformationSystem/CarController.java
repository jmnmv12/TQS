package com.tqsLab5.CarInformationSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    //@GetMapping(path="/employees", produces = "application/json")
    @GetMapping(path="/cars/{carName}")
    public Car getCar(@PathVariable(value = "carName") String name) {
        return this.carService.getCarDetails(name);
    }

}

package com.sunny.controller;

/**
 * Created by Sunny on 7/29/2019.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.hateoas.*;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sunny.exceptions.CarNotFoundException;
import com.sunny.model.Car;
import com.sunny.repository.CarRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarRestController {
    @Autowired
    CarRepository carRepository;
    CarRestController(CarRepository repository) {
        this.carRepository = repository;
    }

    /**GET**/ //read
    @RequestMapping(value="/v1/cars", method = RequestMethod.GET)
    public @ResponseBody List getAllCars()
    {
        return (List)carRepository.findAll();
    }

    @GetMapping("/v1/cars/{id}")
    Car one (@PathVariable Long id){
        return carRepository.findById(id).
                orElseThrow(()-> new CarNotFoundException(id));
    }


    /**GET-HATEOAS**/ //read
/*  @GetMapping("/v1/carsH")
    ResponseEntity<CollectionModel<EntityModel<Car>>> findAll() {

        List<EntityModel<Car>> cars = StreamSupport.stream(carRepository.findAll().spliterator(), false)
                .map(car -> new EntityModel<>(car, //
                        linkTo(methodOn(CarRestController.class).one(car.getCarID())).withSelfRel(), //
                        linkTo(methodOn(CarRestController.class).findAll()).withRel("cars"))) //
                .collect(Collectors.toList());

        return ResponseEntity.ok( //
                new CollectionModel<>(cars, //
                        linkTo(methodOn(CarRestController.class).findAll()).withSelfRel()));
    }
*/

    /**POST**/ //create
    @PostMapping("/v1/cars")
    Car  newCar(@RequestBody Car newCar) {
        return carRepository.save(newCar);
    }

    /**PUT**/ //update
    @PutMapping("/v1/cars/{id}")
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

        return carRepository.findById(id)
                .map(car -> {//car hasn't been instantiated anywhere - works obviously with lambda
                    car.setCar_id(newCar.getCar_id());
                    //car.setCarID(newCar.getCarID());
                    //car.setCategory(newCar.getCategory());
                    car.setColor(newCar.getColor());
                    car.setLocation_id(newCar.getLocation_id());
                    //car.setMake(newCar.getMake());
                    //car.setModel(newCar.getModel());
                    //car.setNumberPlate(newCar.getNumberPlate());
                    //car.setRateUSD(newCar.getRateUSD());
                    //car.setYear(newCar.getYear());
                    return carRepository.save(car);
                })
                .orElseGet(() -> {
                    newCar.setCar_id(id);
                    //newCar.setCarID(id);
                    return carRepository.save(newCar);
                });
    }

    /**DELETE**/
    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }


}

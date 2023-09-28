package com.example.estoque.controller;

import com.example.estoque.car.Car;
import com.example.estoque.car.CarRepository;
import com.example.estoque.car.CarRequestDTO;
import com.example.estoque.car.CarResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class CarController {

    @Autowired
    private CarRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveCar(@RequestBody CarRequestDTO data){
        Car carData = new Car(data);
        repository.save(carData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<CarResponseDTO> getAll() {

        List<CarResponseDTO> carList = repository.findAll().stream().map(CarResponseDTO::new).toList();
        return carList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody CarRequestDTO data) {
        Car car = repository.findById(id).orElse(null);

        if (car != null) {
            if (data.title() != null) {
                car.title = data.title();
            }
            if (data.image() != null) {
                car.image = data.image();
            }
            if (data.price() != null) {
                car.price = data.price();
            }

            repository.save(car);
        }
    }
}
package com.example.estoque.controller;

import com.example.estoque.car.Car;
import com.example.estoque.car.CarRepository;
import com.example.estoque.car.CarRequestDTO;
import com.example.estoque.car.CarResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @PostMapping("/ZGVmYXVsdA==")
    public void defaultCar(CarRequestDTO data){
        List<Car> carsAdd = new ArrayList<>();
        carsAdd.add(new Car(null, "Porsche 911 GT3", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqWC-5lJ3Q3uUS5zTl0uSlUWIP-QFAU0yfjQ&usqp=CAU", "899.990"));
        carsAdd.add(new Car(null, "Porsche Cayenne", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXJTCr-PB5ZXSG9XhdWO_PPiiVyz_uPMGgyg&usqp=CAU", "499.990"));
        carsAdd.add(new Car(null, "Audi r8", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNxbhrqys14gvz96qb9u9vrfKL8pCUD3qDKw&usqp=CAU", "799.990"));
        carsAdd.add(new Car(null, "Ferrari 418", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSQSInM25TfD61216DNVFLIIEywqGgIjm-aog&usqp=CAU", "2.449.990"));
        repository.saveAll(carsAdd);
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
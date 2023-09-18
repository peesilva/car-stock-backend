package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PatchMapping("/{id}")
    public void updateFood(@PathVariable Long id, @RequestBody FoodRequestDTO data) {
        Food food = repository.findById(id).orElse(null);

        if (food != null) {
            // Atualizar os campos do alimento com os valores fornecidos no DTO
            if (data.title() != null) {
                food.title = data.title();
            }
            if (data.image() != null) {
                food.image = data.image();
            }
            if (data.price() != null) {
                food.price = data.price();
            }

            repository.save(food);
        }
    }
}

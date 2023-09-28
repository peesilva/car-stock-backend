package com.example.estoque.car;

public record CarResponseDTO(Long Id, String title, String image, String price) {
    public CarResponseDTO(Car car){
        this(car.getId(), car.getTitle(), car.getImage(), car.getPrice());
    }
}

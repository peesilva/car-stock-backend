package com.example.estoque.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "car")
@Entity(name = "car")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String title;
    public String image;
    public String price;

    public Car(CarRequestDTO data){
        this.image = data.image();
        this.title = data.title();
        this.price = data.price();
    }
}

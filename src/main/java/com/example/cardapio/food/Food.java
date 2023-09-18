package com.example.cardapio.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "food")
@Entity(name = "food")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String title;
    public String image;
    public String price;

    public Food(FoodRequestDTO data){
        this.image = data.image();
        this.title = data.title();
        this.price = data.price();
    }
}

package com.cookingpage.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BasicIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Long proteins;
    private Long carbohydrates;
    private Long fats;
    private Long calories;

    public BasicIngredient(String description, Long proteins, Long carbohydrates, Long fats, Long calories) {
        this.description = description;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
    }
}

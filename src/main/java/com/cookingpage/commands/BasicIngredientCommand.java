package com.cookingpage.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BasicIngredientCommand {
    private Long id;
    private Long recipeId;
    private String description;
    private Long proteins;
    private Long carbohydrates;
    private Long fats;
    private Long calories;
}

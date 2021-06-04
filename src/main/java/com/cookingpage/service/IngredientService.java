package com.cookingpage.service;

import com.cookingpage.commands.IngredientCommand;

import java.util.List;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    List<IngredientCommand> findAll();

    void deleteById(Long recipeId, Long idToDelete);
}

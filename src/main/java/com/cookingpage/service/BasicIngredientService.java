package com.cookingpage.service;

import com.cookingpage.commands.IngredientCommand;
import com.cookingpage.domain.BasicIngredient;

import java.util.List;

public interface BasicIngredientService {

    BasicIngredient saveIngredientCommand(BasicIngredient command);

    List<BasicIngredient> findAll();

    void deleteById(Long idToDelete);
}

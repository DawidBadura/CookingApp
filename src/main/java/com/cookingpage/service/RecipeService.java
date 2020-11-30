package com.cookingpage.service;

import com.cookingpage.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
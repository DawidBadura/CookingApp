package com.cookingpage.controller;

import com.cookingpage.commands.BasicIngredientCommand;
import com.cookingpage.commands.IngredientCommand;
import com.cookingpage.commands.RecipeCommand;
import com.cookingpage.commands.UnitOfMeasureCommand;
import com.cookingpage.domain.BasicIngredient;
import com.cookingpage.service.BasicIngredientService;
import com.cookingpage.service.IngredientService;
import com.cookingpage.service.RecipeService;
import com.cookingpage.service.UnitOfMeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private BasicIngredientService basicIngredientService;
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UnitOfMeasureService unitOfMeasureService;





    @GetMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }


    @GetMapping("ingredient/new")
    public String newIngredient(Model model){

        BasicIngredient ingredientCommand = new BasicIngredient();
        model.addAttribute("ingredient", ingredientCommand);


        return "addIngredient";
    }

  @PostMapping("ingredient/new")
  public String newIngredient(@ModelAttribute BasicIngredient ingredient){
      BasicIngredient savedCommand = basicIngredientService.saveIngredientCommand(ingredient);
      log.debug("saved ingredient id:" + savedCommand.getId());

      return "index";
  }
}


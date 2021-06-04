package com.cookingpage.controller;

import com.cookingpage.commands.IngredientCommand;
import com.cookingpage.commands.RecipeCommand;
import com.cookingpage.commands.UnitOfMeasureCommand;
import com.cookingpage.domain.Difficulty;
import com.cookingpage.domain.Recipe;
import com.cookingpage.service.IngredientService;
import com.cookingpage.service.RecipeService;
import com.cookingpage.service.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Set;

@Slf4j
@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UnitOfMeasureService unitOfMeasureService;
    @Autowired
    private IngredientService ingredientService;



    @GetMapping("/recipe/{id}/info")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipeInfo";
    }

    @GetMapping("recipe/recipeSet")
    public String recipeSet(Model model){
        Set<Recipe> recipeSet = recipeService.getRecipes();
        model.addAttribute("recipeSet", recipeSet);
        return "recipeList";
    }


    @GetMapping("recipe/new")

    public String newRecipe(Model model){

        RecipeCommand recipeCommand = new RecipeCommand();
        model.addAttribute("recipe", recipeCommand);
        model.addAttribute("listOfIngredients", ingredientService.findAll());


        //return "recipe/recipeform";
        return "addRecipe";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return  "recipe/recipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){

        log.debug("Deleting id: " + id);

        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}

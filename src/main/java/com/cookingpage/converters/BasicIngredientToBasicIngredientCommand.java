package com.cookingpage.converters;
import com.cookingpage.commands.BasicIngredientCommand;
import com.cookingpage.commands.IngredientCommand;
import com.cookingpage.domain.BasicIngredient;
import com.cookingpage.domain.Ingredient;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BasicIngredientToBasicIngredientCommand implements Converter<BasicIngredient, BasicIngredientCommand> {


    @Synchronized
    @Nullable
    @Override
    public BasicIngredientCommand convert(BasicIngredient basicIngredient) {
        if (basicIngredient == null) {
            return null;
        }

        BasicIngredientCommand basicIngredientCommand = new BasicIngredientCommand();
        basicIngredientCommand.setId(basicIngredient.getId());
        basicIngredientCommand.setDescription(basicIngredient.getDescription());
        basicIngredientCommand.setCalories(basicIngredient.getCalories());
        basicIngredientCommand.setProteins(basicIngredient.getProteins());
        basicIngredientCommand.setCarbohydrates(basicIngredient.getCarbohydrates());
        basicIngredientCommand.setFats(basicIngredient.getFats());
        return basicIngredientCommand;
    }
}

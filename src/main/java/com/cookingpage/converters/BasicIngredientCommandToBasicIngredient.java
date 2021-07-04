package com.cookingpage.converters;
import com.cookingpage.commands.BasicIngredientCommand;
import com.cookingpage.commands.IngredientCommand;
import com.cookingpage.domain.BasicIngredient;
import com.cookingpage.domain.Ingredient;
import com.cookingpage.domain.Recipe;
import com.sun.istack.Nullable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BasicIngredientCommandToBasicIngredient implements Converter<BasicIngredientCommand, BasicIngredient> {

    @Nullable
    @Override
    public BasicIngredient convert(BasicIngredientCommand source) {
        if (source == null) {
            return null;
        }

        final BasicIngredient basicIngredient = new BasicIngredient();
        basicIngredient.setId(source.getId());

        basicIngredient.setDescription(source.getDescription());
        basicIngredient.setCalories(source.getCalories());
        basicIngredient.setFats(source.getFats());
        basicIngredient.setProteins(source.getProteins());
        basicIngredient.setCarbohydrates(source.getCarbohydrates());
        return basicIngredient;
    }
}

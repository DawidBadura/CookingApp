package com.cookingpage.repository;

import com.cookingpage.domain.BasicIngredient;
import com.cookingpage.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BasicIngredientRepository extends CrudRepository<BasicIngredient, Long> {
    @Override
    BasicIngredient save(BasicIngredient basicIngredient);

    @Override
    Optional<BasicIngredient> findById(Long aLong);

    @Override
    List<BasicIngredient> findAll();

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}

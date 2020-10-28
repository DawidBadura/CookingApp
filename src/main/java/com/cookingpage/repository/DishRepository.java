package com.cookingpage.repository;

import com.cookingpage.domain.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long>{

}

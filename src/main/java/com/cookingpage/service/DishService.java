package com.cookingpage.service;

import com.cookingpage.domain.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {
	
	Dish save(Dish dish);

	List<Dish> findAll();

	Optional<Dish> findOne(Long id);
	
	void removeOne(Long id);
}

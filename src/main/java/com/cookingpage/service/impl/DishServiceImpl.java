package com.cookingpage.service.impl;

import com.cookingpage.domain.Dish;
import com.cookingpage.repository.DishRepository;
import com.cookingpage.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
	
	@Autowired
	private DishRepository dishRepository;
	
	public Dish save(Dish dish) {
		return dishRepository.save(dish);
	}
	
	public List<Dish> findAll() {
		return (List<Dish>) dishRepository.findAll();
	}
	
	public Optional<Dish> findOne(Long id) {
		return dishRepository.findById(id);
	}
	
	public void removeOne(Long id) {
		dishRepository.deleteById(id);
	}
}

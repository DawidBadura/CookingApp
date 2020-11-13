package com.cookingpage.controller;

import com.cookingpage.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ResourceController {

	@Autowired
	private DishService dishService;
	
	@RequestMapping(value="/dish/removeList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> dishIdList, Model model
			){
		
		for (String id : dishIdList) {
			String dishId = id.substring(8);
			dishService.removeOne(Long.parseLong(dishId));
		}
		
		return "delete success";
	}
}

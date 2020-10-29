package com.cookingpage.controller;

import com.cookingpage.domain.Dish;
import com.cookingpage.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {

	@Autowired
	private DishService dishService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addDish(Model model) {
		Dish dish = new Dish();
		model.addAttribute("dish", dish);
		return "addDish";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDishPost(@ModelAttribute("dish") Dish dish, HttpServletRequest request) {
		dishService.save(dish);

		MultipartFile dishImage = dish.getDishImage();

		try {
			byte[] bytes = dishImage.getBytes();
			String name = dish.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/dish/" + name)));
			stream.write(bytes);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:dishList";
	}
	
	@RequestMapping("/dishInfo")
	public String dishInfo(@RequestParam("id") Long id, Model model) throws Exception {
		Dish dish = dishService.findOne(id).orElseThrow(Exception::new);
		model.addAttribute("dish", dish);
		
		return "dishInfo";
	}
	
	@RequestMapping("/updateDish")
	public String updateDish(@RequestParam("id") Long id, Model model) throws Exception {
		Dish dish = dishService.findOne(id).orElseThrow(Exception::new);
		model.addAttribute("dish", dish);
		
		return "updateDish";
	}
	
	@RequestMapping(value="/updateDish", method=RequestMethod.POST)
	public String updateDishPost(@ModelAttribute("dish") Dish dish, HttpServletRequest request) {
		dishService.save(dish);
		
		MultipartFile dishImage = dish.getDishImage();
		
		if(!dishImage.isEmpty()) {
			try {
				byte[] bytes = dishImage.getBytes();
				String name = dish.getId() + ".png";
				
				Files.delete(Paths.get("src/main/resources/static/image/dish/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/image/dish/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return "redirect:/dish/dishInfo?id="+dish.getId();
	}
	
	@RequestMapping("/dishList")
	public String dishList(Model model) {
		List<Dish> dishList = dishService.findAll();
		model.addAttribute("dishList", dishList);
		return "dishList";
		
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		dishService.removeOne(Long.parseLong(id.substring(8)));
		List<Dish> dishList = dishService.findAll();
		model.addAttribute("dishList", dishList);
		
		return "redirect:/dish/dishList";
	}

}

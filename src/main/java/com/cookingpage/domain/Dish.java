package com.cookingpage.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String receipe;
	private String ingredients;

	@Column(columnDefinition = "text")
	private String description;

	@Transient
	private MultipartFile dishImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReceipe() {
		return receipe;
	}

	public void setReceipe(String receipe) {
		this.receipe = receipe;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingridences) {
		this.ingredients = ingridences;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getDishImage() {
		return dishImage;
	}

	public void setDishImage(MultipartFile dishImage) {
		this.dishImage = dishImage;
	}
}

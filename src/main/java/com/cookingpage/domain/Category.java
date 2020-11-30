package com.cookingpage.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long Id;

    private String description;

    @ManyToMany(mappedBy = "categorySet")
    private Set<Recipe> recipeSet;
}

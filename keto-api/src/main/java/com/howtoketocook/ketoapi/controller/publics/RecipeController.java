package com.howtoketocook.ketoapi.controller.publics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtoketocook.ketoapi.model.Recipe;
import com.howtoketocook.ketoapi.service.recipe.RecipeService;

@RestController
@RequestMapping("/api/public/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;	
	
	@GetMapping
	public List<Recipe> getAll(){
		return recipeService.getAll();
	}
}

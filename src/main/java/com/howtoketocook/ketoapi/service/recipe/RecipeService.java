package com.howtoketocook.ketoapi.service.recipe;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.model.Recipe;
import com.howtoketocook.ketoapi.request.RecipeRequest;

@Service
public class RecipeService {
	private static Logger logger = LoggerFactory.getLogger(RecipeService.class);
	
	@Autowired
	private RecipeRepository recipeRepository;

	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	public Recipe getRecipeById(long id) {	
		return recipeRepository.findById(id).orElseGet(null);
	}

	public void addRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
}

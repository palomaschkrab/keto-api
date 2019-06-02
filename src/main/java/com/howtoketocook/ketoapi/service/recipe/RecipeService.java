package com.howtoketocook.ketoapi.service.recipe;

import java.util.List;

import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.helper.RecipeJsonReader;
import com.howtoketocook.ketoapi.model.Recipe;

@Service
public class RecipeService {
	
	public List<Recipe> getAll() {
		return RecipeJsonReader.getRecipesFromResources();
	}
	
	public Recipe getRecipeById(long id) {
		for(Recipe recipe: RecipeJsonReader.getRecipesFromResources()) {
			if(recipe.getId() == id)
				return recipe;
		}
		return null;
	}
	
}

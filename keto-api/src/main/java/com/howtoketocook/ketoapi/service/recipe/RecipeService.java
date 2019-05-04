package com.howtoketocook.ketoapi.service.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.enums.IngredientUnit;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.Recipe;

@Service
public class RecipeService {
	
	private List<Recipe> recipes;
	
	public RecipeService() {
		init();
	}	
	
	//to replace database at the beginning
	private void init() {
		recipes = new ArrayList<Recipe>();
		Recipe recipe = Recipe.builder()
				.name("Boiled Egg")
				.cookingTime(15)
				.prepTime(5)
				.portions(1)
				.ingredients(boiledEggIngredients())
				.instructions("test")
				.build();
		recipes.add(recipe);
	}
	
	private List<Ingredient> boiledEggIngredients() {
		Ingredient egg = Ingredient.builder()
				.name("egg")
				.quantity(3)
				.unit(IngredientUnit.UNIT)
				.build();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(egg);		
		return ingredients;
	}


	public List<Recipe> getAll() {
		return recipes;
	}
	
}

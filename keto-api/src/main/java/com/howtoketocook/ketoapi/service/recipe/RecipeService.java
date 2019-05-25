package com.howtoketocook.ketoapi.service.recipe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.enums.IngredientUnit;
import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.MacroNutrients;
import com.howtoketocook.ketoapi.model.Recipe;
import com.howtoketocook.ketoapi.model.Recipe.RecipeBuilder;

@Service
public class RecipeService {
	
	private List<Recipe> recipes;
	
	public RecipeService() {
		init();
	}	
	
	//to replace database at the beginning
	private void init() {
		recipes = new ArrayList<Recipe>();
		RecipeBuilder recipe = Recipe.builder()
				.name("Boiled Egg")
				.cookingTime(15)
				.prepTime(5)
				.portions(1)
				.ingredients(boiledEggIngredients())
				.instructions("test")
				.image(boiledEggImage())
				.macronutrients(boiledEggsMacronutrients());
		
		for(int i = 0; i <= 50; i++) {
			recipe.id(i);
			recipes.add(recipe.build());
		}
		
		
	}

	private Image boiledEggImage() {
		return Image.builder()
				.id(1)
				.url("https://as1.ftcdn.net/jpg/02/05/95/12/500_F_205951292_Grw3fa2P4h7oCDgrXJJVkzIhzHHRj60q.jpg")
				.build();
	}
	
	private List<Ingredient> boiledEggIngredients() {
		Ingredient egg = Ingredient.builder()
				.name("egg")
				.quantity(3)
				.unit(IngredientUnit.UNIT)
				.build();
		Ingredient water = Ingredient.builder()
				.name("water")
				.quantity(0.5)
				.unit(IngredientUnit.LITERS)
				.build();
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		ingredients.add(egg);		
		ingredients.add(water);
		return ingredients;
	}
	private MacroNutrients boiledEggsMacronutrients() {
		return MacroNutrients.builder()
				.carbs(1.8)
				.fat(15)
				.protein(18)
				.build();
	}

	public List<Recipe> getAll() {
		return recipes;
	}
	
	public Recipe getRecipeById(long id) {
		for(Recipe recipe: recipes) {
			if(recipe.getId() == id)
				return recipe;
		}
		return null;
	}
	
}

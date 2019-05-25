package com.howtoketocook.ketoapi.response;

import java.util.List;

import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.MacroNutrients;
import com.howtoketocook.ketoapi.model.Recipe;

import lombok.Getter;

@Getter
public class RecipeResponse {
	private long id;	
	private String name;
	private long cookingTime;
	private long prepTime;
	private int portions;
	private List<Ingredient> ingredients;
	private String instructions;
	private String imageUrl;
	private MacroNutrients macronutrients;
	
	public RecipeResponse(Recipe recipe) {
		id = recipe.getId();
		name = recipe.getName();
		cookingTime = recipe.getCookingTime();
		prepTime = recipe.getPrepTime();
		portions = recipe.getPortions();
		ingredients = recipe.getIngredients();
		instructions = recipe.getInstructions();
		imageUrl = recipe.getImage().getUrl();
		macronutrients = recipe.getMacronutrients();
	}
}

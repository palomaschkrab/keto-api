package com.howtoketocook.ketoapi.response;

import java.util.ArrayList;
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
	private long portions;
	private List<IngredientResponse> ingredients;
	private String instructions;
	private String imageUrl;
	private MacroNutrients macronutrients;
	private String additionalInfo;
	
	public RecipeResponse(Recipe recipe) {
		id = recipe.getId();
		name = recipe.getName();
		cookingTime = recipe.getCookingTime();
		prepTime = recipe.getPrepTime();
		portions = recipe.getPortions();
		ingredients = getIngredientsResponse(recipe.getIngredients());
		instructions = recipe.getInstructions();
		imageUrl = recipe.getImage().getUrl();
		macronutrients = recipe.getMacronutrients();
		additionalInfo = recipe.getAdditionalInfo();
	}
	
	public List<IngredientResponse> getIngredientsResponse (List<Ingredient> ingredients){
		List<IngredientResponse> ingredientsResponse = new ArrayList<>();
		for(Ingredient ingredient: ingredients) {
			ingredientsResponse.add(new IngredientResponse(ingredient));
		}
		return ingredientsResponse;
	}
}

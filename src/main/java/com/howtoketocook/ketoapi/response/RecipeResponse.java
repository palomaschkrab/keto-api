package com.howtoketocook.ketoapi.response;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.Instruction;
import com.howtoketocook.ketoapi.model.MacroNutrients;
import com.howtoketocook.ketoapi.model.Recipe;
import com.howtoketocook.ketoapi.model.RecipeIngredient;

import lombok.Getter;

@Getter
public class RecipeResponse {
	private long id;
	private String urlId;
	private String name;
	private long cookingTime;
	private long prepTime;
	private long portions;
	private List<IngredientResponse> ingredients;
	private List<InstructionResponse> instructions;
	private String note;
	private String imageUrl;
	private MacronutrientsResponse macronutrients;
	private String additionalInfo;
	
	public RecipeResponse(Recipe recipe) {
		id = recipe.getId();
		urlId = recipe.getUrlId();
		name = recipe.getName();
		cookingTime = recipe.getCookingTime();
		prepTime = recipe.getPrepTime();
		portions = recipe.getPortions();
		ingredients = getIngredientsResponse(recipe.getRecipeIngredients());
		instructions = getInstructionResponse(recipe.getInstructions());
		note = recipe.getNote();
		imageUrl = getFirstImageUrl(recipe.getImages());
		macronutrients = new MacronutrientsResponse(recipe.getMacronutrients());
		additionalInfo = recipe.getAdditionalInfo();
	}
	
	public List<IngredientResponse> getIngredientsResponse (Set<RecipeIngredient> recipeIngredients){
		List<IngredientResponse> ingredientsResponse = new ArrayList<>();
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<>(recipeIngredients);
		recipeIngredientsList.sort(Comparator.comparing(RecipeIngredient::getIndex));
		for(RecipeIngredient recipeIngredient: recipeIngredientsList) {
			ingredientsResponse.add(new IngredientResponse(recipeIngredient));
		}
		
		return ingredientsResponse;
	}
	
	public List<InstructionResponse> getInstructionResponse(Set<Instruction> instructions){
		List<InstructionResponse> instructionsResponse = new ArrayList<>();

		for(Instruction instruction: instructions) {
			instructionsResponse.add(new InstructionResponse(instruction));
		}
		
		instructionsResponse.sort(Comparator.comparing(InstructionResponse::getIndex));
		return instructionsResponse;
	}
	public String getFirstImageUrl(Set<Image> images) {
		return images.iterator().next().getUrl();
	}
	
}

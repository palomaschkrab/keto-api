package com.howtoketocook.ketoapi.service.facade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.Instruction;
import com.howtoketocook.ketoapi.model.Recipe;
import com.howtoketocook.ketoapi.model.RecipeIngredient;
import com.howtoketocook.ketoapi.request.ImageRequest;
import com.howtoketocook.ketoapi.request.InstructionRequest;
import com.howtoketocook.ketoapi.request.RecipeIngredientRequest;
import com.howtoketocook.ketoapi.request.RecipeRequest;
import com.howtoketocook.ketoapi.service.ingredient.IngredientService;
import com.howtoketocook.ketoapi.service.recipe.RecipeService;

@Service
public class RecipeFacade {
	
	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private RecipeService recipeService;
	
	public List<Recipe> getAllRecipes() {
		return recipeService.getAllRecipes();
	}
	
	public Recipe getRecipeById(long id) {	
		return recipeService.getRecipeById(id);
	}
	
	public void addRecipe(RecipeRequest recipeRequest) {
		recipeService.addRecipe(toRecipe(recipeRequest));
	}
	
	public Ingredient getIngredientByName(String name) {	
		return ingredientService.getIngredientByName(name);
	}
	
	public Ingredient getIngredientById(long id) {	
		return ingredientService.getIngredientById(id);
	}
	//create addIngredient
	private Recipe toRecipe(RecipeRequest recipeRequest) {
		Recipe recipe = Recipe.builder()
				.name((String) recipeRequest.getName())
				.cookingTime((Long) recipeRequest.getCookingTime())
				.prepTime((Long) recipeRequest.getPrepTime())
				.portions((Long) recipeRequest.getPortions())
				.recipeIngredients(getIngredientsSet(recipeRequest.getRecipeIngredientsRequests()))
				.instructions(getInstructionSet(recipeRequest.getInstructionRequests()))
				.images(getImages(recipeRequest.getImageRequests()))
				.macronutrients(recipeRequest.getMacronutrientsRequests().toMacroNutrients())
				.additionalInfo((String) recipeRequest.getAdditionalInfo())
				.build();
		return recipe;
	}
	
	private Set<Instruction> getInstructionSet(Set<InstructionRequest> instructionRequests){
		Set<Instruction> instructions = new HashSet<Instruction>();
		for(InstructionRequest instructionRequest: instructionRequests ) {
			instructions.add(getInstruction(instructionRequest));
		}		
		return instructions;
	}
	
	private Instruction getInstruction(InstructionRequest instructionRequest) {
		return Instruction.builder()
		.index(instructionRequest.getIndex())
		.step(instructionRequest.getStep())
		.build();		
	}
	
	private Set<Image> getImages(Set<ImageRequest> imageRequests) {
		Set<Image> images = new HashSet<Image>();
		for(ImageRequest image: imageRequests) {
			images.add(
						Image.builder()
						.url(image.getUrl())
						.description(image.getDescription())
						.build()
					);
		}		
		return images;
	}
	
	private Set<RecipeIngredient> getIngredientsSet(Set<RecipeIngredientRequest> ingredientRequests){
		Set<RecipeIngredient> recipeIngredients = new HashSet<RecipeIngredient>();
		for(RecipeIngredientRequest recipeIngredientRequest: ingredientRequests ) {
			recipeIngredients.add(getRecipeIngredient(recipeIngredientRequest));
		}		
		return recipeIngredients;
	}
	
	private RecipeIngredient getRecipeIngredient(RecipeIngredientRequest recipeIngredientRequest) {
		return RecipeIngredient.builder()
				.ingredient(ingredientService.getIngredientByName(recipeIngredientRequest.getIngredientRequest().getName()))
			.quantity(recipeIngredientRequest.getQuantity())
			.unit(recipeIngredientRequest.getUnit())
			.index(recipeIngredientRequest.getIndex())
			.build();		
	}

}

package com.howtoketocook.ketoapi.request;

import java.util.HashSet;
import java.util.Set;

import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Instruction;
import com.howtoketocook.ketoapi.model.Recipe;
import com.howtoketocook.ketoapi.model.RecipeIngredient;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RecipeRequest {
	private String name;
	private long cookingTime;
	private long prepTime;
	private long portions;
	private Set<RecipeIngredientRequest> recipeIngredientsRequests;
	private Set<InstructionRequest> instructionRequests;
	private String note;
	private Set<ImageRequest> imageRequests;
	private MacroNutrientsRequest macronutrientsRequests;
	private String additionalInfo;
	private boolean approved;
	
	public Recipe toRecipe() {
		Recipe recipe = Recipe.builder()
				.name((String) this.getName())
				.cookingTime((Long) this.getCookingTime())
				.prepTime((Long) this.getPrepTime())
				.portions((Long) this.getPortions())
				.recipeIngredients(getIngredientsSet(this.getRecipeIngredientsRequests()))
				.instructions(getInstructionSet(this.getInstructionRequests()))
				.images(getImages(this.getImageRequests()))
				.macronutrients(this.getMacronutrientsRequests().toMacroNutrients())
				.additionalInfo((String) this.getAdditionalInfo())
				.build();
		return recipe;
	}
	
	public Set<RecipeIngredient> getIngredientsSet(Set<RecipeIngredientRequest> ingredientRequests){
		Set<RecipeIngredient> ingredients = new HashSet<RecipeIngredient>();
		for(RecipeIngredientRequest recipeIngredientRequest: ingredientRequests ) {
			ingredients.add(getIngredient(recipeIngredientRequest));
			System.out.println("INGREDIENT'S NAME: "+recipeIngredientRequest.getIngredientRequest().getName());
		}		
		return ingredients;
	}
	
	public RecipeIngredient getIngredient(RecipeIngredientRequest recipeIngredientRequest) {
		return RecipeIngredient.builder()
			.ingredient((recipeIngredientRequest.getIngredientRequest()).toIngredient())
			.quantity(recipeIngredientRequest.getQuantity())
			.unit(recipeIngredientRequest.getUnit())
			.build();		
	}
	
	public Set<Instruction> getInstructionSet(Set<InstructionRequest> instructionRequests){
		Set<Instruction> instructions = new HashSet<Instruction>();
		for(InstructionRequest instructionRequest: instructionRequests ) {
			instructions.add(getInstruction(instructionRequest));
		}		
		return instructions;
	}
	
	
	public Instruction getInstruction(InstructionRequest instructionRequest) {
		return Instruction.builder()
		.index(instructionRequest.getIndex())
		.step(instructionRequest.getStep())
		.build();		
	}
	
	public Set<Image> getImages(Set<ImageRequest> imageRequests) {
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
}

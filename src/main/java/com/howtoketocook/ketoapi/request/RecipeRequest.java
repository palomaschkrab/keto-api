package com.howtoketocook.ketoapi.request;

import java.util.Set;

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
}

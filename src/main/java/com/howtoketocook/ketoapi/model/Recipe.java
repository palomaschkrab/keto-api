package com.howtoketocook.ketoapi.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Recipe {
	private long id;	
	private String name;
	private long cookingTime;
	private long prepTime;
	private long portions;
	private List<Ingredient> ingredients;
	private String instructions;
	private Image image;
	private MacroNutrients macronutrients;
	private String additionalInfo;
}

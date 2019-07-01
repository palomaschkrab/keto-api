package com.howtoketocook.ketoapi.request;

import com.howtoketocook.ketoapi.enums.IngredientUnit;

import lombok.Getter;

@Getter
public class RecipeIngredientRequest {
	private Long index;
	private IngredientRequest ingredientRequest;
	private int whole;
	private int numerator;
	private int denominator;
	private IngredientUnit unit;
}

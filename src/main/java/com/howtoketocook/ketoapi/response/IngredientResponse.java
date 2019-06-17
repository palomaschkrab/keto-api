package com.howtoketocook.ketoapi.response;

import com.howtoketocook.ketoapi.converter.IngredientUnitConverter;
import com.howtoketocook.ketoapi.converter.QuantityConverter;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.RecipeIngredient;

import lombok.Getter;

@Getter
public class IngredientResponse {
	private String name;
	private String quantity;
	private String unit;
	
	public IngredientResponse(RecipeIngredient ingredient) {
		name = ingredient.getIngredient().getName();
		quantity = QuantityConverter.converQuantitytToFraction(ingredient.getQuantity());
		unit = IngredientUnitConverter.convertIngredientUnitToDisplay(ingredient.getUnit());
	}
}

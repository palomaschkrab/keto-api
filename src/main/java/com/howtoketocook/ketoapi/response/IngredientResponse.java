package com.howtoketocook.ketoapi.response;

import com.howtoketocook.ketoapi.converter.IngredientUnitConverter;
import com.howtoketocook.ketoapi.converter.QuantityConverter;
import com.howtoketocook.ketoapi.model.RecipeIngredient;

import lombok.Getter;

@Getter
public class IngredientResponse {
	private String name;
	private String quantity;
	private String unit;
	
	public IngredientResponse(RecipeIngredient ingredient) {
		name = ingredient.getIngredient().getName();
		quantity = QuantityConverter.convertFractionToString(ingredient.getWhole(), ingredient.getNumerator(), ingredient.getDenominator());
		unit = IngredientUnitConverter.convertIngredientUnitToDisplay(ingredient.getWhole(), ingredient.getUnit());
	}
}

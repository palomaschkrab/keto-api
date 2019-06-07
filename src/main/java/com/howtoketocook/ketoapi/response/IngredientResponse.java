package com.howtoketocook.ketoapi.response;

import com.howtoketocook.ketoapi.converter.IngredientUnitConverter;
import com.howtoketocook.ketoapi.converter.QuantityConverter;
import com.howtoketocook.ketoapi.model.Ingredient;

import lombok.Getter;

@Getter
public class IngredientResponse {
	private String name;
	private String quantity;
	private String unit;
	
	public IngredientResponse(Ingredient ingredient) {
		name = ingredient.getName();
		quantity = QuantityConverter.converQuantitytToFraction(ingredient.getQuantity());
		unit = IngredientUnitConverter.convertIngredientUnitToDisplay(ingredient.getUnit());
	}
}

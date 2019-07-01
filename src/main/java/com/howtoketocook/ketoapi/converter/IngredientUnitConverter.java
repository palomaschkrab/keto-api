package com.howtoketocook.ketoapi.converter;

import com.howtoketocook.ketoapi.enums.IngredientUnit;

public class IngredientUnitConverter {
	public static String convertIngredientUnitToDisplay(int whole, IngredientUnit ingredientUnit) {
		if(ingredientUnit == IngredientUnit.NONE || ingredientUnit == IngredientUnit.UNIT ) {
			if(whole > 1) {
				return ingredientUnit + "s";
			}
			return "";
		}else if(ingredientUnit == IngredientUnit.TABLE_SPOON) {
			return "tbs of ";
		}else if(ingredientUnit == IngredientUnit.TEA_SPOON) {
			return "tsp of ";
		}
		
		if(whole > 1) {
			return ingredientUnit + "s of ";
		}
		return ingredientUnit + " of ";
	}
}

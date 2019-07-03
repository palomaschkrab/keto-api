package com.howtoketocook.ketoapi.converter;

import com.howtoketocook.ketoapi.enums.IngredientUnit;

public class IngredientUnitConverter {
	public static String convertIngredientUnitToDisplay(int whole, IngredientUnit ingredientUnit) {
		if(ingredientUnit == IngredientUnit.NONE || ingredientUnit == IngredientUnit.UNIT ) {
			return "";
		}else if(ingredientUnit == IngredientUnit.TABLE_SPOON) {
			return "tbs of ";
		}else if(ingredientUnit == IngredientUnit.TEA_SPOON) {
			return "tsp of ";
		}else if(ingredientUnit == IngredientUnit.PINCH && whole > 1) {
			return ingredientUnit + "es of ";
		}
		
		if(whole > 1) {
			return ingredientUnit + "s of ";
		}
		return ingredientUnit + " of ";
	}
}

package com.howtoketocook.ketoapi.converter;

import com.howtoketocook.ketoapi.enums.IngredientUnit;

public class IngredientUnitConverter {
	public static String convertIngredientUnitToDisplay(IngredientUnit ingredientUnit) {
		if(ingredientUnit == IngredientUnit.NONE || ingredientUnit == IngredientUnit.UNIT ) {
			return "";
		}else if(ingredientUnit == IngredientUnit.TABLE_SPOON) {
			return "tbs(s) of ";
		}else if(ingredientUnit == IngredientUnit.TEA_SPOON) {
			return "tsp(s) of ";
		}
		return ingredientUnit + "(s) of ";
	}
}

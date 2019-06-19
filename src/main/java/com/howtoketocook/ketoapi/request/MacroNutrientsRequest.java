package com.howtoketocook.ketoapi.request;

import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.MacroNutrients;

public class MacroNutrientsRequest {
	private double carbs;
	private double fat;
	private double protein;
	
	public MacroNutrients toMacroNutrients() {
		return MacroNutrients.builder()
				.carbs(this.carbs)
				.fat(this.fat)
				.protein(this.protein)
				.build();
	}
}

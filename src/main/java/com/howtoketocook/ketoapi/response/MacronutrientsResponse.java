package com.howtoketocook.ketoapi.response;

import com.howtoketocook.ketoapi.converter.MacronutientsConverter;
import com.howtoketocook.ketoapi.model.MacroNutrients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MacronutrientsResponse {
	private Long id;
	private String carbs;
	private String fat;
	private String protein;
	
	public MacronutrientsResponse(MacroNutrients macros) {
		this.id = macros.getId();
		this.carbs = MacronutientsConverter.convertToStringNotAvailable(macros.getCarbs());
		this.fat = MacronutientsConverter.convertToStringNotAvailable(macros.getFat());
		this.protein = MacronutientsConverter.convertToStringNotAvailable(macros.getProtein());
	}
	
}

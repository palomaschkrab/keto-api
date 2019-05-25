package com.howtoketocook.ketoapi.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MacroNutrients {
	private double carbs;
	private double fat;
	private double protein;
}

package com.howtoketocook.ketoapi.model;

import com.howtoketocook.ketoapi.enums.IngredientUnit;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Ingredient {
	private String name;
	private double quantity;
	private IngredientUnit unit;
}

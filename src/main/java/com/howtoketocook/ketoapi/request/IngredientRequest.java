package com.howtoketocook.ketoapi.request;

import com.howtoketocook.ketoapi.model.Ingredient;

import lombok.Getter;

@Getter
public class IngredientRequest {
	private String name;
	private String amazonUrl;
	
	public Ingredient toIngredient() {
		return Ingredient.builder()
				.name(this.name)
				.amazonUrl(this.amazonUrl)
				.build();
	}
}

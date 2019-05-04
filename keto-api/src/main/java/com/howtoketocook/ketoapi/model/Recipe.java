package com.howtoketocook.ketoapi.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Recipe {
	private String name;
	private long cookingTime;
	private long prepTime;
	private int portions;
	private List<Ingredient> ingredients;
	private String instructions;
	
}

package com.howtoketocoook.ketoapi.service.ingredient;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.howtoketocook.ketoapi.converter.IngredientUnitConverter;
import com.howtoketocook.ketoapi.enums.IngredientUnit;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.service.ingredient.IngredientService;

public class IngredientServiceTest {
	
	private final IngredientService ingredientService;
	
	public IngredientServiceTest() {
		ingredientService = new IngredientService();
	}
	
	
	@Test
	public void test_ingredient_service_almond_flour() {
		Ingredient ingredient = ingredientService.getIngredientById(1);
		assertThat(ingredient).isNotNull();
	}
}

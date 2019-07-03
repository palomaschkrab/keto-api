package com.howtoketocoook.ketoapi.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.howtoketocook.ketoapi.converter.IngredientUnitConverter;
import com.howtoketocook.ketoapi.enums.IngredientUnit;


public class IngredientUnitConverterTest {

	@Test
	public void test_ingredient_unit_converter_none() {
		String expectedResult = "";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.NONE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_unit() {
		String expectedResult = "";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.UNIT);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_table_spoon() {
		String expectedResult = "tbs of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.TABLE_SPOON);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_table_spoon() {
		String expectedResult = "tbs of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.TABLE_SPOON);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_tea_spoon() {
		String expectedResult = "tsp of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.TEA_SPOON);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_tea_spoon() {
		String expectedResult = "tsp of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.TEA_SPOON);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_cups() {
		String expectedResult = "cups of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.CUP);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_cup() {
		String expectedResult = "cup of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.CUP);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_cloves() {
		String expectedResult = "cloves of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.CLOVE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_clove() {
		String expectedResult = "clove of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.CLOVE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_drops() {
		String expectedResult = "drops of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.DROP);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_drop() {
		String expectedResult = "drop of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.DROP);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_grams() {
		String expectedResult = "grams of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.GRAM);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_gram() {
		String expectedResult = "gram of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.GRAM);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_kilograms() {
		String expectedResult = "kilograms of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.KILOGRAM);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_kilogram() {
		String expectedResult = "kilogram of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.KILOGRAM);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_liters() {
		String expectedResult = "liters of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.LITER);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_liter() {
		String expectedResult = "liter of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.LITER);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_milliliter() {
		String expectedResult = "milliliters of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.MILLILITER);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_milliliter() {
		String expectedResult = "milliliter of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.MILLILITER);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_ounces() {
		String expectedResult = "ounces of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.OUNCE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_ounce() {
		String expectedResult = "ounce of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.OUNCE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_pinches() {
		String expectedResult = "pinches of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.PINCH);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_pinch() {
		String expectedResult = "pinch of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.PINCH);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_pounds() {
		String expectedResult = "pounds of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.POUND);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_pound() {
		String expectedResult = "pound of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.POUND);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_2_slices() {
		String expectedResult = "slices of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(2, IngredientUnit.SLICE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_ingredient_unit_converter_1_slice() {
		String expectedResult = "slice of ";
		
		String result = IngredientUnitConverter.convertIngredientUnitToDisplay(1, IngredientUnit.SLICE);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	
}

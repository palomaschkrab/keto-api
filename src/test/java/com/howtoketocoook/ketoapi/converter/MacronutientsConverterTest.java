package com.howtoketocoook.ketoapi.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.howtoketocook.ketoapi.converter.MacronutientsConverter;

public class MacronutientsConverterTest {

	@Test
	public void test_macronutrients_converter_n_a() {
		String expectedResult = "n/a";
		
		String result = MacronutientsConverter.convertToStringNotAvailable(0.0);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_macronutrients_converter_1_8() {
		String expectedResult = "1.8";
		
		String result = MacronutientsConverter.convertToStringNotAvailable(1.8);
		assertThat(result).isEqualTo(expectedResult);
	}
}

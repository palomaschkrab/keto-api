package com.howtoketocoook.ketoapi.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.howtoketocook.ketoapi.converter.QuantityConverter;

public class QuantityConverterTest {
	
	@Test
	public void test_quantity_converter_1_3() {
		String expectedResult = "1/3";
		
		String result = QuantityConverter.convertFractionToString(0, 1, 3);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_quantity_converter_0_25() {
		String expectedResult = "1/4";
		
		String result = QuantityConverter.convertFractionToString(0, 1, 4);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_quantity_converter_1_5() {
		String expectedResult = "1 1/2";
		
		String result = QuantityConverter.convertFractionToString(1, 1, 2);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_quantity_converter_2() {
		String expectedResult = "2";
		
		String result = QuantityConverter.convertFractionToString(2, 0, 0);
		assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	public void test_quantity_converter_2_5() {
		String expectedResult = "2/5";
		
		String result = QuantityConverter.convertFractionToString(0, 2, 5);
		assertThat(result).isEqualTo(expectedResult);
	}

}

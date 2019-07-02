package com.howtoketocook.ketoapi.converter;

public class QuantityConverter {

	public static String convertFractionToString(int whole, int numerator, int denominator) {
		if(whole == 0) {
			if(numerator !=0) {
				return numerator + "/" + denominator;
			}
			return "";
		}
		
		if(numerator == 0) {
			return String.valueOf(whole);
		}		
		
		return whole + " " + numerator + "/" + denominator;
	}
}

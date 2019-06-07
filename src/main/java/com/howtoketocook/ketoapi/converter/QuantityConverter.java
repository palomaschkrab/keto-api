package com.howtoketocook.ketoapi.converter;

public class QuantityConverter {
	private int numerator;
	private int denominator;
	
	public static String converQuantitytToFraction(double quantity) {
        String stringNumber = String.valueOf(quantity);
        int numberDigitsDecimals = stringNumber.length() - 1 - stringNumber.indexOf('.');
        int denominator = 1;
        for (int i = 0; i < numberDigitsDecimals; i++) {
            quantity *= 10;
            denominator *= 10;
        }

       int numerator = (int) Math.round(quantity);
       int greatestCommonFactor = greatestCommonFactor(numerator, denominator);
       numerator = numerator / greatestCommonFactor;
       denominator = denominator / greatestCommonFactor;
       if(denominator == 1) {
    	   if(numerator ==0) {
    		   return "";
    	   }
    	   return String.valueOf(numerator);
       }
       return numerator + "/" + denominator;
    }

    public static int greatestCommonFactor(int num, int denom) {
        if (denom == 0) {
            return num;
        }
        return greatestCommonFactor(denom, num % denom);
    }
}

package com.howtoketocook.ketoapi.converter;

public class MacronutientsConverter {
	public static String convertToStringNotAvailable(double macro) {
		String response; 
		if(macro == 0.0) {
			response = "n/a";			
		}else {
			response = "" + macro;	
		}
		return response;
	}

}

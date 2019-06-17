package com.howtoketocook.ketoapi.converter;

import com.howtoketocook.ketoapi.model.MacroNutrients;
import com.howtoketocook.ketoapi.response.MacronutrientsResponse;

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

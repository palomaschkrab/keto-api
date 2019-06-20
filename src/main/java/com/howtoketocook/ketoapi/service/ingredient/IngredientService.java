package com.howtoketocook.ketoapi.service.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.model.Ingredient;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public Ingredient getIngredientByName(String name) {	
		return ingredientRepository.findByNameIgnoreCase(name).orElseThrow();
	}
	
	public Ingredient getIngredientById(long id) {	
		return ingredientRepository.findById(id).orElseGet(null);
	}

}

package com.howtoketocook.ketoapi.service.ingredient;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtoketocook.ketoapi.model.Ingredient;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	public Ingredient getIngredientByName(String name) {
		Optional<Ingredient> ingredient = ingredientRepository.findByNameIgnoreCase(name);
		if(ingredient.isPresent()) {
			return ingredient.get();
		}
		throw new NoSuchElementException("No value present");
	}
	
	public Ingredient getIngredientById(long id) {	
		return ingredientRepository.findById(id).orElseGet(null);
	}

}

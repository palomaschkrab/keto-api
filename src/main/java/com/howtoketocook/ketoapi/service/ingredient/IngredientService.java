package com.howtoketocook.ketoapi.service.ingredient;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.service.recipe.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IngredientService {
	
	private final IngredientRepository ingredientRepository;
	
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

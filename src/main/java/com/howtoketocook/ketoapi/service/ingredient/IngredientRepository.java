package com.howtoketocook.ketoapi.service.ingredient;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtoketocook.ketoapi.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long>{

	public Optional<Ingredient> findByNameIgnoreCase(String name);
	
}

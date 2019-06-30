package com.howtoketocook.ketoapi.service.recipe;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.howtoketocook.ketoapi.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{

	Optional<Recipe> findByUrlId(String urlId);
}

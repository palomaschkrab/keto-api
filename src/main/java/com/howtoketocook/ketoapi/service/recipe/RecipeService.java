package com.howtoketocook.ketoapi.service.recipe;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howtoketocook.ketoapi.model.Recipe;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecipeService {
	private static Logger logger = LoggerFactory.getLogger(RecipeService.class);
	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

	
	private final RecipeRepository recipeRepository;

	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	public Recipe getRecipeByUrlId(String urlId) {	
		return recipeRepository.findByUrlId(urlId).orElseGet(null);
	}

	public void addRecipe(Recipe recipe) {
		recipeRepository.save(recipe);
	}
	
	public String toSlug(String name) {
	    String nowhitespace = WHITESPACE.matcher(name).replaceAll("-");
	    String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
	    return slug.toLowerCase(Locale.ENGLISH);
	}
}

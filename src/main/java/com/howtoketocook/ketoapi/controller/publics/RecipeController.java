package com.howtoketocook.ketoapi.controller.publics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtoketocook.ketoapi.converter.RecipeConverter;
import com.howtoketocook.ketoapi.request.RecipeRequest;
import com.howtoketocook.ketoapi.response.RecipeResponse;
import com.howtoketocook.ketoapi.response.RecipeShortInfoResponse;
import com.howtoketocook.ketoapi.service.recipe.RecipeService;

@RestController
@RequestMapping("/api/public/recipes")
public class RecipeController {
	
	private static Logger logger = LoggerFactory.getLogger(RecipeController.class);
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	public List<RecipeShortInfoResponse> getAll(){
		return RecipeConverter.convertRecipeToShortResponse(recipeService.getAll());
	}
	
	@GetMapping("/{id}")
	public RecipeResponse getRecipeById(@PathVariable long id){
		logger.info("Getting recipe with id: " + id);
		return RecipeConverter.convertRecipeToDisplayById(recipeService.getRecipeById(id));		
	}	
	
	@PostMapping
	public void addRecipe(@RequestBody RecipeRequest recipeRequest){
		recipeService.addRecipe(recipeRequest);
	}
}

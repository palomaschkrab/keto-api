package com.howtoketocook.ketoapi.controller.publics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.howtoketocook.ketoapi.converter.RecipeConverter;
import com.howtoketocook.ketoapi.response.RecipeResponse;
import com.howtoketocook.ketoapi.response.RecipeShortInfoResponse;
import com.howtoketocook.ketoapi.service.recipe.RecipeService;

@RestController
@RequestMapping("/api/public/recipes")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	@GetMapping
	public List<RecipeShortInfoResponse> getAll(){
		return RecipeConverter.convertRecipeToShortResponse(recipeService.getAll());
	}
	
	@GetMapping("/{id}")
	public RecipeResponse getRecipeById(@PathVariable long id){
		return RecipeConverter.convertRecipeToDisplayById(recipeService.getRecipeById(id));		
	}	
}

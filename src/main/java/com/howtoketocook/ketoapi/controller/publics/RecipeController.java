package com.howtoketocook.ketoapi.controller.publics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
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
import com.howtoketocook.ketoapi.service.facade.RecipeFacade;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public/recipes")
@Transactional
@RequiredArgsConstructor
public class RecipeController {
	
	private static Logger logger = LoggerFactory.getLogger(RecipeController.class);
	
	private final RecipeFacade recipeFacade;
	
	@GetMapping
	public List<RecipeShortInfoResponse> getAll(){
		return RecipeConverter.convertRecipeToShortResponse(recipeFacade.getAllRecipes());
	}
	
	@GetMapping("/{urlId}")
	public RecipeResponse getRecipeByUrlId(@PathVariable String urlId){
		logger.info("Getting recipe with urlId: " + urlId);
		return RecipeConverter.convertRecipeToDisplayByUrlId(recipeFacade.getRecipeByUrlId(urlId));		
	}	
	
	@PostMapping
	public void addRecipe(@RequestBody RecipeRequest recipeRequest){
		recipeFacade.addRecipe(recipeRequest);
	}
}

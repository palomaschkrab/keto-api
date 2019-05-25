package converter;

import java.util.ArrayList;
import java.util.List;

import com.howtoketocook.ketoapi.model.Recipe;

import response.RecipeByIdResponse;
import response.RecipeShortInfoResponse;

public class RecipeConverter {
	public static List<RecipeShortInfoResponse> convertRecipeToShortResponse(List<Recipe> recipes) {
		List<RecipeShortInfoResponse> recipeShortInfoResponses = new ArrayList<RecipeShortInfoResponse>();
		for(Recipe recipe: recipes) {
			RecipeShortInfoResponse newShortInfoResponse = new RecipeShortInfoResponse(recipe);
			recipeShortInfoResponses.add(newShortInfoResponse);
		}
		return recipeShortInfoResponses;
	}
	
	public static RecipeByIdResponse convertRecipeToDisplayById(Recipe recipe) {
		return new RecipeByIdResponse(recipe);
	}
}

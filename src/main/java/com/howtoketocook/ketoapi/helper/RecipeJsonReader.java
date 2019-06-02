package com.howtoketocook.ketoapi.helper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.howtoketocook.ketoapi.enums.IngredientUnit;
import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.MacroNutrients;
import com.howtoketocook.ketoapi.model.Recipe;

public class RecipeJsonReader {
	
	private static Logger logger = LoggerFactory.getLogger(RecipeJsonReader.class);
	
	private static List<Recipe> recipes = new ArrayList<Recipe>();
	
	public static List<Recipe> getRecipesFromResources() {
		 logger.debug("Getting Recipes from json files");
	        
		if(recipes.isEmpty()) {
			String folderName = "recipes";
	        ClassLoader classLoader = RecipeJsonReader.class.getClassLoader();
	        File recipeFolder = new File(classLoader.getResource(folderName).getFile());
	        logger.info("Recipe Folder: {}", recipeFolder.getAbsolutePath());
	        logger.info("Recipe Folder exists: {}", recipeFolder.exists());
	        logger.info("Recipe Folder isDirectory: {}", recipeFolder.isDirectory());
	        if(recipeFolder.exists() && recipeFolder.isDirectory()) {
	        	File[] fileRecipes = recipeFolder.listFiles();
	        	for(File recipeFile: fileRecipes) {
	        		logger.info("Recipe Path: {}", recipeFile.getAbsolutePath());
	        		JSONParser parser = new JSONParser();
	                try (Reader reader = new FileReader(recipeFile)) {
	                    JSONObject jsonObject = (JSONObject) parser.parse(reader);

	                    Recipe recipe = Recipe.builder()
		        				.id((Long) jsonObject.get("id"))
		        				.name((String) jsonObject.get("name"))
		        				.cookingTime((Long) jsonObject.get("cookingTime"))
		        				.prepTime((Long) jsonObject.get("prepTime"))
		        				.portions((Long) jsonObject.get("portions"))
		        				.ingredients(getIngredients((JSONArray) jsonObject.get("ingredients")))
		        				.instructions((String) jsonObject.get("instructions"))
		        				.image(getImage((JSONObject) jsonObject.get("image")))
		        				.macronutrients(getMacroNutrients((JSONObject) jsonObject.get("macronutrients")))
		        				.additionalInfo((String) jsonObject.get("additionalInfo"))
		        				.build();
	                    recipes.add(recipe);
	                } catch (IOException e) {
	                    e.printStackTrace();
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                }
	        	}
	        }else {
	        	logger.error("Recipes folder not found.");
	        	throw new RuntimeException("Recipes folder not found");
	        }
		}
        return recipes;
       
	}

	private static MacroNutrients getMacroNutrients(JSONObject jsonObject) {
		  return MacroNutrients.builder()
				.carbs((Double) jsonObject.get("carbs"))
				.fat((Double) jsonObject.get("fat"))
				.protein((Double) jsonObject.get("protein"))
				.build();
	}
	
	private static Image getImage(JSONObject jsonObject) {
		  return Image.builder()
  				.id((Long) jsonObject.get("id"))
  				.url((String) jsonObject.get("url")).build();
	}

	private static List<Ingredient> getIngredients(JSONArray jsonIngredients) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		
		Iterator<Map<String, Object>> iterator = jsonIngredients.iterator();
		
        while (iterator.hasNext()) {
        	Map<String, Object> ingredientMap = iterator.next();
        	Ingredient ingredient = Ingredient.builder()
        			.unit(IngredientUnit.valueOf((String) ingredientMap.get("unit")))
        			.quantity((Double) ingredientMap.get("quantity"))
        			.name((String) ingredientMap.get("name"))
        			.build();
        	ingredients.add(ingredient);
        }
        return ingredients;
	}
}

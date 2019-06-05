package com.howtoketocook.ketoapi.service.recipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.howtoketocook.ketoapi.enums.IngredientUnit;
import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Ingredient;
import com.howtoketocook.ketoapi.model.MacroNutrients;
import com.howtoketocook.ketoapi.model.Recipe;

@Service
public class RecipeService {
	private static Logger logger = LoggerFactory.getLogger(RecipeService.class);
	
	@Value("${aws.accessKeyId}")
	private String accessKeyId;

	@Value("${aws.secretAccessKey}")
	private String secretAccessKey;
	
	@Value("${aws.bucketName}")
	private String bucketName;
	
	private static List<Recipe> recipes = new ArrayList<Recipe>();

	public List<Recipe> getAll() {
		
		if(recipes.isEmpty()) {
			AmazonS3 s3client = getS3Client();
			
			ObjectListing objectListing = s3client.listObjects(bucketName);
			
			for(S3ObjectSummary os : objectListing.getObjectSummaries()) {
				String fileName= os.getKey();
				
				S3Object s3object = s3client.getObject(bucketName, fileName);
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));
	
				try {
	            	JSONParser parser = new JSONParser();
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
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}
		return recipes;
	}

	public Recipe getRecipeById(long id) {	
		for (Recipe recipe : this.getAll()) {
			if (recipe.getId() == id)
				return recipe;
		}
		return null;
	}

	private AmazonS3 getS3Client() {
		return AmazonS3ClientBuilder
				  .standard()
				  .withCredentials(new AWSStaticCredentialsProvider(getAwsCredentials()))
				  .withRegion(Regions.CA_CENTRAL_1)
				  .build();
	}

	private BasicAWSCredentials getAwsCredentials() {
		return new BasicAWSCredentials(accessKeyId, secretAccessKey);
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

package com.howtoketocook.ketoapi.response;

import java.util.List;
import java.util.Set;

import com.howtoketocook.ketoapi.model.Image;
import com.howtoketocook.ketoapi.model.Recipe;

import lombok.Getter;

@Getter
public class RecipeShortInfoResponse{
	private long id;
	private String name;
	private String imageUrl;
	
	public RecipeShortInfoResponse(Recipe recipe) {
		id = recipe.getId();
		name = recipe.getName();
		imageUrl = getFirstImageUrl(recipe.getImages());
	}
	public String getFirstImageUrl(Set<Image> images) {
		return images.iterator().next().getUrl();
	}
}

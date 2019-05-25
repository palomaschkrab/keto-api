package response;

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
		imageUrl = recipe.getImage().getUrl();
	}
}

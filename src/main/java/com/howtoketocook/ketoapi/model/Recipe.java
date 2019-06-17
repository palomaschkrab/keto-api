package com.howtoketocook.ketoapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="recipes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;	
	private String name;
	private long cookingTime;
	private long prepTime;
	private long portions;
	@OneToMany(mappedBy="recipe")
	private List<RecipeIngredient> recipeIngredients;
	@OneToMany(mappedBy="recipe")
	private List<Instruction> instructions;
	@Column(nullable=true)
	private String note;
	@OneToOne
	private Image image;
	@OneToOne	
	private MacroNutrients macronutrients;
	private String additionalInfo;
	private boolean approved;
}

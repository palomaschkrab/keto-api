package com.howtoketocook.ketoapi.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String urlId;
	private String name;
	private long cookingTime;
	private long prepTime;
	private long portions;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<RecipeIngredient> recipeIngredients;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Instruction> instructions;
	@Column(nullable=true)
	private String note;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Image> images;
	@OneToOne(cascade=CascadeType.ALL)	
	private MacroNutrients macronutrients;
	private String additionalInfo;
	private boolean approved;
}

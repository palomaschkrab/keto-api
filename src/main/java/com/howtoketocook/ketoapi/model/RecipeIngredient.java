package com.howtoketocook.ketoapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.howtoketocook.ketoapi.enums.IngredientUnit;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="recipe_ingredients")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RecipeIngredient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Ingredient ingredient;
	private double quantity;
	@Enumerated(EnumType.STRING)
	private IngredientUnit unit;
}

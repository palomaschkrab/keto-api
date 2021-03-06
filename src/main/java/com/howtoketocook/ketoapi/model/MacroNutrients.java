package com.howtoketocook.ketoapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="macro_nutrients")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MacroNutrients {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double carbs;
	private double fat;
	private double protein;
	
}

package com.howtoketocook.ketoapi.enums;

public enum IngredientUnit {
	KILOGRAM,
	POUND,
	OUNCE,
	GRAM,
	TABLE_SPOON,
	TEA_SPOON,
	CUP,
	DROP,
	PINCH,
	UNIT,
	LITER,
	MILLILITER,
	SLICE,
	CLOVE,
	NONE;
	
	@Override
    public String toString() {
        return name().toLowerCase();
    }
}

package SAE.src;

import java.util.ArrayList;
import java.util.Arrays;

public enum TypeOccasion {
	PLATEAU_DE_FROMAGE("Plateau de fromage"), APERITIF("Aperitif"), INGREDIENT_RECETTE("Ingredient recette"), FONDUE("Fondue"), RACLETTE("Raclette");

	private String Occasion;
	
	private TypeOccasion(String Occasion) {
		this.Occasion = Occasion;
	}
	
	public String getTypeOccasion() {
		return this.Occasion;
	}
	
	public static ArrayList<TypeOccasion> getAllOccasions() {
		return new ArrayList<TypeOccasion>(Arrays.asList(TypeOccasion.values()));
	}
}

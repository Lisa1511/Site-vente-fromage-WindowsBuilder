package SAE.src;

import java.util.ArrayList;
import java.util.Arrays;

public enum TypePate {
	SOUPLE("Souple"), PRESSEE_NON_CUITE("Pressee_Non_Cuite"), TENDRE("Tendre"), CREMEUSE("Cremeuse"), FONDANTE("Fondante"),
	DURE("Dure"), FERME("Ferme");

	private String Pate;
	
	private TypePate(String Pate) {
		this.Pate = Pate;
	}
	
	public String getTypePate() {
		return this.Pate;
	}
	
	public static ArrayList<TypePate> getAllPate() {
		return new ArrayList<TypePate>(Arrays.asList(TypePate.values()));
	}
}

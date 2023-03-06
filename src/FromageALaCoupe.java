package SAE.src;


public class FromageALaCoupe extends Fromage {

	public FromageALaCoupe(String designation) {
		super(designation);
	}
	
	public String toString() {
		return super.toString() + ", vendu a la coupe ou au poids";
	}

}

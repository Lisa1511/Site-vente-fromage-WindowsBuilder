package SAE.src;



public class FromagePourXPersonnes extends Fromage {

	public FromagePourXPersonnes(String designation) {
		super(designation);
	}
	
	public String toString() {
		return super.toString() + ", vendu par nombre de personnes";
	}

}

package SAE.src;


public class FromageALUnitePlusieursChoix extends Fromage {
	
	public FromageALUnitePlusieursChoix(String designation) {
		super(designation);
	}
	
	public String toString() {
		return super.toString() + ", vendu a  l'unite avec plusieus choix";
	}

}

package SAE.src;


public enum TypeLait {
	VACHE("Vache"), CHEVRE("Chevre"), BREBIS("Brebis");

	private String typeDeLait;
	
	private TypeLait(String typeDeLait) {
		this.typeDeLait = typeDeLait;
	}
	
	public String getTypeDeLait() {
		return this.typeDeLait;
	}
}

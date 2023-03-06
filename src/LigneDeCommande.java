package SAE.src;

public class LigneDeCommande extends Panier{
	
	private Article art;
	private int quantite;
	
	public LigneDeCommande(Article art,int quantite) {
		this.quantite = quantite;
		this.art = art;
	}
	public int getQuantite() {
		return this.quantite;
	}
	public Article getArticle() {
		return this.art;
	}
	public void setQuantite(int newQuantite) {
		this.quantite = newQuantite;
	}
}

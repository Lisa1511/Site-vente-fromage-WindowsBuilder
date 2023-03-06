package SAE.src;



import java.util.LinkedList;
import java.util.List;

public class Fromage implements Comparable<Fromage> {
	
	private String designation;
	private String description;
	private TypeLait typeFromage;
	private List<Article> articles;
	
	private float note;
	private TypeOccasion[] occasion;
	private TypePate pate;

	public Fromage(String designation) {
		this.designation = designation;
		this.articles = new LinkedList<Article>();
	}	
	
	public String getDesignation() {
		return this.designation;
	}
	
	public String getDescription() {
		assert !(this.description == null);
		if (this.description == null)
			return "Pas de description de ce fromage pour le moment. Nous en sommes desoles";
		return this.description;
	}

	public void addDescription(String description) {
		this.description = description;
	}
	
	public void updateTypeFromage(TypeLait type) {
		this.typeFromage = type;
	}
	
	public TypeLait getTypeFromage() {
		return this.typeFromage;
	}

	public String toString() {
		return this.getDesignation() 
				+ ", Fromage au lait de " 
				+ this.typeFromage.getTypeDeLait();
	}
	
	public void addArticle(String cle, float prixTTC) {
		this.articles.add(new Article(this, cle, prixTTC));
	}
	
	public int nombreArticles() {
		return this.articles.size();
	}
	
	public List<Article> getArticles() {
		return this.articles;
	}
	
	public int compareTo(Fromage f) {
		return this.designation.compareTo(f.designation);
	}
	
	public boolean equals(Object obj) {
		Fromage other = (Fromage) obj;
		return this.designation.equals(other.designation);
	}
	
	public Article getFArticle() {
		boolean found = false;
		for (Article a : this.getArticles()) {
			if (a.getQuantiteEnStock() > 0) {
				if (found == false) {
					found = true;
					return a;
				}
			}
		}
		return null;
	}
	
	public TypeOccasion[] getOccasion() {
		return this.occasion;
	}
	
	public TypePate getPate() {
		return this.pate;
	}
	
	public float getNote() {
		return this.note;
	}

}

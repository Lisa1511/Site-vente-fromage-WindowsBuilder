package SAE.src;


public class FicheClient {
	private String prenom;
	private String nom;
	private String adresse1;
	private String adresse2;
	private int codePostal;
	private String ville;
	private String telephone;
	private String mail;
	
	public FicheClient(String prenom, String nom, String adresse1, String adresse2, int codePostal,String ville, String telephone, String mail){
		this.prenom = prenom;
		this.nom = nom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.mail = mail;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public String getNom() {
		return this.nom;
	}
	public String getAdresse1() {
		return this.adresse1;
	}
	public String getAdresse2() {
		return this.adresse2;
	}
	public int getCodePostal() {
		return this.codePostal;
	}
	public String getVille() {
		return this.ville;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public String getMail() {
		return this.mail;
	}
	public void setPrenom(String newPrenom) {
		this.prenom = newPrenom;
	}
	public void setNom(String newNom) {
		this.nom =newNom;
	}
	public void setAdresse1(String newAdresse1) {
		this.adresse1 = newAdresse1;
	}
	public void setAdresse2(String newAdresse2) {
		this.adresse2 = newAdresse2;
	}
	public void setCodePostal(int newCodePostal) {
		codePostal =newCodePostal;
	}
	public void setVille(String newVille) {
		this.ville = newVille;
	}
	public void setTelephone(String newTelephone) {
		this.telephone = newTelephone;
	}
	public void setMail(String newMail) {
		this.mail = newMail;
	}
}

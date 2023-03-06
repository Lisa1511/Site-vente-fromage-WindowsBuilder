package SAE.src;

import java.util.List;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class PanierClass {
	
	
	private List<LigneDeCommande> panier;
	public static final float PRIX_COLISSIMO = 4.9F;
	public static final float PRIX_COLISSIMO_DOMICILE = 4.9F;
	public static final float PRIX_CHRONOPOST = 9.9F;
	
	public PanierClass() {
		this.panier = new ArrayList<LigneDeCommande>(0);
	}
	public float totalTTC() {
		float prixTTC = 0.0F;
		for(int i = 0; i< this.panier.size(); i++) {
			prixTTC = prixTTC + this.panier.get(i).getArticle().getPrixTTC() * this.panier.get(i).getQuantite();
		}
		return prixTTC;
	}
	public void ReinitialisationPanier() {
		panier.clear();
	}
	
	public float totalTTCPortColissimo() {
		return this.totalTTC()+PRIX_COLISSIMO;
	}
	public float totalTTCPortColissimoDomicile() {
		return this.totalTTC()+PRIX_COLISSIMO_DOMICILE;
	}
	public float totalTTCPortChronopost() {
		return this.totalTTC()+PRIX_CHRONOPOST;
	}
	public void addArticle(Article art, int q) throws IllegalArgumentException{
		if(q > art.getQuantiteEnStock()) {
			throw new IllegalArgumentException("quantite demandee superieure à quantite en stock");
		}
		for (int i = 0; i<panier.size();i++) {
			if (art.equals(panier.get(i).getArticle())) {
				panier.get(i).setQuantite(panier.get(i).getQuantite() + q);
				return;
			}
		}
		panier.add(new LigneDeCommande(art,q));
	}
	public void MiseAJourStock() {
		for(int i = 0; i<panier.size();i++) {
			panier.get(i).getArticle().setQuantiteEnStock(panier.get(i).getArticle().getQuantiteEnStock()-panier.get(i).getQuantite());
		}
	}
	public void Afficher(FicheClient f, String livraison) {
        System.out.println(String.format("%20s","Fromagerie Chromage pour vous servir et resservir du fromages"));
        System.out.println("Toulouse, le "+ZonedDateTime.now());
        System.out.print("\nINFORMATIONS CLIENT :");
        System.out.println(String.format("%24s",f.getNom()+" "+ f.getPrenom()));
        System.out.println(String.format("%45s", f.getAdresse1()));
        if (f.getAdresse2() != null) {
            System.out.println(String.format("%45s",f.getAdresse2()));
        }
        System.out.println(String.format("%45s",f.getCodePostal()+" "+ f.getVille()));         
        System.out.println(String.format("%45s","telephone : " + f.getTelephone()));
        System.out.println(String.format("%45s","mail : " + f.getMail()));
        System.out.println("\n\n\nRecapitulatif de la commande :\n");
        for (int i = 0;i<panier.size();i++) {
            System.out.println(+i+1+": " +panier.get(i).getArticle().getFromage().getDesignation()+", Prix TTC : " +panier.get(i).getArticle().getPrixTTC()+"€"+String.format("%20s","quantite : " +panier.get(i).getQuantite()));
        }
        System.out.println("frais de port :" + livraison );
        System.out.println("TOTAL TTC COMMANDE : " +totalTTC()+"€\n");
        System.out.println(String.format("%40s", "Vous remerciant de votre confiance, la fromagerie Chromage\n\n\n\n\n\n"));
    }
	
	public int size() {
        return panier.size();
    }
}


package SAE.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Articles {

	private List<Fromage> lesFromages;
	
	public Articles() {
		this.lesFromages = new LinkedList<Fromage>();
	}
	
	public void addFromages(List<Fromage> fromages) {
		this.lesFromages.addAll(fromages);
	}
	
	public String toStringFromagesEtArticles() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			enForme.append(f.toString() + '\n');
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toString() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public String toStringArticlesEtStock() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toStringAvecStock() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public void regenerationDuStock() {
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					article.setQuantiteEnStock((int) Math.round(Math.random()*100));
				}
			}
		}
	}
	
	public String verificationSaisie( ) {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() == 0) {
				enForme.append("Pas d'articles pour " + f.toString() + '\n');
			}
		}
		return enForme.toString();
	}
	
	
	public List<Fromage> getLesFromages() {
		return this.lesFromages;
	}
	
	public String toStringDescription() {
        StringBuffer enForme = new StringBuffer();
        for (Fromage f : this.lesFromages) {
            enForme.append(f.getDescription() + '\n'+"\n");
        }
        return enForme.toString();
	}
	public int FromageAuLaitDeBrebis() {
		List<Fromage> Brebis = new ArrayList<Fromage>();
	    for (Fromage f : this.lesFromages) {
	        if (f.getTypeFromage() == TypeLait.BREBIS) {
	            Brebis.add(f);
	        }
	    }
	    return Brebis.size();
		}
		
		public int FromageAuLaitDeChevre() {
		    List<Fromage> Chevre = new ArrayList<Fromage>();
		    for (Fromage f : this.lesFromages) {
		        if (f.getTypeFromage() == TypeLait.CHEVRE) {
		            Chevre.add(f);
		        }
		    }
		    return Chevre.size();
		}
		
		public int FromageAuLaitDeVache() {
		    List<Fromage> Vache = new ArrayList<Fromage>();
		    for (Fromage f : this.lesFromages) {
		        if (f.getTypeFromage() == TypeLait.VACHE) {
		            Vache.add(f);
		        }
		    }
		    return Vache.size();
		}
}

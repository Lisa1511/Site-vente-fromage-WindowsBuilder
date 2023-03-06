package SAE.src;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMetier {

    private Fromage f;
    private Fromage f1;
    private Fromage f2;
    private Fromage f3;
    private List<Fromage> listeFromage;
    private Articles a;
    private PanierClass p;
    private Article A;
    private Article B;

    @Before
    public void SetUp() throws Exception {
        this.f = new Fromage("fromage brebis");
        this.f.updateTypeFromage(TypeLait.BREBIS);
        this.f1 = new Fromage("fromage brebis 2");
        this.f1.updateTypeFromage(TypeLait.BREBIS);
        this.f2 = new Fromage("Fromage vache");
        this.f2.updateTypeFromage(TypeLait.VACHE);
        this.f3 = new Fromage("Fromage chevre");
        this.f3.updateTypeFromage(TypeLait.CHEVRE);
        this.listeFromage = new LinkedList<Fromage>();
        this.listeFromage.add(f);
        this.listeFromage.add(f1);
        this.listeFromage.add(f2);
        this.listeFromage.add(f3);
        this.a = new Articles ();
        a.addFromages(listeFromage);
        this.p = new PanierClass();
        this.A = new Article(f3,"huz",50);
        this.A.setQuantiteEnStock(4);
        this.B = new Article(f2,"zgeu",30);
        this.B.setQuantiteEnStock(10);


    }

    @After
    public void TearDown() throws Exception {
        this.p = null;
        this.listeFromage = null;
    }

    @Test
    public void testFiltre() {
        int brebis = this.a.FromageAuLaitDeBrebis();
        assertEquals(2,brebis);
    }
@Test
    public void testRecupArticle() {
        this.f.addArticle("ez", 30);
        this.f.addArticle("edb", 10);
        this.f1.addArticle("fhd", 100);
        assertEquals(2,this.f.nombreArticles());
    }

    @Test
    public void testGestionPanier() {
        p.addArticle(A, 2);
        assertEquals(1,p.size());
        p.addArticle(A, 2);
        assertEquals(1,p.size());
        p.ReinitialisationPanier();
        assertEquals(0,p.size());
    }

    @Test
    public void testCaculFacture() {
        p.addArticle(B, 1);
        p.addArticle(A, 2);
        assertEquals(130F,p.totalTTC(),0F);
    }

    @Test
    public void testMisAjourStock() {
        p.addArticle(A, 2);
        p.MiseAJourStock();
        assertEquals(2,A .getQuantiteEnStock());
    }
}
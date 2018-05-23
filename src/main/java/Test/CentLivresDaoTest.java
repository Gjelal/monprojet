package Test;

import static Main.CentLivresDao.PRECISION_ANNEE;
import Main.FileToStr;
import Main.Livre;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Reader;
import java.util.*;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CentLivresDaoTest {
    
    private static ArrayList lst = new ArrayList();

    @Test
    public void testerChargerLivre() {
        recupererFichier();
        /*traiterFichier();
        chargerListe();*/
    }

    private void recupererFichier() {
        String st = "Salut Gjelal 1997 true tata Suisse";
        traiterFichier(st);
    }

    private void traiterFichier(String st) {
         StringTokenizer sT = new StringTokenizer(st, " ");
         Livre l = new Livre(sT.nextToken(), sT.nextToken(), sT.nextToken(), sT.nextToken().equals(PRECISION_ANNEE), sT.nextToken(), sT.nextToken());
         chargerListe(l);
    }

    private void chargerListe(Livre l) {
        lst.add(l);
        assertEquals("success", true);
    }
 

}

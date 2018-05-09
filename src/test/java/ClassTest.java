
import java.util.ArrayList;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gjelal-pc
 */
public class ClassTest {
    
    @Test
    public static String afficherResultatFiltreTest () {
    ArrayList res = CentLivresDao.filtrer("Hamlet", "", "");
    String str = "";
    for (int k = 0; k < res.size(); k++) {
      str += res.get(k) + "\n";
    }
    assertEquals(str, "Hamlet de William Shakespeare\n" +"  Année 1603\n" +"  Théâtre (tragédie)\n" +"  [Royaume-Uni]");
    return str;
    }    
}

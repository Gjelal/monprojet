import java.awt.*;
import java.awt.event.*;
import java.util.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LivreTest {
    
    Livre livre1, livre2;
  
  @Test
    public void testCompareToEquals(){
        livre1 = new Livre("Salut","Gjelal","1995", true ,"tata", "Suisse");
        livre2 = new Livre("Salut","Gjelal","1995", true ,"tata", "Suisse");
        Assert.assertEquals(livre1.compareTo(livre2),0);
    }
    
    @Test
    public void testCompareToPlusGrandL1L2(){
        livre1 = new Livre("Salut","Gjelal","1996", true ,"tata", "Suisse");
        livre2 = new Livre("Salut","Gjelal","1995", true ,"tata", "Suisse");
        Assert.assertTrue(livre1.compareTo(livre2) > 0);
    }
    
    @Test
    public void testCompareToPlusGrandL2L1(){
        livre1 = new Livre("Salut","Gjelal","1996", true ,"tata", "Suisse");
        livre2 = new Livre("Salut","Gjelal","1997", true ,"tata", "Suisse");
        Assert.assertTrue(livre1.compareTo(livre2) < 0);
    }
    
    @Test
    public void testContientPaysTrue(){
      livre2 = new Livre("Salut","Gjelal","1997", true ,"tata", "Suisse");
      Assert.assertTrue(livre2.paysContient("Suisse") == true);
    }
    
    @Test
    public void testContientPaysFalse(){
      livre2 = new Livre("Salut", "Gjelal", "1997", true ,"tata", "Suisse");
      Assert.assertTrue(livre2.paysContient("France") == false);
    }
    
    public void testCorrespondLivreTrue() {
        Assert.assertTrue(livre2.correspond("Salut", "Gjelal", "Inconnu") == true);
    }
    
    public void testCorrespondLivreFalse() {
        Assert.assertTrue(livre2.correspond("Tak", "Tik", "Inconnu") == false);
    }
    
} // Livre

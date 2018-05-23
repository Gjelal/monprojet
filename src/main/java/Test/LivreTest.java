package Test;

import Main.Livre;
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
      Assert.assertFalse(livre2.paysContient("Suisse"));
    }
    
    @Test
    public void testContientPaysFalse(){
      livre2 = new Livre("Salut", "Gjelal", "1997", true ,"tata", "Suisse");
      Assert.assertFalse(livre2.paysContient("France"));
    }
    
    @Test
    public void testCorrespondLivreTrue() {
        Assert.assertTrue(livre2.correspond("Salut", "Gjelal", "Inconnu") == true);
    }
    
    @Test
    public void testCorrespondLivreFalse() {
        Assert.assertTrue(livre2.correspond("Tak", "Tik", "Inconnu") == false);
    }
    @Test
    public void testToString() {
        Assert.assertEquals((livre2.toString()).equals("Salut + \" de \" + Gjelal + \"\\n  \" + (Année) + 1997 + \"\\n  \" + tata + \"\\n  \" + Suisse"), true);
    }
    
} // Livre

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Module 633.1-Programmation - Contrôle continu du 19.11.2016
 * 
 * Application interactive de gestion des livres
 *
 * Vous avez le droit de modifier la signature de cette classe en 
 * accord avec les différentes architectures vues en classe.
 *
 * On évite de créer de nombreux Strings dans afficherResultatFiltre()
 *
 * @author Peter Daehne - HEG Genève
 * @version 2.0
 */
public class CentLivres {

  private static final String TITRE_FRAME = "100 Livres";
  private static final String TXT_TITRE = "Titre: ";
  private static final String TXT_AUTEUR = "Auteur: ";
  private static final String TXT_PAYS = "Pays: ";
  private static final String TXT_RESULT = "100 livres à disposition";

  private static Frame frm;
  
  private static Label lblTitre = new Label(TXT_TITRE);
  private static TextField tfTitre = new TextField(10);
  private static Label lblAuteur = new Label(TXT_AUTEUR);
  private static TextField tfAuteur = new TextField(10);
  private static Label lblPays = new Label(TXT_PAYS);
  private static TextField tfPays = new TextField(10);
  private static Label lblResult = new Label(TXT_RESULT);
  private static TextArea taResult = new TextArea(17, 50);

  private static StringBuilder str = new StringBuilder(8000); /* Buffer pour l'affichage */

  private static void afficherResultatFiltre () {
    ArrayList res = CentLivresDao.filtrer(tfTitre.getText(), tfAuteur.getText(), tfPays.getText());
    lblResult.setText((res.size() == 0) ? TXT_RESULT : res.size() + " résultats");
    str.delete(0, str.length());
    for (int k = 0; k < res.size(); k++) {
      str.append(res.get(k)).append("\n");
    }
    taResult.setText(str.toString());
  } // afficherResultatFiltre

  private static void definirListeners () {
    frm.addWindowListener(new WindowAdapter() {
      public void windowClosed (WindowEvent e) {System.exit(0);}
      public void windowClosing (WindowEvent e) {frm.dispose();}
    });
    TextListener tL = new TextListener() {
      public void textValueChanged (TextEvent e) {afficherResultatFiltre();}
    };
    tfTitre.addTextListener(tL); tfAuteur.addTextListener(tL); tfPays.addTextListener(tL); 
  } // definirListeners

	public static void main (String[] args){
    CentLivresDao.chargerLivres();
    frm = new Frame(TITRE_FRAME);
    frm.setSize(500, 400);
    frm.setLayout (new FlowLayout());
    frm.add(lblTitre);
    frm.add(tfTitre);
    frm.add(lblAuteur);
    frm.add(tfAuteur);
    frm.add(lblPays);
    frm.add(tfPays);
    frm.add(lblResult);
    frm.add(taResult); taResult.setEditable(false);
    definirListeners();
    frm.setVisible(true);
	} // main

} // CentLivres

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;


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

  private static void afficherResultatFiltre () {
    ArrayList res = CentLivresDao.filtrer(tfTitre.getText(), tfAuteur.getText(), tfPays.getText());
    lblResult.setText((res.size() == 0) ? TXT_RESULT : res.size() + " résultats");
    String str = "";
    for (int k = 0; k < res.size(); k++) {
      str += res.get(k) + "\n";
    }
    taResult.setText(str);
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

  /*private static void afficherPropEtVersion() {
    try (InputStream stream = new FileInputStream("application.properties")) {
      properties.load(stream);
      String version = properties.getProperty("application.version");
     } catch (Exception e) {
      System.out.println("Fichiers introuvables");
     }
  }*/

	public static void main (String[] args) throws IOException{
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
    //afficherPropEtVersion();
	} // main

} // CentLivres

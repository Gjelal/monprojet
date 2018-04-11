import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CentLivresDao {

  /** Valeurs possibles du champ "Précision" du fichier de données */
  public static final String PRECISION_ANNEE = "Année";   /* La précision est l'année */
  public static final String PRECISION_SIECLE = "Siècle"; /* La précision est le siècle */

  private static final String NOM_FICHIER = "100livres.csv"; /* Nom du fichier de données */

  private static ArrayList listeLivres = new ArrayList(); /* Liste des livres */

  /** Lit la liste des livres depuis le fichier de données et charge les livres
      dans l'ArrayList "listeLivres". */
  public static void chargerLivres () {
		StringTokenizer stLig = new StringTokenizer(FileToStr.read(NOM_FICHIER), "\r\n");
    stLig.nextToken(); /* Ignorer la ligne de titre */
    while (stLig.hasMoreTokens()) {
      StringTokenizer sT = new StringTokenizer(stLig.nextToken(), ";");
      listeLivres.add(new Livre(sT.nextToken(), sT.nextToken(), sT.nextToken(), sT.nextToken().equals(PRECISION_ANNEE), sT.nextToken(), sT.nextToken()));
      
    }
	} // chargerLivres
	
	/** Retourne une ArrayList contenant la liste de tous les livres qui satisfont la
      contrainte suivante:
      - Le titre du livre CONTIENT le String titre                   OU
      - Le nom de l'auteur du livre CONTIENT le String auteur        OU
      - La liste des pays du livre contient un pays COMMENÇANT PAR le String pays   */
	public static ArrayList filtrer (String titre, String auteur, String pays) {
		ArrayList res = new ArrayList();
    for (int k = 0; k < listeLivres.size(); k++) {
      Livre livre = (Livre)listeLivres.get(k);
      if (livre.correspond(titre, auteur, pays)) {res.add(livre);}
    }
		return res;
	} // filtrer   

} // CentLivresDao

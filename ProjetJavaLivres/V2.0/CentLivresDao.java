import java.util.*;

/**
 * Module 633.1-Programmation - Contr�le continu du 19.11.2016
 * 
 * Gestion de la liste des livres (fichier de donn�es: "100livres.csv")
 *
 * Vous n'avez pas le droit modifier ni les signatures de m�thodes ni 
 * les types et noms des variables.
 *
 * @author Peter Daehne - HEG Gen�ve
 * @version 2.0
 */
public class CentLivresDao {

  /** Valeurs possibles du champ "Pr�cision" du fichier de donn�es */
  public static final String PRECISION_ANNEE = "Ann�e";   /* La pr�cision est l'ann�e */
  public static final String PRECISION_SIECLE = "Si�cle"; /* La pr�cision est le si�cle */

  private static final String NOM_FICHIER = "100livres.csv"; /* Nom du fichier de donn�es */

  private static ArrayList listeLivres = new ArrayList(); /* Liste des livres */

  /** Lit la liste des livres depuis le fichier de donn�es et charge les livres
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
      - La liste des pays du livre contient un pays COMMEN�ANT PAR le String pays   */
	public static ArrayList filtrer (String titre, String auteur, String pays) {
    String tLow = titre.toLowerCase();
    String aLow = auteur.toLowerCase();
    String pLow = pays.toLowerCase();
		ArrayList res = new ArrayList();
    for (int k = 0; k < listeLivres.size(); k++) {
      Livre livre = (Livre)listeLivres.get(k);
      if (livre.correspondLower(tLow, aLow, pLow)) {res.add(livre);}
    }
		return res;
	} // filtrer   

} // CentLivresDao

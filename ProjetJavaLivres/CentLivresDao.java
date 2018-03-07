import java.util.*;

/**
 * Module 633.1-Programmation - Contrôle continu du 19.11.2016
 * 
 * Gestion de la liste des livres (fichier de données: "100livres.csv")
 *
 * Vous n'avez pas le droit modifier ni les signatures de méthodes ni 
 * les types et noms des variables.
 *
 * NOM:							POSTE:
 */
public class CentLivresDao {

  /** Valeurs possibles du champ "Précision" du fichier de données */
  public static final String PRECISION_ANNEE = "Année";   /* La précision est l'année */
  public static final String PRECISION_SIECLE = "Siècle"; /* La précision est le siècle */

  private static final String NOM_FICHIER = "100livres.csv"; /* Nom du fichier de données */

  private static ArrayList listeLivres = new ArrayList(); /* Liste des livres */

  /** Lit la liste des livres depuis le fichier de données et charge les livres
      dans l'ArrayList "listeLivres". */
  public static void chargerLivres () {
		StringTokenizer strLigne = new StringTokenizer(NOM_FICHIER, "\r\n");
    strLigne.nextToken();
    while (strLigne.hasMoreTokens()) {
      chargerLivreDansLst(strLigne.nextToken());
    }
	} // chargerLivres

  public static void chargerLivreDansLst(String str) {
    StringTokenizer strL = new StringTokenizer (str, ";");
    String titre = strL.nextToken();
    String auteur = strL.nextToken();
    String date = strL.nextToken();
    boolean isAnnee = true;
    ArrayList pays = new ArrayList();
    if (strL.nextToken().equals(PRECISION_SIECLE)) { isAnnee = false;}
    String genre = strL.nextToken();
    StringTokenizer strPays = new StringTokenizer (strL.nextToken(), "/");
    while (strL.hasMoreTokens()) {
      pays.add(strL.nextToken());
    }
    listeLivres.add(new Livre(titre, auteur, date, isAnnee, genre, pays));
  } // chargerLivreDansLst
	
	/** Retourne une ArrayList contenant la liste de tous les livres qui satisfont la
      contrainte suivante:
      - Le titre du livre CONTIENT le String titre                   OU
      - Le nom de l'auteur du livre CONTIENT le String auteur        OU
      - La liste des pays du livre contient un pays COMMENÇANT PAR le String pays   */
	public static ArrayList filtrer (String titre, String auteur, String pays) {
    ArrayList lst = new ArrayList();
    for (int i = 0;i<listeLivres.size(); i++) {
      Livre l = (Livre)listeLivres.get(i);
      if (l.correspond(titre, auteur, pays)) {lst.add(l);}}
    }
    return lst;
	} // filtrer   

  /*** À COMPLÉTER SI NÉCESSAIRE ***/  	

} // CentLivresDao

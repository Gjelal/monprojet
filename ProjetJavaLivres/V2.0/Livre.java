import java.util.*;

/**
 * Module 633.1-Programmation - Contr�le continu du 19.11.2016
 * 
 * Classe repr�sentant un livre.
 *
 * Vous n'avez pas le droit modifier ni les signatures de m�thodes ni 
 * les types et noms des variables.
 *
 * Performance: le titre, l'auteur et la liste des pays sont �galement m�mori�s sous leur forme
 *              minuscule. En effet, la conversion en minuscules prend du temps et, en l'effectuant
 *              une fois pour toutes � la construction, on �vite de l'effectuer � chaque fois lors
 *              de l'appel � la m�thode correspond().
 *
 * @author Peter Daehne - HEG Gen�ve
 * @version 2.0
 */
public class Livre {

	private String titre;    /* Titre du livre */
	private String auteur;   /* Nom de l'auteur du livre */
	private String date;     /* Date de publication */
	private boolean isAnnee; /* true si la pr�cision est l'ann�e, false si la pr�cision est le si�cle */
	private String genre;    /* Genre litt�raire */
	private ArrayList pays;  /* Liste des pays du livre */

  private String titreLower;   /* Titre en minuscules */
  private String auteurLower;  /* Auteur en minuscules */
  private ArrayList paysLower; /* Liste des pays en minuscules */          

  /** Constructeur */
  public Livre (String titre, String auteur, String date, boolean isAnnee, String genre, String lesPays) {
    this.titre = titre; titreLower = titre.toLowerCase();
    this.auteur = auteur; auteurLower = auteur.toLowerCase();
    this.date = date; this.isAnnee = isAnnee; this.genre = genre;
    pays = new ArrayList(); paysLower = new ArrayList();
    StringTokenizer sT = new StringTokenizer(lesPays, "/"); 
    while (sT.hasMoreTokens()) {
      String p = sT.nextToken();
      pays.add(p); paysLower.add(p.toLowerCase());
    }
  } // Constructeur

	/** Retourne true SI ET SEULEMENT SI le livre satisfait la
      contrainte suivante:
      - Le titre du livre CONTIENT le String titre                   OU
      - Le nom de l'auteur du livre CONTIENT le String auteur        OU
      - La liste des pays du livre contient un pays COMMEN�ANT PAR le String pays   */
	public boolean correspond (String titre, String auteur, String pays) {
    return correspondLower(titre.toLowerCase(), auteur.toLowerCase(), pays.toLowerCase()); 
	} // correspond

  /* Retourne true ssi la liste des pays contient un pays commen�ant par p, p en "lowerCase" */
  private boolean paysContient (String p) {
    for (int k = 0; k < pays.size(); k++) {
      if (((String)paysLower.get(k)).startsWith(p)) {return true;}
    }
    return false;
  } // paysContient

  /** Idem que correspond() sauf: Pr�condition (non test�e): les param�tres sont donn�s en "lowerCase" */
	public boolean correspondLower (String titre, String auteur, String pays) {
		return (!titre.isEmpty() && titreLower.contains(titre)) ||
           (!auteur.isEmpty() && auteurLower.contains(auteur)) || 
           (!pays.isEmpty() && paysContient(pays));
	} // correspondLower

  public String toString() { 
    return titre + " de " + auteur + "\n  " + (isAnnee ? "Ann�e " : "Si�cle") + date + "\n  " + genre + "\n  " + pays;
  } // toString

} // Livre

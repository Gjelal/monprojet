package ch.hesge.livre;

import java.util.*;

/**
 * Module 633.1-Programmation - Contr�le continu du 19.11.2016
 * 
 * Classe repr�sentant un livre.
 *
 * Vous n'avez pas le droit modifier ni les signatures de m�thodes ni 
 * les types et noms des variables.
 *
 * NOM:							POSTE:
 */
public class Livre {

	private String titre;    /* Titre du livre */
	private String auteur;   /* Nom de l'auteur du livre */
	private String date;     /* Date de publication */
	private boolean isAnnee; /* true si la pr�cision est l'ann�e, false si la pr�cision est le si�cle */
	private String genre;    /* Genre litt�raire */
	private ArrayList pays;  /* Liste des pays du livre */

  public Livre (String titre, String auteur, String date, boolean isAnnee, String genre, ArrayList pays) {
  this.titre = titre; this.auteur = auteur; this.date = date; this.isAnnee = isAnnee; this.genre = genre; this.pays = pays;
  }

	/** Retourne true SI ET SEULEMENT SI le livre satisfait la
      contrainte suivante:
      - Le titre du livre CONTIENT le String titre                   OU
      - Le nom de l'auteur du livre CONTIENT le String auteur        OU
      - La liste des pays du livre contient un pays COMMEN�ANT PAR le String pays   */
	public boolean correspond (String titre, String auteur, String pays) {
    if (this.titre.equals(titre) || this.auteur.equals(auteur) || this.pays.contains(pays)) { return true;}
    return false;
	} // correspond
	
  public String toString() { 
    return titre + " de " + auteur + "\n  " + (isAnnee ? "Ann�e " : "Si�cle") + date + "\n  " + genre + "\n  " + pays;
  } // toString

} // Livre
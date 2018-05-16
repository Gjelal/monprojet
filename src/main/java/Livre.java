import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Livre {

    private String titre;    /* Titre du livre */
    private String auteur;   /* Nom de l'auteur du livre */
    private String date;     /* Date de publication */
    private boolean isAnnee; /* true si la précision est l'année, false si la précision est le siècle */
    private String genre;    /* Genre littéraire */
    private ArrayList pays;  /* Liste des pays du livre */

    /** Constructeur */
    public Livre (String titre, String auteur, String date, boolean isAnnee, String genre, String lesPays) {
      this.titre = titre; this.auteur = auteur; this.date = date; this.isAnnee = isAnnee; this.genre = genre;
      pays = new ArrayList();
      StringTokenizer sT = new StringTokenizer(lesPays, "/"); while (sT.hasMoreTokens()) {pays.add(sT.nextToken());}
    } // Constructeur

    /* Retourne true ssi la liste des pays contient un pays commençant par p */
    public boolean paysContient (String p) {
        for (int k = 0; k < pays.size(); k++) {
          if (((String)pays.get(k)).toLowerCase().startsWith(p)) {return true;}
        }
        return false;
    } // paysContient
  
    public boolean equals(Livre l) {return ((Livre)l).titre.equals(titre);}

    public int compareTo(Object o) {
      Livre l = (Livre) o;
      int res;
      return Integer.parseInt(date) - Integer.parseInt(l.date);
    }

      /** Retourne true SI ET SEULEMENT SI le livre satisfait la
      contrainte suivante:
      - Le titre du livre CONTIENT le String titre                   OU
      - Le nom de l'auteur du livre CONTIENT le String auteur        OU
      - La liste des pays du livre contient un pays COMMENÇANT PAR le String pays   */
    public boolean correspond (String titre, String auteur, String pays) {
	return (!titre.isEmpty() && this.titre.toLowerCase().contains(titre.toLowerCase())) ||
        (!auteur.isEmpty() && this.auteur.toLowerCase().contains(auteur.toLowerCase())) || 
        (!pays.isEmpty() && paysContient(pays.toLowerCase()));
    } // correspond

    public String toString() { 
        return titre + " de " + auteur + "\n  " + (isAnnee ? "Année " : "Siècle") + date + "\n  " + genre + "\n  " + pays;
    } // toString
} // Livre

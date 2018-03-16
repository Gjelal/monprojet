package ch.hesge.livre;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Module 633.1-Programmation - Contr�le continu du 19.11.2016
 * <p>
 * Gestion de la liste des livres (fichier de donn�es: "100livres.csv")
 * <p>
 * Vous n'avez pas le droit modifier ni les signatures de m�thodes ni
 * les types et noms des variables.
 * <p>
 * NOM:							POSTE:
 */
public class CentLivresDao {

    /**
     * Valeurs possibles du champ "Pr�cision" du fichier de donn�es
     */
    public static final String PRECISION_ANNEE = "Ann�e";   /* La pr�cision est l'ann�e */
    public static final String PRECISION_SIECLE = "Si�cle"; /* La pr�cision est le si�cle */

    private static final String NOM_FICHIER = "100livres.csv"; /* Nom du fichier de donn�es */

    private static ArrayList listeLivres = new ArrayList(); /* Liste des livres */

    /**
     * Lit la liste des livres depuis le fichier de donn�es et charge les livres
     * dans l'ArrayList "listeLivres".
     */
    public static void chargerLivres() {
        StringTokenizer strLigne = new StringTokenizer(NOM_FICHIER, "\r\n");
        strLigne.nextToken();
        while (strLigne.hasMoreTokens()) {
            chargerLivreDansLst(strLigne.nextToken());
        }
    }

    public static void chargerLivreDansLst(String str) {
        StringTokenizer strL = new StringTokenizer(str, ";");
        String titre = strL.nextToken();
        String auteur = strL.nextToken();
        String date = strL.nextToken();
        boolean isAnnee = true;
        ArrayList pays = new ArrayList();
        if (strL.nextToken().equals(PRECISION_SIECLE)) {
            isAnnee = false;
        }
        String genre = strL.nextToken();
        StringTokenizer strPays = new StringTokenizer(strL.nextToken(), "/");
        while (strL.hasMoreTokens()) {
            pays.add(strL.nextToken());
        }
        listeLivres.add(new Livre(titre, auteur, date, isAnnee, genre, pays));
    }

    /**
     * Retourne une ArrayList contenant la liste de tous les livres qui satisfont la
     * contrainte suivante:
     * - Le titre du livre CONTIENT le String titre                   OU
     * - Le nom de l'auteur du livre CONTIENT le String auteur        OU
     * - La liste des pays du livre contient un pays COMMEN�ANT PAR le String pays
     */
    public static ArrayList filtrer(String titre, String auteur, String pays) {
        ArrayList lst = new ArrayList();
        for (int i = 0; i < listeLivres.size(); i++) {
            Livre l = (Livre) listeLivres.get(i);
            if (l.correspond(titre, auteur, pays)) {
                lst.add(l);
            }
        }
        return lst;
    }
}

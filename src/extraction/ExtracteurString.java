/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraction;

/**
 *
 * @author Lucie et Nicolas
 */
public class ExtracteurString extends ExtracteurAbstract {

    /**
     * Chaine de caractères dont on extrait les mots
     */
    private String chaine;

    /**
     * Ligne du mot extrait
     */
    private int ligne;

    /**
     * Colonne de la première lettre du mot extrait
     */
    private int colonne;
    /**
     * Position courante sur la chaine de caractères
     */
    private int cursor;

    /**
     * Constructeur de la classe ExtracteurString, initialise la ligne
     *
     * @param chaine une chaine de caractères
     */
    public ExtracteurString(String chaine) {
        this.chaine = chaine;
        this.cursor = 0;
        this.ligne = 1;
        this.colonne = 1;
    }

    /**
     * Extrait un mot d'une chaine de caractères
     *
     * @return un InfoMot
     */
    @Override
    public InfosMot getNext() {
        StringBuilder sb = new StringBuilder();
        int cptColonne = 0;
        //Si on n'est pas à la fin de la chaîne
        if (this.cursor < this.chaine.length()) {
            //Si le caractère n'est pas une lettre ou un nombre
            if (!Character.isLetterOrDigit(this.chaine.charAt(this.cursor))) {
                //Si on a un changement de ligne
                switch (this.chaine.charAt(this.cursor)) {
                    case '\n':
                        this.ligne++;
                        this.colonne = 1;
                        break;
                    default :
                        this.colonne++;
                }
                //Dans tous les cas, on avance d'un caractère dans la chaine
                this.cursor++;
            }
            //Parcours du mot à retourner
            while (this.cursor < chaine.length() && Character.isLetterOrDigit(this.chaine.charAt(this.cursor))) {
                sb.append(this.chaine.charAt(this.cursor));
                cptColonne++;
                this.cursor++;
                this.colonne++;
            }
            return new InfosMot(sb.toString(), this.ligne, this.colonne - cptColonne);
        } else {
            return null;
        }
    }
}

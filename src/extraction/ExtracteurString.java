/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraction;

/**
 *
 * @author LUCIE
 */
public class ExtracteurString extends ExtracteurAbstract {

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
     */
    public ExtracteurString() {
        this.cursor = 0;
        this.ligne = 1;
        this.colonne = 1;
    }

    /**
     * Extrait un mot d'une chaine de caractères
     *
     * @param chaine la chaine de caractères dont on veut extraire les mots
     * @return un InfoMot
     */
    @Override
    public InfosMot getNext(String chaine) {
        StringBuilder sb = new StringBuilder();
        int cptColonne = 0;
        if (this.cursor < chaine.length()) {
            //Si le caractère n'est pas une lettre ou un nombre
            if (!Character.isLetterOrDigit(chaine.charAt(this.cursor))) {
                if (chaine.charAt(this.cursor) == '\n') {
                    this.ligne++;
                    this.colonne = 1;
                }else if(chaine.charAt(this.cursor) == ' '){
                            this.colonne ++;
                }
                this.cursor++;
                return new InfosMot("", this.ligne, this.colonne);
            }
            //Parcours du mot à retourner
            while (this.cursor < chaine.length() && Character.isLetterOrDigit(chaine.charAt(this.cursor))) {
                sb.append(chaine.charAt(this.cursor));
                cptColonne++;
                this.cursor++;
                this.colonne++;
            }
            return new InfosMot(sb.toString(), this.ligne, this.colonne - cptColonne);
        } else {
            //Pour réinitialiser l'extracteur pour l'utiliser avec une autre chaîne.
            this.cursor = 0;
            this.ligne = 1;
            this.colonne = 1;
            return null;
        }
    }

}

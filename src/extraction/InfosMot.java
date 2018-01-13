package extraction;

/**
 *
 * @author Lucie et Nicolas
 */
public class InfosMot {

    /**
     * Mot contenu dans l'InfoMot
     */
    private String mot;

    /**
     * Numéro de la ligne du mot
     */
    private int ligne;

    /**
     * Numéro de la colonne du début du mot
     */
    private int colonne;

    /**
     * Constructeur avec une chaine de caractères, la ligne et la colonne
     *
     * @param mot une chaine de caractère donnée
     * @param ligne le numéro de la ligne du mot
     * @param colonne le numéro de colonne du mot
     */
    public InfosMot(String mot, int ligne, int colonne) {
        this.mot = mot;
        this.ligne = ligne;
        this.colonne = colonne;
    }

    /**
     * Constructeur vide
     */
    public InfosMot() {
    }

    /**
     * Permet de récupérer un mot
     *
     * @return un String qui contient le mot courant
     */
    public String getMot() {
        return this.mot;
    }

    /**
     * Permet de récupérer la ligne du mot courant
     *
     * @return un entier qui indique le numéro de ligne
     */
    public int getLigne() {
        return this.ligne;
    }

    /**
     * Permet de récupérer la colonne du mot courant
     *
     * @return un entier qui indique le numéro de la colonne
     */
    public int getColonne() {
        return this.colonne;
    }

    /**
     * Affichage des informations d'un InfosMot
     *
     * @return les informations de l'InfoMot
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getMot());
        sb.append("  ligne : ");
        sb.append(this.getLigne());
        sb.append("  colonne : ");
        sb.append(this.getColonne());
        return sb.toString();
    }
}

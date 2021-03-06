package extraction;

/**
 *
 * @author Lucie et Nicolas
 */
public class ExtracteurString implements Extracteur {

    /**
     * Chaine de caractères dont on extrait les mots
     */
    private final String chaine;

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
     * Constructeur de la classe ExtracteurString, initialise les variables
     * d'instance
     *
     * @param chaine une chaine de caractères
     */
    public ExtracteurString(final String chaine) {
        this.chaine = chaine;
        this.cursor = 0;
        this.ligne = 1;
        this.colonne = 0;
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
            //Parcours du mot à retourner
            while (Character.isLetterOrDigit(this.chaine.charAt(this.cursor))) {
                sb.append(this.chaine.charAt(this.cursor));
                cptColonne++;
                this.cursor++;
                this.colonne++;
            }
            //Si on a un changement de ligne
            if (this.chaine.charAt(this.cursor) == '\n') {
                this.ligne++;
                this.colonne = 0;
            } else {
                this.colonne++;
            }
            //Dans tous les cas, on avance d'un caractère dans la chaine
            this.cursor++;
            if (sb.toString().equals("")) {
                return this.getNext();
            }
            return new InfosMot(sb.toString(), this.ligne, this.colonne - cptColonne);
        } else {
            return null;
        }
    }
}

package extraction;

/**
 *
 * @author LUCIE
 */
public class InfosMot {

    /**
     * Déclaration de la variable mot de type String
     * Récupère un mot
     */
    private String mot;
    /**
     * Déclaration de la variable ligne de type int,
     * récupère le numéro de ligne du mot
     */
    private int ligne;
    /**
     * Delaration de la variable colonne de type int
     * récupère la colonne où se trouve le début du mot
     */
    private int colonne;

    /**
     * constructeur de la classe InfosMot
     * @param mot une chaine de caractère donné
     * @param ligne le nuéro de la ligne du mot
     * @param colonne le numéro de colonne du mot
     */
    public InfosMot(String mot, int ligne, int colonne){
        this.mot = mot;
        this.ligne = ligne;
        this.colonne = colonne;
    }
    
    public InfosMot(){}
    
    /**
     * Permet de récupérer un mot
     * @return un String qui contient le mot courant
     */
    public String getMot() {
        return this.mot;
    }

    /**
     * Permet de paramétrer la variable mot
     * @param mot un String contenant le mot lu
     */
    public void setMot(String mot){
        this.mot = mot;
    }

    /**
     * Permet de récupérer la ligne du mot courant
     * @return un entier qui indique le numéro de ligne
     */
    public int getLigne() {
        return this.ligne;
    }

    /**
     *
     * @param ligne le numéro de la ligne
     */
    public void setLigne(int ligne){
        this.ligne = ligne;
    }

    /**
     * Permet de récupérer la colonne du mot courant
     * @return un entier qui indique le numéro de la colonne
     */
    public int getColonne() {
        return this.colonne;
    }

    /**
     * Permet de paramétrer le numéro de colonne
     * @param colonne le numéro de la colonne du mot
     */
    public void setColonne(int colonne){
        this.colonne = colonne;
    }
    
    public String toString(){
    return this.getMot()+" "+this.getLigne();
    }
}

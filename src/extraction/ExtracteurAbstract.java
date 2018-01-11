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
public abstract class ExtracteurAbstract implements Extracteur {

    /**
     * Implementation de la méthode getNext() qui doit renvoyer le prochain mot
     *
     * @return InfosMot les informations du mot
     */
    @Override
    public InfosMot getNext(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Cette méthode permet de savoir si le flux de lecture rencontre un
     * caractère non alphabétique
     *
     * @param c un caractère lu
     * @return true si le caractère lu est un retour chariot, un caractère
     * d'échapemment ou un espace vide
     */
    public Boolean regexSautLigne(char c) {
        //si on rencontre un saut de ligne
        return c == '\n';
    }
}

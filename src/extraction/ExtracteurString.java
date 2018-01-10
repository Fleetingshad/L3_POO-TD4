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

    private final static String MACHAINE = "bonjour\n est un mot \n\n  un mot est un mot , voilà";

    /**
     * Constructeur de la classe ExtracteurString
     */
    public ExtracteurString(){
        readString();
    }
    /**
     * Cette méthode permet la lecture caractère par caractère d'un String
     */
    public final void readString(){
        // Parcours des caractères de la chaine de caractère
        char carac;
        StringBuilder sb = new StringBuilder();
        int monCompteurDeColonne=0;
        int monCompteurDeLigne=0;
        for (int i = 0; i < MACHAINE.length(); i++) {
             //on récupère le caractère
             carac = MACHAINE.charAt(i);
             //on regarde le caractère unicode du char courant
             if( !Character.isLetterOrDigit(carac)){
                 //fin d'un mot ici normalement donc faut instancier un infomot
                 InfosMot im = new InfosMot(sb.toString(),monCompteurDeLigne,monCompteurDeColonne);
                 //on remet le stringbuilder à plat
                 sb.setLength(0);
                 if(regexSautLigne(carac)){
                     monCompteurDeColonne=0;
                     monCompteurDeLigne++;
                 }else{
                     //on étend le stringbuilder du caractère lu
                     sb.append(carac);
                     //on incrémente le compteur de col
                     monCompteurDeColonne++;
                 }
             }
        }
    }

    
}

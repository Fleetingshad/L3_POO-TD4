package main;

import extraction.*;
import indexation.*;
import java.text.Collator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author LUCIE
 */
public class Main {

    public static void main(String[] args) {
        try {
            //   Extracteur eF = new ExtracteurFile();

            //TEST DE L'EXTRACTEUR STRING ET DE L'INDXATION
            
            //Déclaration des chaînes à extraire puis indexer
            String chaine = "How much will, will a will \nsmiTh smith, if @ will smith will smith will? \n A wiLL smith will\n smith as much will as a \nWILL smith will,\n if a will smith will smith will.";
            String chaine2 = "Have   you ever \n\ndanced with the devil \n in THE  pale moonlight? \nHAVE \nYOU ?";
            String chaine3 = "bonjour hello a \n ici moi.";

            //Déclaration de l'extracteur et de l'index
            Extracteur eS = new ExtracteurString();
            IndexImpl<String, Integer> index = new IndexImpl<>();

            //Méthode du processus extraction string -> indexation
            EIString(chaine, eS, index);
            EIString(chaine2, eS, new IndexImpl<>());

            //TEST DE LA CLASSE INDXIMPL SEULE
           /* System.out.println("TESTS DE LA CLASSE INDEXATION SEULE\n");

            IndexImpl<String, Integer> i = new IndexImpl<>();
            i.ajouter("Where", 1);
            i.ajouter("is", 2);
            i.ajouter("my", 3);
            i.ajouter("my", 9);
            i.ajouter("mind", 3);
            i.ajouter("mind", 4);
            i.ajouter("?", 2);

            System.out.println("Affichage de l'index :\n" + i.toString());
            i.supprimer("Where");
            System.out.println("Après suppresion de la clé Where :\n" + i.toString() + '\n');
            i.supprimer("mind", 3);
            System.out.println("Après suppresion de la valeur 3 de la clé mind :\n" + i.toString() + '\n');
            i.supprimer("mind", 4);
            System.out.println("Après suppresion de la valeur 4 de la clé mind :\n" + i.toString() + '\n');
            System.out.println("Recherche des valeurs de la clé my :\n" + i.rechercher("my") + '\n');
            System.out.println("Vérifier si la valeur 9 existe pour la clé my :\n" + i.rechercher("my", 9) + '\n');
            System.out.println("Nombre de clés :\n" + i.nbeCles() + '\n');
            System.out.println("Vérifier si l'index est vide :\n" + i.estVide() + '\n');
            System.out.println("Obtenir toutes les clés de l'index :\n" + i.obtenirCles() + '\n');
            i.vider();
            System.out.println("Affichage de l'index :\n" + i.toString());
*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void EIString(String chaine, Extracteur extracteurS, IndexImpl index) {
        InfosMot infoMot = new InfosMot();
        do {
            infoMot = extracteurS.getNext(chaine);
            if (infoMot == null) {
                break;
            }
            if (!infoMot.getMot().equals("")) {
                System.out.println(infoMot.toString());
                index.ajouter(infoMot.getMot().toLowerCase(), infoMot.getLigne());
            }
        } while (null != infoMot.getMot());
        System.out.println(index.toString());
    }

}

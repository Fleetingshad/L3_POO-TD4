package main;

import extraction.*;
import indexation.*;
import java.io.FileInputStream;

/**
 *
 * @author Lucie et Nicolas
 */
public class Main {

    /**
     * Classe de test, création d'index à partir de fichiers et chaines de
     * caractères
     *
     * @param args Paramètres éventuels de la méthode main
     */
    public static void main(String[] args) {
        try {

            //TEST DE LA CLASSE MAIN
            System.out.println("\nTESTS DE LA CLASSE MAIN - CREATION D'INDEXES APRES EXTRACTION\n");
            //Déclaration des chaînes à extraire puis indexer
            String chaine = "How much will, will a will \nsmiTh smith, if @ will smith will smith will? \n A wiLL smith will\n smith as much will as a \nWILL smith will,\n if a will smith will smith will.";
            String chaine2 = "Have   you ever \n\ndanced with the devil \n in THE  pale moonlight? \nHAVE \nYOU ?";
            String chaine3 = "Incroyable, " + '\r' + " on dirait \t de \n\n la \n\42MAGIE! ";
            String chaine4 = "Un tout petit chien, joli \n ronge un  joli petit os ;\nTout ce qui est petit est joli.";
            String chaine5 = chaine3 + chaine4;

            //Déclaration des fichiers à extraire puis indexer
            String path = "src/main/monFichierIn.txt";
            FileInputStream file = new FileInputStream(path);

            //Déclaration des extracteurs et des index
            IndexImpl<String, Integer> indexS = new IndexImpl<>();
            Extracteur eS = new ExtracteurString(chaine3);
            // Extracteur eS2 = new ExtracteurString(chaine2);  
            // Extracteur eS3 = new ExtracteurString(chaine3);

            IndexImpl<String, Integer> indexF = new IndexImpl<>();
            Extracteur eF = new ExtracteurFile(file);

            //TEST DE L'EXTRACTEUR FILE ET DE L'INDEXATION
            //Méthode du processus extraction file -> indexation
            System.out.println("Extraction puis indexation à partir d'un fichier : \n");
            EI(eF, indexF);

            //TEST DE L'EXTRACTEUR STRING ET DE L'INDEXATION
            //Méthode du processus extraction string -> indexation
            System.out.println("Extraction puis indexation à partir d'une chaine de caractères :  \n");
            EI(eS, indexS);
            //  EI(eS2, new IndexImpl<>());
            //  EI(eS3, new IndexImpl<>());

            //TEST DE LA CLASSE INDEXIMPL SEULE
            /*
            System.out.println("TESTS DE LA CLASSE INDEXATION SEULE\n");

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
            System.out.println("Vidage de l'index...affichage :\n" + i.toString());

            //TEST DE LA CLASSE INFOSMOT SEULE
            System.out.println("\nTESTS DE LA CLASSE INFOSMOT SEULE\n");
            InfosMot word = new InfosMot("Exemple", 0, 0);
            System.out.println(word.toString());
            */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Processus extraction - indexation
     *
     * @param extracteur une instance d'extracteur
     * @param index une instance d'indexImpl
     */
    public static void EI(Extracteur extracteur, IndexImpl index) {
        InfosMot infoMot = new InfosMot();
        do {
            infoMot = extracteur.getNext();
            if (infoMot == null) {
                break;
            }
            //Si on veut voir les infoMots avec leur colonne (fonctionnalité implementée mais inutilisée dans le cadre d'un index)
            //System.out.println(infoMot.toString());

            index.ajouter(infoMot.getMot().toLowerCase(), infoMot.getLigne());
        } while (null != infoMot.getMot());
        System.out.println(index.toString());
    }
}

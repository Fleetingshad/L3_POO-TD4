/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraction;

    
import java.io.*; 
import java.util.Scanner;

/**
 *
 * @author LUCIE
 */
public class ExtracteurFile extends ExtracteurAbstract{

    /**
     * Declaration du path du fichier.txt
     */
    private final static String CHEMIN_FICHIER_IN = "C:\\\\Users\\\\Nicol\\\\Documents\\\\NetBeansProjects\\\\\\L3_POO-TD4\\\\src\\\\monFichierIn.txt"; 

    /**
     * Constructeur par défaut de la classe ExtracteurFile
     */
    public ExtracteurFile() throws IOException{
        readFile();
    }

    /**
     * cette méthode gère la lecture d'un fichier texte
     * caractère par caractère
     * @return un StringBuilder contenant la liste des mots
     */
    public void readFile() throws IOException{
      int i;
      char carac;
      int monCompteurDeLigne = 1;
      int monCompteurDeColonne = 1;
      StringBuilder sb = new StringBuilder();
      FileInputStream in = null;
      try {
         in = new FileInputStream(CHEMIN_FICHIER_IN); 
         while((i = in.read())!=-1) {             
             //on récupère le caractère
             carac = (char)i;             
             //on regarde le caractère unicode du char courant
             if(!Character.isLetterOrDigit(carac)){ 
                 //fin d'un mot ici normalement donc faut instancier un infomot               
                 
                 InfosMot im = new InfosMot(sb.toString(),monCompteurDeLigne,(monCompteurDeColonne-sb.length()));
                 //on remet le stringbuilder à plat
                 System.out.println("\nINFOMOT : " + sb.toString() + " -> Ligne : " + monCompteurDeLigne+ " - Col : " + (monCompteurDeColonne-sb.length()));
                 sb.setLength(0);       
                  if(regexSautLigne(carac)){                      
                     monCompteurDeColonne=0; 
                     monCompteurDeLigne++;                      
                 }
             }else{  
                 //on étend le stringbuilder du caractère lu
                 if(!Character.isSpaceChar(carac)){
                    sb.append(carac);     
                 }                
             }
              
            //on incrémente le compteur de col
            monCompteurDeColonne++;
         }
      } catch(Exception e) {
            e.printStackTrace();
      }
      finally
      {
          //fermeture du flux FileInputStream
          if(in != null){
              in.close();
          }
      } 
    }
    
    public InfosMot getNext(String s){
    return null;
    }


}

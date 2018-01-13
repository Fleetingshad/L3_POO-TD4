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

    private int ligne;
    private int col;
    private String pathFile;
    
    /**
     * Constructeur de la classe 
     * 
     * @param pathFile le chemin du fichier que l'on souhaite extraire.
     */
    public ExtracteurFile(String pathFile){
        this.pathFile = pathFile;
        ligne = 1;
        col = 1;
    }
    /**
     * Accesseur sur le membre privé ligne.
     * 
     * @return le numéro de la ligne.
     */
    public int getLigne()
   {
       return this.ligne;
   }

    /**
     * Accesseur sur le membre privé col.
     * 
     * @return lé numéro de colonne.
     */
   public int getCol()
   {
       return this.col;
   }

   /**
    * Setteut pour le membre privé ligne.
    * 
    * @param ligne le nouveau numéro de ligne.
    */
   public void setLigne(int ligne)
   {
       this.ligne = ligne;
   }

   /**
    * Setteur pour le membre privé col.
    * 
    * @param col le nouveau numéro de col.
    */
   public void setCol(int col)
   {
       this.col = col;
   }

   /**
   * Extrait les mots d'un fichier texte
   *
   * @return un InfoMot
   */
   @Override
   public InfosMot getNext()
   { 
       int i = 0;
       char carac;
       StringBuilder sb = new StringBuilder();
       FileInputStream in = null;
       InfosMot im = null;
       try
       {
           try
           {
               //ouverture du fichier
               in = new FileInputStream(this.pathFile);
               while((i = in.read())!=-1)
               {                   
                   //on récupère le caractère
                   carac = (char)i;
                   //on regarde le caractère unicode du char courant
                   if(!Character.isLetterOrDigit(carac))
                   {
                       //construction du mot
                       im = new InfosMot(sb.toString(),ligne,(col-sb.length()));

                       System.out.println("\nINFOMOT : " + sb.toString() + " -> Ligne : " + ligne+ " - Col : " + (col-sb.length()));
                       sb.setLength(0);
                       if(regexSautLigne(carac))
                       {
                           ligne++;
                           setLigne(ligne);
                           setCol(0);
                       } 
                   }
                   else
                   {
                       //on étend le stringbuilder du caractère lu
                       if(!Character.isSpaceChar(carac))
                       {
                           sb.append(carac);
                       }
                   }
                   //on incrémente le compteur de col
                   col++;
               }
           }
           catch (Exception e)
           {
               e.printStackTrace();
           }
           finally
           {
               //fermeture du flux FileInputStream
               if(in != null)
               {
                   in.close();
               } 
           }
       }
       finally
       {
           return null;
       }
   }


}

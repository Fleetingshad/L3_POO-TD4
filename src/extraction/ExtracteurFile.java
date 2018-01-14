/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Lucie et Nicolas
 */
public class ExtracteurFile implements Extracteur {

    /**
     * Fichier dont on extrait les mots
     */
    private final FileInputStream file;

    /**
     * Ligne du mot extrait
     */
    private int ligne;

    /**
     * Colonne de la première lettre du mot extrait
     */
    private int col;

    /**
     * Constructeur de la classe ExtracteurFile, initialise les variables
     * d'instance
     *
     * @param file le fichier que l'on souhaite extraire.
     * @throws java.io.FileNotFoundException exception pouvant être renvoyée par la méthode
     */
    public ExtracteurFile(FileInputStream file) throws FileNotFoundException
    {
        this.file = file;
        this.ligne = 1;
        this.col = 0;
    }

    /**
     * Extrait les mots d'un fichier texte
     *
     * @return un InfoMot
     */
    @Override
    public InfosMot getNext()
    {
        StringBuilder sb = new StringBuilder();
        //Position dans le fichier
        int cursor = 0;
        try 
        {
            while ((cursor = this.file.read()) != -1 && Character.isLetterOrDigit((char) cursor))
            {
                //on insère le caractère dans la chaine
                sb.append((char) cursor);
                this.col++;
            }
            switch ((char) cursor)
            {
                case '\n':
                    this.ligne++;
                    this.col = 0;
                    break;
                default:
                    this.col++;
            }
            //Dans tous les cas, on avance d'un caractère dans la chaine
            if (sb.toString().equals("") && cursor != -1)
            {
                return this.getNext();
            }
            else if (cursor != -1)
            {
                return new InfosMot(sb.toString(), ligne, (col - sb.length()));
            }
            this.file.close();
        }
        catch (IOException e)
        {
            e.getMessage();
        }
        return null;
    }

}

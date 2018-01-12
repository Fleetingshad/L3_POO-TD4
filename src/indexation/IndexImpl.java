package indexation;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author LUCIE/
 *
 * /
 **
 * @param <K> Comparable K
 * @param <V> Comparable V
 */
public class IndexImpl<K extends Comparable<K>, V extends Comparable<V>> implements Index<K, V> {

    /**
     * SortedMap pour stocker les clés et les valeurs de l'index
     */
    private final SortedMap<K, List<V>> sortedMap;

    /**
     * Constructeur vide, par défaut implémentation de la SortedMap avec une
     * TreeMap
     */
    public IndexImpl() {
        this.sortedMap = new TreeMap<>(Collator.getInstance());
        
    }

    /**
     * Supprime une clé de l'index et les valeurs associées
     *
     * @param cle
     */
    @Override
    public void supprimer(K cle) {
        this.sortedMap.remove(cle);
    }

    /**
     * Supprime une valeur de l'index, supprime la clé si c'était la dernière
     * valeur pour cette clé
     *
     * @param cle
     * @param valeur
     */
    @Override
    public void supprimer(K cle, V valeur) {
        this.sortedMap.get(cle).remove(valeur);
        if (this.sortedMap.get(cle).isEmpty()) {
            this.supprimer(cle);
        }
    }

    /**
     * Ajoute une clé et une valeur à l'index, si la clé existe déjà, ajoute la
     * valeur à la clé existante
     *
     * @param cle
     * @param valeur
     */
    @Override
    public void ajouter(K cle, V valeur) {
        if (this.sortedMap.containsKey(cle) && !this.rechercher(cle, valeur)) {
            this.sortedMap.get(cle).add(valeur);
        } else if (!(this.sortedMap != null && this.sortedMap.containsKey(cle) && this.rechercher(cle, valeur))) {
            this.sortedMap.put(cle, new ArrayList<>());
            this.sortedMap.get(cle).add(valeur);
        }
    }

    /**
     * Retourne les valeurs d'une clé donnée
     *
     * @param cle
     * @return une Liste de valeurs
     */
    @Override
    public List<V> rechercher(K cle) {
        return this.sortedMap.get(cle);
    }

    /**
     * Vérifie si une clé contient la valeur passée en paramètre
     *
     * @param cle
     * @param valeur
     * @return un booléen vrai si l'index contient le couple clé-valeur donné en
     * paramètre
     */
    @Override
    public boolean rechercher(K cle, V valeur) {
        List<V> listeV = this.rechercher(cle);
        return listeV.contains(valeur);
    }

    /**
     * Retourne le nombre de clés de l'index
     *
     * @return la taille de l'index
     */
    @Override
    public int nbeCles() {
        return this.sortedMap.size();
    }

    /**
     * Vérifie si l'index est vide
     *
     * @return un bouléen vrai si l'index est vide
     */
    @Override
    public boolean estVide() {
        return this.sortedMap.isEmpty();
    }

    /**
     * Vide l'index
     */
    @Override
    public void vider() {
        this.sortedMap.clear();
    }

    /**
     * Renvoie l'ensemble des clés de l'index
     *
     * @return les clés de l'index
     */
    @Override
    public Set<K> obtenirCles() {
        return this.sortedMap.keySet();
    }

    /**
     * Retourne une chaine de caractères contenant les informations de l'index
     *
     * @return une chaîne de caractères
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (K key : this.obtenirCles()) {
            sb.append(key);
            sb.append(" : ");
            sb.append(this.rechercher(key));
            sb.append('\n');
        }
        return sb.toString();
    }

}

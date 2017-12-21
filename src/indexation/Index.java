package indexation;

/**
 *
 * @author LUCIE
 */
public interface Index<K extends Comparable<K>, V extends Comparable<V>>{
    
    public void supprimer(K cle);
    
    public void supprimer(K cle, V valeur);
    
    public void ajouter(K cle, V valeur);
    
    public V[] rechercher(K cle);
    
    public boolean rechercher(K cle, V valeur);
    
    public int nbeCles();
    
    public boolean estVide();
 
    public void vider();
    
    public K[] obtenirCles();
    
    @Override
    public String toString();
}

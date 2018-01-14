package extraction;

/**
 *
 * @author Lucie et Nicolas
 */
public interface Extracteur {

    /**
     * Renvoie le prochain mot lu par le code
     *
     * @return un InfosMot
     */
    public InfosMot getNext();
}

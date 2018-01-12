package extraction;

/**
 *
 * @author LUCIE
 */
public interface Extracteur {
    /**
     * Renvoie le prochain mot lu par le code
     * @param s String
     * @return InfosMot
     */
    public InfosMot getNext(String s);
}

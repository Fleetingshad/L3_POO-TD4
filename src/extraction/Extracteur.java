package extraction;

/**
 *
 * @author LUCIE
 */
public interface Extracteur {
    /**
     * Renvoie le prochain mot lu par le code
     * @return InfosMot
     */
    public InfosMot getNext(String s);
}

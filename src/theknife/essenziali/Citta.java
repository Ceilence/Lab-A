/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.essenziali;

/**
 * Rappresenta una città all'interno del sistema.
 * <p>
 * Ogni città è identificata da:
 *  <ul>
 *       <li>Il nome della città.</li>
 *      <li>La latitudine geografica.</li>
 *      <li>La longitudine geografica.</li>
 *  </ul>
 * </p>
 *
 * <p>
 * Questa classe può essere utilizzata per associare una posizione
 * a un {@link Utente} o a un ristorante, o per calcoli geografici.
 * </p>
 *
 * @see Utente
 */
public class Citta {
    
    private String nomeCitta;
    private double latCitta;
    private double lonCitta;

    /**
     * Costruttore della classe Citta.
     *
     * @param nomeCitta il nome della città
     * @param latCitta  la latitudine geografica
     * @param lonCitta  la longitudine geografica
     */
    public Citta(String nomeCitta, double latCitta, double lonCitta) {
        this.nomeCitta = nomeCitta;
        this.lonCitta = lonCitta;
        this.latCitta = latCitta;
    }

    /**
     * Restituisce il nome della città.
     *
     * @return il nome della città
     */
    public String getNomeCitta() {
        return nomeCitta;
    }

    /**
     * Restituisce la latitudine della città.
     *
     * @return la latitudine geografica
     */
    public double getLatCitta() {
        return latCitta;
    }

    /**
     * Restituisce la longitudine della città.
     *
     * @return la longitudine geografica
     */
    public double getLonCitta() {
        return lonCitta;
    }
}

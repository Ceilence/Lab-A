/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) - Sede: Como
 */
package theknife.essenziali;

/**
 * Rappresenta un ristorante segnato come "preferito" da un utente. <br>
 * Ogni preferito è identificato dalla coppia (idRistorante, idUtente).
 *
 * Questa classe viene utilizzata per gestire i dati contenuti in {@link ArchivioPreferiti}.
 */
public class Preferito {
    private int idRis;
    private int idUtente;

    /**
     * Costruisce un nuovo oggetto Preferito.
     *
     * @param idRis    l'ID del ristorante segnato come preferito
     * @param idUtente l'ID dell'utente che ha aggiunto il ristorante ai preferiti
     */
    public Preferito(int idRis, int idUtente) {
        this.idRis = idRis;
        this.idUtente = idUtente;
    }

    /** @return l'ID del ristorante segnato come preferito */
    public int getIdRis() {
        return idRis;
    }

    /** @param idRis imposta l'ID del ristorante */
    public void setIdRis(int idRis) {
        this.idRis = idRis;
    }

    /** @return l'ID dell'utente che ha aggiunto il ristorante ai preferiti */
    public int getIdUtente() {
        return idUtente;
    }

    /** @param idUtente imposta l'ID dell'utente */
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
    
    /**
     * Rappresentazione testuale del preferito, utile per salvataggio su file CSV. <br>
     * Formato: idRistorante § idUtente §
     *
     * @return una stringa con ID ristorante e utente separati da "§"
     */
    @Override
    public String toString() {
        return idRis + "§" + idUtente + "§";
    }

    /**
     * Due preferiti sono uguali se hanno lo stesso idRis e lo stesso idUtente.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        final Preferito other = (Preferito) obj;
        return this.idRis == other.idRis && this.idUtente == other.idUtente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}

/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.essenziali;

/**
 * Rappresenta un utente del sistema (cliente o ristoratore).
 * <p>
 * Ogni utente è identificato da:
 *  <ul>
 *      <li>Informazioni anagrafiche: nome, cognome, username.</li>
 *      <li>Dati di accesso: email e password.</li>
 *      <li>Dati di residenza: posizione e stato.</li>
 *      <li>ID univoco assegnato dal sistema.</li>
 *      <li>Ruolo: cliente oppure ristoratore.</li>
 *  </ul>
 * </p>
 *
 * <p>
 * La classe è collegata ad {@link ArchivioUtenti}, che gestisce l'aggiunta, la rimozione e l'autenticazione di un utente.
 * </p>
 *
 * @see ArchivioUtenti
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class Utente {
    
   /** Nome dell'utente {@code nomeUtente}. */
    private String nomeUtente;

    /** Cognome dell'utente {@code cognomeUtente}. */
    private String cognomeUtente;

    /** Username scelto dall'utente {@code usernameUtente}. */
    private String usernameUtente;

    /** Indirizzo email dell'utente {@code emailUtente}. */
    private String emailUtente;

    /** Password dell'utente {@code passUtente}. */
    private String passUtente;

    /** Posizione geografica (città) dell'utente {@code posizioneUtente}. */
    private String posizioneUtente;

    /** Stato (nazione) dell'utente {@code statoUtente}. */
    private String statoUtente;

    /** Identificativo univoco dell'utente {@code idUtente}. */
    private int idUtente;

    /** Ruolo assegnato all'utente nel sistema {@code ruoloUtente}. */
    private final String ruoloUtente;
    
    /**
     * Costruttore della classe Utente.
     * <p>Crea un nuovo oggetto utente con i dati forniti.</p>
     * 
     * @param nomeUtente      il nome dell'utente
     * @param cognomeUtente   il cognome dell'utente
     * @param usernameUtente  lo username scelto dall'utente
     * @param emailUtente     l'indirizzo email dell'utente
     * @param passUtente      la password dell'utente
     * @param posizioneUtente la posizione città associata all'utente
     * @param statoUtente     lo stato dell'utente
     * @param id              l'identificativo numerico univoco dell'utente
     * @param ruoloUtente     il ruolo assegnato all'utente (cliente o ristoratore)
     */
    public Utente(String nomeUtente, String cognomeUtente, String usernameUtente, String emailUtente, String passUtente, String posizioneUtente, String statoUtente, int id, String ruoloUtente) {
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.usernameUtente = usernameUtente;
        this.passUtente = passUtente;
        this.emailUtente = emailUtente;
        this.posizioneUtente = posizioneUtente;
        this.statoUtente = statoUtente;
        this.idUtente = id;
        this.ruoloUtente = ruoloUtente;
    }
    
    /** @return il ruolo dell'utente (cliente o ristoratore). */
    public String getRuoloUtente() {
        return ruoloUtente;
    }

    /** @return l'email dell'utente. */
    public String getEmailUtente() {
        return emailUtente;
    }

    /** @param emailUtente nuova email da assegnare all'utente. */
    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    /** @return il nome dell'utente. */
    public String getNomeUtente() {
        return nomeUtente;
    }

    /** @param nomeUtente nuovo nome da assegnare all'utente. */
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    /** @return il cognome dell'utente. */
    public String getCognomeUtente() {
        return cognomeUtente;
    }

    /** @param cognomeUtente nuovo cognome da assegnare all'utente. */
    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    /** @return lo username dell'utente. */
    public String getUsernameUtente() {
        return usernameUtente;
    }

    /** @param usernameUtente nuovo username da assegnare all'utente. */
    public void setUsernameUtente(String usernameUtente) {
        this.usernameUtente = usernameUtente;
    }

    /** @return la password dell'utente. */
    public String getPassUtente() {
        return passUtente;
    }

    /** @param passUtente nuova password da assegnare all'utente. */
    public void setPassUtente(String passUtente) {
        this.passUtente = passUtente;
    }

    /** @return la posizione associata all'utente. */
    public String getPosizioneUtente() {
        return posizioneUtente;
    }

    /** @param posizioneUtente nuova posizione da assegnare all'utente. */
    public void setPosizioneUtente(String posizioneUtente) {
        this.posizioneUtente = posizioneUtente;
    }

    /** @return lo stato associato all'utente. */
    public String getStatoUtente() {
        return statoUtente;
    }

    /** @param statoUtente nuovo stato da assegnare all'utente. */
    public void setStatoUtente(String statoUtente) {
        this.statoUtente = statoUtente;
    }
    
    /** @return l'identificativo univoco dell'utente. */
    public int getIdUtente() {
        return idUtente;
    }

    /** @param idUtente nuovo identificativo da assegnare all'utente. */
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
    
    /**
     * Restituisce una rappresentazione testuale dell'utente
     * nel formato utilizzato per il salvataggio su file CSV.
     *
     * @return stringa con i campi separati da '§'
     */
    @Override
    public String toString() {
        return nomeUtente + "§" + cognomeUtente + "§" +
               usernameUtente + "§" + emailUtente + "§" +
               passUtente + "§" + posizioneUtente + "§" +
               statoUtente + "§" + idUtente + "§" + ruoloUtente + "§";
    }
}

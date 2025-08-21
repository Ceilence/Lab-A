/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

/**
 *
 * @author davim antoniopardo alefrigio
 */
public class Utente{
    private String nomeUtente;
    private String cognomeUtente;
    private String usernameUtente;
    private String emailUtente;
    private String passUtente;
    private String posizioneUtente;
    private String statoUtente;
    private int idUtente;
    private final String ruoloUtente;
    
    /**
     * Costruttore della classe {@code Utente}.
     * Crea un nuovo oggetto utente con i dati forniti.
     * 
     * @param nomeUtente      il nome dell'utente
     * @param cognomeUtente   il cognome dell'utente
     * @param usernameUtente  lo username scelto dall'utente
     * @param emailUtente     l'indirizzo email dell'utente
     * @param passUtente      la password dell'utente
     * @param posizioneUtente la posizione o luogo di domicilio associato all'utente
     * @param statoUtente     lo stato di domicilio dell'utente
     * @param id              l'identificativo univoco dell'utente
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
    
    public String getRuoloUtente() {
        return ruoloUtente;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getCognomeUtente() {
        return cognomeUtente;
    }

    public void setCognomeUtente(String cognomeUtente) {
        this.cognomeUtente = cognomeUtente;
    }

    public String getUsernameUtente() {
        return usernameUtente;
    }

    public void setUsernameUtente(String usernameUtente) {
        this.usernameUtente = usernameUtente;
    }

    public String getPassUtente() {
        return passUtente;
    }

    public void setPassUtente(String passUtente) {
        this.passUtente = passUtente;
    }

    public String getPosizioneUtente() {
        return posizioneUtente;
    }

    public void setPosizioneUtente(String posizioneUtente) {
        this.posizioneUtente = posizioneUtente;
    }

    public String getStatoUtente() {
        return statoUtente;
    }

    public void setStatoUtente(String statoUtente) {
        this.statoUtente = statoUtente;
    }
    
    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
    
    @Override
    public String toString() {
        return 
        nomeUtente + "§" + cognomeUtente + "§" + 
        usernameUtente + "§" + emailUtente + "§" + 
        passUtente + "§" + posizioneUtente + "§" + 
        statoUtente + "§" + idUtente + "§" + ruoloUtente + "§";
    }
}

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
    private int idUtente;
    private String ruoloUtente;

    public Utente(String nomeUtente, String cognomeUtente, String usernameUtente, String emailUtente, String passUtente, String posizioneUtente, int id, String ruoloUtente) {
        this.nomeUtente = nomeUtente;
        this.cognomeUtente = cognomeUtente;
        this.usernameUtente = usernameUtente;
        this.passUtente = passUtente;
        this.emailUtente = emailUtente;
        this.posizioneUtente = posizioneUtente;
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
        idUtente + "§" + ruoloUtente + "§";
    }
}

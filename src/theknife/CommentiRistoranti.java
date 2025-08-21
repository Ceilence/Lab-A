/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

/**
 *
 * @author davim
 */
public class CommentiRistoranti {
    private String tipoCommento;
    private int idScrittore;
    private String testo;
    private int idCommento;
    private String titolo;
    private int idRistorante;
    private int valutazione;
    private boolean haRisposta;
    private boolean daLeggere;
    
    /**
     * Recensioni
     */
    public CommentiRistoranti(int idScrittore, String testo, int idCommento, String titolo, int idRistorante, int valutazione, boolean haRisposta, boolean daLeggere) {
        this.tipoCommento = "recensione";
        this.idScrittore = idScrittore;
        this.testo = testo;
        this.titolo = titolo;
        this.idCommento = idCommento;
        this.idRistorante = idRistorante;
        this.valutazione = valutazione;
        this.haRisposta = haRisposta;
        this.daLeggere = daLeggere;
    }
    
    /**
     * Risposte
     */
    public CommentiRistoranti(int idScrittore, String testo, int idCommento) {
        this.tipoCommento = "risposta";
        this.idScrittore = idScrittore;
        this.testo = testo;
        this.idCommento = idCommento; 
    }

    public String getTipoCommento() {
        return tipoCommento;
    }

    public void setTipoCommento(String tipoCommento) {
        this.tipoCommento = tipoCommento;
    }

    public int getIdScrittore() {
        return idScrittore;
    }

    public void setIdScrittore(int idScrittore) {
        this.idScrittore = idScrittore;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
    public Integer getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(Integer idCommento) {
        this.idCommento = idCommento;
    }
    
    public Integer getIdRistorante() {
        return idRistorante;
    }

    public void setIdRistorante(Integer idRistorante) {
        this.idRistorante = idRistorante;
    }

    public boolean isDaLeggere() {
        return daLeggere;
    }

    public void setDaLeggere(boolean daLeggere) {
        this.daLeggere = daLeggere;
    }

    public Integer getValutazione() {
        return valutazione;
    }

    public void setValutazione(Integer valutazione) {
        this.valutazione = valutazione;
    }

    public boolean haRisposta() {
        return haRisposta;
    }

    public void setHaRisposta(boolean haRisposta) {
        this.haRisposta = haRisposta;
    }
    
    public boolean isRisposta() {
        return "risposta".equals(tipoCommento);
    }
    
    @Override
    public String toString() {
        if ("recensione".equals(tipoCommento)){
            return tipoCommento + "§" + idScrittore + "§" + testo + "§" + idCommento + "§" + 
                titolo + "§" + idRistorante + "§" + valutazione + "§" + haRisposta + "§" + daLeggere + "§";
        } else {
            return tipoCommento + "§" + idScrittore + "§" + testo + "§" + idCommento + "§";
        }
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    CommentiRistoranti other = (CommentiRistoranti) obj;
    return this.idCommento == other.idCommento;
    }

    @Override
    public int hashCode() {
    return Integer.hashCode(idCommento);
    } 
}

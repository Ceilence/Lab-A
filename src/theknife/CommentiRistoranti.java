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
    private boolean daLeggere;
    private int valutazione;
    
    /**
     * Recensioni
     */
    public CommentiRistoranti(int idScrittore, String testo, int idCommento, int valutazione, boolean daLeggere) {
        this.tipoCommento = "recensione";
        this.idScrittore = idScrittore;
        this.testo = testo;
        this.idCommento = idCommento;
        this.valutazione = valutazione;
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
    
    public Integer getIdCommento() {
        return idCommento;
    }

    public void setIdCommento(Integer idCommento) {
        this.idCommento = idCommento;
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
    
    public boolean isRisposta() {
        return "risposta".equals(tipoCommento);
    }
    
    @Override
    public String toString() {
        if ("recensione".equals(tipoCommento)){
            return tipoCommento + "§" + idScrittore + "§" + testo + "§" + 
                  idCommento + "§" + valutazione + "§" + daLeggere + "§";
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

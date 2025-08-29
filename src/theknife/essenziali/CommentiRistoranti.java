/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) - Sede: Como
 */
package theknife.essenziali;

/**
 * Rappresenta un commento relativo a un ristorante. <br>
 * Un commento può essere di due tipi:
 *  <ul>
 *      <li><b>recensione</b>: include titolo, valutazione e id del ristorante</li>
 *      <li><b>risposta</b>: risposta del ristoratore senza valutazione</li>
 *  </ul>
 *
 * I commenti vengono identificati tramite idCommento.
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
     * Costruttore per creare una recensione di un ristorante.
     *
     * @param idScrittore  l'ID dell'utente che ha scritto la recensione
     * @param testo        il contenuto testuale della recensione
     * @param idCommento   identificativo del commento
     * @param titolo       titolo della recensione
     * @param idRistorante ID del ristorante recensito
     * @param valutazione  valutazione numerica assegnata al ristorante
     * @param haRisposta   true se la recensione ha ricevuto risposta
     * @param daLeggere    true se la recensione deve ancora essere letta
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
     * Costruttore per creare una risposta a un commento/recensione.
     *
     * @param idScrittore l'ID dell'utente che ha scritto la risposta
     * @param testo       il contenuto testuale della risposta
     * @param idCommento  identificativo del commento
     */
    public CommentiRistoranti(int idScrittore, String testo, int idCommento) {
        this.tipoCommento = "risposta";
        this.idScrittore = idScrittore;
        this.testo = testo;
        this.idCommento = idCommento; 
        this.haRisposta = false;
    }

    /** @return il tipo di commento: "recensione" o "risposta" */
    public String getTipoCommento() { 
        return tipoCommento; 
    }
    
    public void setTipoCommento(String tipoCommento) { 
        this.tipoCommento = tipoCommento; 
    }

    /** @return l'ID dello scrittore del commento */
    public int getIdScrittore() { 
        return idScrittore; 
    }
    public void setIdScrittore(int idScrittore) { 
        this.idScrittore = idScrittore; 
    }

    /** @return il testo del commento */
    public String getTesto() { 
        return testo; 
    }
    public void setTesto(String testo) { 
        this.testo = testo; 
    }

    /** @return il titolo della recensione (solo se {@link #isRisposta()} è false) */
    public String getTitolo() { 
        return titolo; 
    }
    public void setTitolo(String titolo) { 
        this.titolo = titolo; 
    }
    
    /** @return l'ID univoco del commento */
    public Integer getIdCommento() { 
        return idCommento; 
    }
    public void setIdCommento(Integer idCommento) { 
        this.idCommento = idCommento; 
    }
    
    /** @return l'ID del ristorante associato (solo recensioni) */
    public Integer getIdRistorante() { 
        return idRistorante; 
    }
    public void setIdRistorante(Integer idRistorante) { 
        this.idRistorante = idRistorante; 
    }

    /** @return true se il commento è ancora da leggere */
    public boolean isDaLeggere() { 
        return daLeggere; 
    }
    public void setDaLeggere(boolean daLeggere) { 
        this.daLeggere = daLeggere; 
    }

    /** @return la valutazione numerica (solo recensioni) */
    public Integer getValutazione() { 
        return valutazione; 
    }
    public void setValutazione(Integer valutazione) { 
        this.valutazione = valutazione; 
    }

    /** @return true se la recensione ha ricevuto risposta */
    public boolean haRisposta() { 
        return haRisposta; 
    }
    public void setHaRisposta(boolean haRisposta) { 
        this.haRisposta = haRisposta; 
    }
    
    /** @return true se il commento è una risposta */
    public boolean isRisposta() { 
        return "risposta".equals(tipoCommento); 
    }
    
    /**
     * Rappresentazione testuale del commento per salvataggio su file CSV.
     *
     * @return una stringa contenente i dati principali del commento
     */
    @Override
    public String toString() {
        if ("recensione".equals(tipoCommento)){
            return tipoCommento + "§" + idScrittore + "§" + testo + "§" + idCommento + "§" + 
                   titolo + "§" + idRistorante + "§" + valutazione + "§" + haRisposta + "§" + daLeggere + "§";
        } else {
            return tipoCommento + "§" + idScrittore + "§" + testo + "§" + idCommento + "§";
        }
    }
}


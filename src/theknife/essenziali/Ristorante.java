/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) - Sede: Como
 */
package theknife.essenziali;

import java.util.ArrayList;

/**
 * Rappresenta un ristorante all'interno del sistema.
 * <p>
 * Ogni ristorante è identificato da:
 *  <ul>
 *      <li>Nome e indirizzo</li>
 *      <li>Località e stato</li>
 *      <li>Fascia di prezzo e tipo di cucina</li>
 *      <li>Coordinate geografiche (latitudine e longitudine)</li>
 *      <li>Numero di telefono</li>
 *      <li>Media delle stelle, servizi disponibili (delivery, prenotazione online)</li>
 *      <li>Descrizione, ID ristorante e ID ristoratore</li>
 *  </ul>
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class Ristorante {
    
    /** Nome del ristorante {@code nomeRis}. */
    private String nomeRis;

    /** Indirizzo del ristorante {@code indRis}. */
    private String indRis;

    /** Località (città) del ristorante {@code locRis}. */
    private String locRis;

    /** Stato (nazione) in cui si trova il ristorante {@code statoRis}. */
    private String statoRis;

    /** Fascia di prezzo del ristorante {@code priceRis}. */
    private String priceRis;

    /** Tipo di cucina offerta dal ristorante {@code cuisRis}. */
    private String cuisRis;

    /** Longitudine geografica del ristorante {@code longRis}. */
    private double longRis;

    /** Latitudine geografica del ristorante {@code latRis}. */
    private double latRis;

    /** Numero di telefono del ristorante {@code pnRis}. */
    private String pnRis;

    /** Media delle valutazioni in stelle del ristorante {@code mediaStelleRis}. */
    private double mediaStelleRis;

    /** Indica se il ristorante offre servizio delivery {@code delivery}. */
    private boolean delivery;

    /** Indica se il ristorante consente la prenotazione online {@code prenotaOnline}. */
    private boolean prenotaOnline;

    /** Descrizione testuale del ristorante {@code desRis}. */
    private String desRis;

    /** Identificativo univoco del ristorante {@code idRis}. */
    private int idRis;

    /** Identificativo dell'utente ristoratore associato al ristorante {@code idRistoratore}. */
    private int idRistoratore;

    /**
     * Costruttore della classe Ristorante.
     *
     * @param nomeRis        il nome del ristorante
     * @param indRis         l'indirizzo del ristorante
     * @param locRis         la località (città) del ristorante
     * @param statoRis       lo stato del ristorante
     * @param priceRis       fascia di prezzo del ristorante
     * @param cuisRis        tipo di cucina
     * @param longRis        longitudine geografica
     * @param latRis         latitudine geografica
     * @param pnRis          numero di telefono
     * @param mediaStelleRis media delle stelle del ristorante
     * @param delivery       true se è disponibile il servizio delivery
     * @param prenotaOnline  true se è possibile prenotare online
     * @param desRis         descrizione del ristorante
     * @param idRis          identificativo univoco del ristorante
     * @param idRistoratore  identificativo dell'utente ristoratore
     */
    public Ristorante(String nomeRis, String indRis, String locRis, String statoRis, String priceRis, String cuisRis, double longRis, double latRis, String pnRis, double mediaStelleRis, boolean delivery, boolean prenotaOnline, String desRis, int idRis, int idRistoratore) {
        this.nomeRis = nomeRis;
        this.indRis = indRis;
        this.locRis = locRis;
        this.statoRis = statoRis;
        this.priceRis = priceRis;
        this.cuisRis = cuisRis;
        this.longRis = longRis;
        this.latRis = latRis;
        this.pnRis = pnRis;
        this.mediaStelleRis = mediaStelleRis;
        this.delivery = delivery;
        this.prenotaOnline = prenotaOnline;
        this.desRis = desRis;
        this.idRis = idRis;
        this.idRistoratore = idRistoratore;
    }

    /** @return il nome del ristorante */
    public String getNomeRis() { 
        return nomeRis; 
    }
    public void setNomeRis(String nomeRis) { 
        this.nomeRis = nomeRis; 
    }

    /** @return l'indirizzo del ristorante */
    public String getIndRis() { 
        return indRis; 
    }
    public void setIndRis(String indRis) { 
        this.indRis = indRis; 
    }

    /** @return la località del ristorante */
    public String getLocRis() { 
        return locRis; 
    }
    public void setLocRis(String locRis) { 
        this.locRis = locRis; 
    }

    /** @return lo stato del ristorante */
    public String getStatoRis() { 
        return statoRis; 
    }
    public void setStatoRis(String statoRis) { 
        this.statoRis = statoRis; 
    }

    /** @return la fascia di prezzo del ristorante */
    public String getPriceRis() { 
        return priceRis; 
    }
    public void setPriceRis(String priceRis) { 
        this.priceRis = priceRis; 
    }

    /** @return il tipo di cucina del ristorante */
    public String getCuisRis() { 
        return cuisRis; 
    }
    public void setCuisRis(String cuisRis) { 
        this.cuisRis = cuisRis; 
    }

    /** @return la longitudine geografica */
    public double getLongRis() { 
        return longRis; 
    }
    public void setLongRis(double longRis) { 
        this.longRis = longRis; 
    }

    /** @return la latitudine geografica */
    public double getLatRis() { 
        return latRis; 
    }
    public void setLatRis(double latRis) { 
        this.latRis = latRis; 
    }

    /** @return il numero di telefono */
    public String getPnRis() { 
        return pnRis; 
    }
    public void setPnRis(String pnRis) { 
        this.pnRis = pnRis; 
    }

    /** @return la media delle stelle del ristorante */
    public double getMediaStelleRis() { 
        return mediaStelleRis; 
    }
    public void setMediaStelleRis(double mediaStelleRis) { 
        this.mediaStelleRis = mediaStelleRis; 
    }

    /** @return true se è disponibile delivery */
    public boolean isDelivery() { 
        return delivery; 
    }
    public void setDelivery(boolean delivery) { 
        this.delivery = delivery; 
    }

    /** @return true se è possibile prenotare online */
    public boolean isPrenotaOnline() { 
        return prenotaOnline; 
    }
    public void setPrenotaOnline(boolean prenotaOnline) { 
        this.prenotaOnline = prenotaOnline; 
    }

    /** @return la descrizione del ristorante */
    public String getDesRis() { 
        return desRis; 
    }
    public void setDesRis(String desRis) { 
        this.desRis = desRis; 
    }

    /** @return l'identificativo univoco del ristorante */
    public int getIdRis() { 
        return idRis; 
    }
    public void setIdRis(int idRis) { 
        this.idRis = idRis; 
    }

    /** @return l'ID dell'utente ristoratore */
    public int getIdRistoratore() { 
        return idRistoratore; 
    }
    public void setIdRistoratore(int idRistoratore) { 
        this.idRistoratore = idRistoratore; 
    }

    /**
     * Restituisce una rappresentazione testuale del ristorante, utile per il salvataggio su file.
     * @return stringa formattata contenente tutti i dati principali separati da "§"
     */
    @Override
    public String toString () {
        return nomeRis + "§" + indRis + "§" + locRis + "§" +
               statoRis.trim() + "§" + priceRis + "§" + cuisRis + "§" +
               longRis + "§" + latRis + "§" + pnRis + "§" + mediaStelleRis + "§" +
               delivery + "§" + prenotaOnline + "§" + desRis + "§" + idRis + "§" + idRistoratore + "§";      
    }
}

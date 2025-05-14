/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;
import java.util.ArrayList;

/**
 *
 * @author SSSSUGOI
 */
public class Ristorante {
    
    private String nomeRis;
    private String indRis;
    private String locRis;
    private String priceRis;
    private String cuisRis;
    private double longRis;
    private double latRis;
    private String pnRis;
    private int mediaStelleRis;
    private boolean delivery;
    private boolean prenotaOnline;
    private String desRis;
    private int idRis;

    public Ristorante(String nomeRis, String indRis, String locRis, String priceRis, String cuisRis, double longRis, double latRis, String pnRis, int mediaStelleRis, boolean delivery, boolean prenotaOnline, String desRis, int idRis) {
        this.nomeRis = nomeRis;
        this.indRis = indRis;
        this.locRis = locRis;
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
    }

    public String getNomeRis() {
        return nomeRis;
    }

    public void setNomeRis(String nomeRis) {
        this.nomeRis = nomeRis;
    }

    public String getIndRis() {
        return indRis;
    }

    public void setIndRis(String indRis) {
        this.indRis = indRis;
    }

    public String getLocRis() {
        return locRis;
    }

    public void setLocRis(String locRis) {
        this.locRis = locRis;
    }

    public String getPriceRis() {
        return priceRis;
    }

    public void setPriceRis(String priceRis) {
        this.priceRis = priceRis;
    }

    public String getCuisRis() {
        return cuisRis;
    }

    public void setCuisRis(String cuisRis) {
        this.cuisRis = cuisRis;
    }

    public double getLongRis() {
        return longRis;
    }

    public void setLongRis(double longRis) {
        this.longRis = longRis;
    }

    public double getLatRis() {
        return latRis;
    }

    public void setLatRis(double latRis) {
        this.latRis = latRis;
    }

    public String getPnRis() {
        return pnRis;
    }

    public void setPnRis(String pnRis) {
        this.pnRis = pnRis;
    }

    public int getMediaStelleRis() {
        return mediaStelleRis;
    }

    public void setMediaStelleRis(int mediaStelleRis) {
        this.mediaStelleRis = mediaStelleRis;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public boolean isPrenotaOnline() {
        return prenotaOnline;
    }

    public void setPrenotaOnline(boolean prenotaOnline) {
        this.prenotaOnline = prenotaOnline;
    }

    public String getDesRis() {
        return desRis;
    }

    public void setDesRis(String desRis) {
        this.desRis = desRis;
    }

    public int getIdRis() {
        return idRis;
    }

    public void setIdRis(int idRis) {
        this.idRis = idRis;
    }

    
    
    @Override
    public String toString () {
        return nomeRis + "§" + indRis + "§" + locRis + "§" + 
               priceRis + "§" + cuisRis + "§" + longRis + "§" + 
               latRis + "§" + pnRis + "§" + mediaStelleRis + "§" +
               delivery + "§" + prenotaOnline + "§" + desRis + "§" + idRis + "§";      
    }
}

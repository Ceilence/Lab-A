/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

/**
 *
 * @author davim
 */
public class Citta {
    private String nomeCitta;
    private double latCitta;
    private double lonCitta;

    public Citta(String nomeCitta, double latCitta, double lonCitta) {
        this.nomeCitta = nomeCitta;
        this.lonCitta = lonCitta;
        this.latCitta = latCitta;
    }

        
    public String getNomeCitta() {
        return nomeCitta;
    }

    public double getLatCitta() {
        return latCitta;
    }

    public double getLonCitta() {
        return lonCitta;
    }
}

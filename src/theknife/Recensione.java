/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

/**
 *
 * @author davim
 */
public class Recensione {
    private String recensione;
    private int valutazione;
    private int idUtente;
    private int idRis;

    public Recensione(String recensione, int valutazione, int idUtente, int idRis) {
        this.recensione = recensione;
        this.valutazione = valutazione;
        this.idUtente = idUtente;
        this.idRis = idRis;
    }

    public String getRecensione() {
        return recensione;
    }

    public void setRecensione(String recensione) {
        this.recensione = recensione;
    }

    public void setValutazione(int valutazione) {
        this.valutazione = valutazione;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdRis() {
        return idRis;
    }

    public void setIdRis(int idRis) {
        this.idRis = idRis;
    }
    
    @Override
    public String toString() {
        return recensione + "§" + 
               valutazione + "§" + 
               idUtente + "§" +
               idRis + "§";
    }
}

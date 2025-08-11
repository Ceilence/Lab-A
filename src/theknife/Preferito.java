/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

import java.util.*;

/**
 *
 * @author davim
 */
public class Preferito {
    private int idRis;
    private int idUtente;

    public Preferito(int idRis, int idUtente) {
        this.idRis = idRis;
        this.idUtente = idUtente;
    }

    public int getIdRis() {
        return idRis;
    }

    public void setIdRis(int idRis) {
        this.idRis = idRis;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
    
    @Override
    public String toString() {
        return idRis + "§" + idUtente + "§";
    }
    
    @Override
    public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Preferito)) return false;
    Preferito other = (Preferito) o;
    return this.idRis == other.idRis &&
           this.idUtente == other.idUtente;
    }

    @Override
    public int hashCode() {
    return Objects.hash(idRis, idUtente);
    }

}

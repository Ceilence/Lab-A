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

    /**
     * 
     * @param idRis
     * @param idUtente 
     */
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
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Preferito other = (Preferito) obj;
        if (this.idRis != other.idRis) {
            return false;
        }
        return this.idUtente == other.idUtente;
    }
    
    
}

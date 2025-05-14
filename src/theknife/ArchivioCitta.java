/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

import java.io.*;
import java.util.*;

/**
 *
 * @author davim
 */
public class ArchivioCitta {
    
    private final String FILE_PATH = "data\\Citta.csv";
    private String stringInserita = "";
            
    private final ArrayList<Citta> listaCitta = new ArrayList<>();
    private final ArrayList<Citta> filtrate = new ArrayList<>();
    
    public ArchivioCitta() {}
    
    public void leggiArchivio() {
        listaCitta.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                String nomeCitta = token.nextToken();
                double latCitta = Double.parseDouble(token.nextToken());
                double lonCitta = Double.parseDouble(token.nextToken());
                
                listaCitta.add(new Citta(nomeCitta, latCitta, lonCitta));
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    public boolean continuaRicerca(String s) {
        if (s.equals(stringInserita) || s.startsWith(stringInserita)) {
            this.stringInserita = s;
            return true; 
        } else {     
            this.stringInserita = s;
            return false;
        }
    }
    
    public boolean uguale(Citta a, Citta b) {
        return (a.getNomeCitta().equals(b.getNomeCitta()) 
                && a.getLatCitta() == b.getLatCitta () 
                && a.getLonCitta() == b.getLonCitta());
    }
    
    public boolean giaInserita(Citta c) {
        for (Citta f : listaCitta) {
            if (uguale(f, c)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Citta> getCercate(String s) {
        if (!continuaRicerca(s)) {
            filtrate.clear();
        }
        for (Citta f : listaCitta) {
            if (!giaInserita(f)) {
                if (f.getNomeCitta().startsWith(s)) {
                    filtrate.add(f);
                }
            }
        }
        return filtrate;
    }
}

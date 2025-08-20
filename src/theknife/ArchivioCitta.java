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
    private static final double RAGGIO_TERRA_KM = 6371;
            
    private final ArrayList<Citta> listaCitta = new ArrayList<>();
    
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
    
    //Restituisce la città
    public Citta getCitta(String nome) {
    for (Citta c : listaCitta) {
        String s = nome.trim().toLowerCase();
        if (s.equals(c.getNomeCitta().trim().toLowerCase())) {
            return c;
        }
    }
        return null; 
    }
    
    //Formula di Haversine per calcolare la distanza in km data latitudine e longitudine di 2 città
    public double calcolaDistanza(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return RAGGIO_TERRA_KM * c;
    }
}

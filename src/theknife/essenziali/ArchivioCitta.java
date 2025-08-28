/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.essenziali;

import theknife.essenziali.Citta;
import java.io.*;
import java.util.*;

/**
 * Gestisce l'archivio delle Città.
 * <p>
 * Questa classe si occupa di:
 *  <ul>
 *      <li>Leggere i dati delle città da un file CSV.</li>
 *      <li>Fornire l'accesso alle città registrate in memoria.</li>
 *      <li>Calcolare la distanza geografica tra due coordinate (formula dell'Haversine).</li>
 *  </ul>
 * </p>
 * 
 * <p>Il file di riferimento è: data\Citta.csv, con formato righe: <br>
 * @code NomeCittà § Latitudine § Longitudine</p>
 * 
 * @see Citta
 */
public class ArchivioCitta {
    
    private final String FILE_PATH = "data\\Citta.csv";
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
    
    /**
     * 
     * @param nome 
     * @return  
     */
    public Citta getCitta(String nome) {
    for (Citta c : listaCitta) {
        String s = nome.trim().toLowerCase();
        if (s.equals(c.getNomeCitta().trim().toLowerCase())) {
            return c;
        }
    }
        return null; 
    }
    
    /**
     * 
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return 
     */
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

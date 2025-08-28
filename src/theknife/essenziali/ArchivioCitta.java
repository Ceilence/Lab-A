/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.essenziali;

import theknife.essenziali.Citta;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Gestisce l'archivio delle {@link Citta}.
 * <p>
 * Questa classe si occupa di:
 *  <ul>
 *      <li>Leggere i dati delle città da un file CSV.</li>
 *      <li>Fornire l'accesso alle città registrate in memoria.</li>
 *      <li>Calcolare la distanza geografica tra due coordinate (formula di Haversine).</li>
 *  </ul>
 * </p>
 * 
 * <p>Il file letto dall'archivio è: data\Citta.csv, e contiene i seguenti token: <br>
 * NomeCittà § Latitudine § Longitudine 
 * </p>
 * 
 * @see Citta
 */
public class ArchivioCitta {
    
    /** Percorso del file CSV contenente i dati delle città. */
    private final String FILE_PATH = "data\\Citta.csv";
    
    /** Raggio medio della Terra in chilometri (usato per il calcolo delle distanze). */
    private static final double RAGGIO_TERRA_KM = 6371;
       
    /** Lista delle città caricate dall'archivio. */
    private final ArrayList<Citta> listaCitta = new ArrayList<>();
    
    /**
     * Costruttore vuoto.
     * <p>
     *  Inizializza un archivio delle città senza caricare automaticamente i dati. 
     *  Per compilare l'archivio occorre chiamare il metodo {@link #leggiArchivio()}.
     * </p>
     */
    public ArchivioCitta() {}
    
    /**
     * Legge l'archivio delle città dal file CSV e aggiorna la lista interna.
     * <p>
     *  Se il file non esiste o si verifica un errore di I/O, viene mostrato un messaggio di errore.
     * </p>
     */
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
            JOptionPane.showMessageDialog(null, "Errore: archivio città non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Restituisce l'oggetto {@link Citta} corrispondente al nome specificato.
     *
     * @param nome nome della città da cercare.
     * @return la {@link Citta} trovata, oppure "null" se non presente.
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
     * Calcola la distanza in chilometri tra due coordinate geografiche utilizzando la formula di Haversine.
     *
     * @param lat1 latitudine del primo punto.
     * @param lon1 longitudine del primo punto.
     * @param lat2 latitudine del secondo punto.
     * @param lon2 longitudine del secondo punto.
     * @return distanza in chilometri tra i due punti.
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

/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.essenziali;

import com.sun.tools.javac.Main;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Gestisce l'archivio dei ristoranti.
 * <p>
 * Questa classe si occupa di:
 *  <ul>
 *      <li>Caricare i ristoranti da un file CSV.</li>
 *      <li>Aggiungere o rimuovere ristoranti.</li>
 *      <li>Generare ID unici per nuovi ristoranti.</li>
 *      <li>Gestire il ristorante attualmente selezionato.</li>
 *  </ul>
 *
 * <p>
 * Il file di riferimento è: data\Ristoranti.csv, e contiene i seguenti token:
 * con righe salvate nel formato generato da {@link Ristorante#toString()}.
 *
 * @see Ristorante
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class ArchivioRis {
    
    /** Percorso del file CSV dei ristoranti. {@code FILE_PATH}*/
    private static final String FILE_PATH = "data/Ristoranti.csv";
    
    /** Ristorante attualmente selezionato. {@code risAttuale}*/
    private Ristorante risAttuale;
    
    /** Lista di tutti i ristoranti caricati. {@code listaRis}*/
    private final ArrayList<Ristorante> listaRis = new ArrayList<>();
   
    /**
     * Costruttore vuoto.
     * <p>Inizializza un archivio senza caricare automaticamente i dati.
     */
    public ArchivioRis() {}
    
    /**
     * Cerca il file .csv da cui leggere i dati.
     * 
     * @return il file trovato.
     */
    public static File getDataFile() {
        String jarDir = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getAbsolutePath();
        return new File(jarDir, FILE_PATH);
    }
    
    /**
     * Legge l'archivio dei ristoranti dal file CSV e compila la lista interna.
     */
    public void leggiArchivio() {
        listaRis.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                
                String nomeRis = token.nextToken();
                String indRis = token.nextToken();
                String locRis = token.nextToken();
                String statoRis = token.nextToken();
                String priceRis = token.nextToken();
                String cuisRis = token.nextToken();
                double longRis = Double.parseDouble(token.nextToken());
                double latRis = Double.parseDouble(token.nextToken());
                String telRis = token.nextToken();
                double mediaStelleRis = Double.parseDouble(token.nextToken());
                boolean delivery = Boolean.parseBoolean(token.nextToken());
                boolean prenotaOnline = Boolean.parseBoolean(token.nextToken());
                String desRis = token.nextToken();
                int idRis = Integer.parseInt(token.nextToken());
                int idRistoratore = Integer.parseInt(token.nextToken());

                listaRis.add(new Ristorante(
                        nomeRis, indRis, locRis, statoRis,
                        priceRis, cuisRis, longRis, latRis,
                        telRis, mediaStelleRis, delivery, prenotaOnline,
                        desRis, idRis, idRistoratore
                ));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio ristoranti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Aggiunge un ristorante all'archivio e aggiorna il file.
     *
     * @param ris ristorante da aggiungere
     */
    public void aggiungiRis(Ristorante ris) {
        listaRis.add(ris);
        aggiornaRis();
    }
    
    /**
     * Rimuove un ristorante dall'archivio e aggiorna il file.
     *
     * @param ris ristorante da rimuovere
     */
    public void rimuoviRis(Ristorante ris) {
        listaRis.remove(ris);
        aggiornaRis();
    }

    /**
     * Genera un nuovo ID univoco per un ristorante.
     *
     * @return ID non ancora utilizzato
     */
    public int creaID() {
        int max = 0;
        for (Ristorante r : listaRis) {
            if (max < r.getIdRis()) {
                max = r.getIdRis();
            }
        }
        return max + 1;
    }
    
    /**
     * Riscrive il file CSV aggiornandolo con la lista attuale dei ristoranti.
     */
    public void aggiornaRis() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (Ristorante ris : listaRis) {
                wr.write(ris.toString());
                wr.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio ristoranti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Imposta il ristorante attuale da gestire/visualizzare.
     *
     * @param r ristorante selezionato
     */
    public void setRisAttuale(Ristorante r) {
        risAttuale = r;
    }
    
    /**
     * Restituisce il ristorante attuale.
     *
     * @return {@link Ristorante} attualmente selezionato, o "null" se non impostato
     */
    public Ristorante getRisAttuale() {
        return risAttuale;
    }
    
    /**
     * Restituisce il numero totale di ristoranti presenti nell'archivio.
     *
     * @return numero dei ristoranti
     */
    public int getNumeroRis() {
        return listaRis.size();
    }
    
    /**
     * Restituisce la lista di tutti i ristoranti caricati.
     *
     * @return lista di {@link Ristorante}
     */
    public ArrayList<Ristorante> getRis() {
        return listaRis;
    }
    
    /**
     * Restituisce un ristorante dato il suo ID.
     *
     * @param i identificativo del ristorante
     * @return ristorante con l'ID corrispondente, oppure "null" se non trovato
     */
    public Ristorante getRistorante(int i) {
        for (Ristorante r : listaRis) {
            if (r.getIdRis() == i) {
                return r;
            }
        }
        return null;
    }
}

/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.essenziali;
import theknife.essenziali.Preferito;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


/**
 * Gestisce l'archivio dei ristoranti preferiti degli utenti.
 * <p>
 * Questa classe si occupa di:
 *  <ul>
 *      <li>Leggere e scrivere i dati dei preferiti nel file CSV.</li>
 *      <li>Aggiungere e rimuovere preferiti dall'archivio.</li>
 *      <li>Gestire il preferito attualmente selezionato.</li>
 *  </ul>
 * </p>
 *
 *  <p>
 *  Il file di riferimento è: data\RisPreferiti.csv, e contiene i seguenti token:
    <pre>
 *      idRistorante § idUtente
 *  </pre>
 *  </p>
 *
 * @see Preferito
 */
public class ArchivioPreferiti {
    
    /** Percorso del file CSV dei preferiti. */
    private final String FILE_PATH = "data\\RisPreferiti.csv";
    
     /** Lista dei preferiti caricati. */
    private final ArrayList<Preferito> listaPreferiti = new ArrayList<>();
    
    /** Preferito attualmente in uso/gestione. */
    private Preferito prefAttuale;
    
    /**
     * Costruttore vuoto di default.
     * <p>Inizializza un archivio senza caricare automaticamente i dati.</p>
     */
    public ArchivioPreferiti() {}
    
     /**
     * Legge l'archivio dei preferiti dal file CSV e compila la lista interna.
     */
    public void leggiArchivio() {
        listaPreferiti.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                if(token.countTokens() == 2) {
                    int idRis = Integer.parseInt(token.nextToken());
                    int idUtente = Integer.parseInt(token.nextToken());
                    
                    listaPreferiti.add(new Preferito(idRis, idUtente)); 
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio preferiti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Imposta il preferito attuale, scritto come la coppia ristorante-utente in gestione.
     *
     * @param idRis ID del ristorante.
     * @param idUtente ID dell'utente.
     */
    public void setPrefAttuale(int idRis, int idUtente) {
        this.prefAttuale = new Preferito (idRis, idUtente);
    }
    
    /**
     * Restituisce il preferito attuale.
     *
     * @return il {@link Preferito} attuale, oppure "null" se non impostato.
     */
    public Preferito getPrefAttuale() {
        return prefAttuale;
    }
    
    /**
     * Aggiunge il preferito attuale all'archivio e aggiorna il file.
     */
    public void aggiungiPreferito() {
        listaPreferiti.add(prefAttuale);
        aggiornaPref();
    }
   
    
    /**
     * Rimuove il preferito attuale dall'archivio e aggiorna il file.
     */
    public void rimuoviPreferito() {
        listaPreferiti.remove(prefAttuale);
        aggiornaPref();
    }
   
    /**
     * Riscrive l'intero file CSV aggiornandolo con la lista attuale di preferiti.
     */
    public void aggiornaPref() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Preferito p : listaPreferiti) {
                wr.write(p.toString());
                wr.newLine();
                }
            } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio preferiti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Verifica se il preferito attuale è nella lista dati preferiti.
     * @return vero o falso.
     */
    public Boolean esistePref() {
        for (Preferito p : listaPreferiti) {
            if (prefAttuale.equals(p)) {
                return true;
            }
        }
        return false;
    }
  
    /**
     * Restituisce il numero totale di preferiti salvati. Debug e controllo
     *
     * @return numero dei preferiti.
     */
    public int getNumeroPreferiti() {
        return listaPreferiti.size();
    }
   
    /**
     * Restituisce la lista di tutti i preferiti caricati.
     *
     * @return lista di {@link Preferito}.
     */
    public ArrayList<Preferito> getPreferiti() {
        return listaPreferiti;
    }
}
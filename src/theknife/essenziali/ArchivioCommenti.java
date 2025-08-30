/*
 *  @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.essenziali;

import theknife.essenziali.CommentiRistoranti;
import theknife.essenziali.Ristorante;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Gestisce l'archivio dei commenti e delle recensioni dei ristoranti.
 * <p>
 *  Questa classe si occupa di:
 *  <ul>
 *      <li>Leggere e scrivere i commenti nel file CSV.</li>
 *      <li>Aggiungere, rimuovere e aggiornare recensioni e risposte.</li>
 *      <li>Recuperare informazioni come media voti, numero commenti e liste filtrate.</li>
 *  </ul>
 *
 * <p>
 *  Il file di riferimento è data\Commenti.csv, e contiene i seguenti token:
 *  <pre>
 *      <b>recensione</b>: recensione § idScrittore § testo § idCommento § titolo § idRistorante § valutazione § haRisposta § daLeggere.
 *      <b>risposta</b>: risposta § idScrittore § testo § idCommento.
 *  </pre>
 *
 * @see CommentiRistoranti
 * @see Ristorante
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class ArchivioCommenti {
    
    /** Percorso del file CSV contenente i commenti. {@code FILE_PATH}*/
    private static final String FILE_PATH = "data\\Commenti.csv";
    
    /** Lista di tutti i commenti e recensioni caricati in memoria. {@code listaCommenti}*/
    private final ArrayList<CommentiRistoranti> listaCommenti = new ArrayList<>();
    
    /**
     * Costruttore vuoto.
     * <p>Inizializza l'archivio senza caricare automaticamente i dati.
     */
    public ArchivioCommenti() {}
    
    /**
     * Legge i commenti dal file CSV e compila la lista interna.
     * <p>
     *  Supporta due tipi di commenti:
     *  <ul>
     *      <li>recensione: contiene titolo, ID ristorante, valutazione, un boolean che verifica se ha risposta e un boolean che verifica se é stato letto.</li>
     *      <li>risposta: contiene ID scrittore, e un ID commento per collegarla a una recensione.</li>
     *  </ul>
     */
    public void leggiArchivio() {
        listaCommenti.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                String tipoCommento = token.nextToken();
                int idScrittore = Integer.parseInt(token.nextToken());
                String testo = token.nextToken();
                int idCommento = Integer.parseInt(token.nextToken());

                if ("recensione".equals(tipoCommento)) {
                    String titolo = token.nextToken();
                    int idRistorante = Integer.parseInt(token.nextToken());
                    int valutazione = Integer.parseInt(token.nextToken());
                    boolean haRisposta = Boolean.parseBoolean(token.nextToken());
                    boolean daLeggere = Boolean.parseBoolean(token.nextToken());
                    listaCommenti.add(new CommentiRistoranti(idScrittore, testo, idCommento, titolo, idRistorante, valutazione, haRisposta, daLeggere));
                } else if ("risposta".equals(tipoCommento)) {
                    listaCommenti.add(new CommentiRistoranti(idScrittore, testo, idCommento));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio commenti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        } 
    }
    
    /**
     * Aggiorna il file CSV sovrascrivendo i dati con la lista attuale di commenti.
     */
    public void aggiornaCommenti() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (CommentiRistoranti cr : listaCommenti) {
                wr.write(cr.toString());
                wr.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio commenti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Restituisce la risposta associata a un commento specifico.
     *
     * @param commento il commento per cui cercare la risposta.
     * @return la risposta se esiste, altrimenti restituisce "null".
     */
    public CommentiRistoranti getRisposta(CommentiRistoranti commento) {
        for (CommentiRistoranti cr : listaCommenti) {
            if (cr.getIdCommento() == commento.getIdCommento() && cr.isRisposta()) {
                return cr;
            }
        }
        return null;
    }
    
     /**
     * Imposta il boolean "haRisposta" su un commento e aggiorna l'archivio.
     *
     * @param c commento da aggiornare.
     */
    public void impostaBooleanRisposta(CommentiRistoranti c) {
        c.setHaRisposta(true);
        aggiornaCommenti();
    }
    
    /**
     * Aggiunge un nuovo commento all'archivio e salva le modifiche.
     *
     * @param c commento da aggiungere.
     */
    public void aggiungiCommento(CommentiRistoranti c) {
        listaCommenti.add(c);
        aggiornaCommenti();
    }
    
    /**
     * Rimuove un commento e la sua eventuale risposta dall'archivio.
     *
     * @param c commento da rimuovere.
     */
    public void rimuoviCommento(CommentiRistoranti c) {
        listaCommenti.remove(c);
        if (c.haRisposta()) {
            listaCommenti.remove(getRisposta(c));
        }
        aggiornaCommenti();
    }
    
    /**
     * Rimuove una risposta da un commento.
     *
     * @param c risposta da rimuovere.
     */
    public void rimuoviRisposta(CommentiRistoranti c) {
        listaCommenti.remove(c);
        aggiornaCommenti();
    }
    
     /**
     * Genera un nuovo ID univoco per un commento.
     *
     * @return il nuovo ID generato.
     */
    public int creaID() {
        int max = 0;
        for (CommentiRistoranti cr : listaCommenti) {
            if (max < cr.getIdCommento()) {
                max = cr.getIdCommento();
            }
        }
        return max + 1;
    }
    
    /**
     * Restituisce la lista dei commenti attualmente caricati.
     *
     * @return lista {@link CommentiRistoranti}.
     */
    public ArrayList<CommentiRistoranti> getListaCommenti() {
        return listaCommenti;
    }
     
    /**
     * Verifica se un utente ha già scritto una recensione per un ristorante.
     *
     * @param idUtente ID dell'utente.
     * @param idRistorante ID del ristorante.
     * @return true se esiste già una recensione, restituisce false altrimenti.
     */
    
    public boolean haGiaRecensione(int idUtente, int idRistorante) {
        for (CommentiRistoranti c : listaCommenti) {
            if (c.getIdScrittore() == idUtente && c.getIdRistorante() == idRistorante) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Conta quanti commenti sono associati a un ristorante.
     *
     * @param r ristorante da verificare.
     * @return numero di commenti trovati.
     */
    public int contaCommenti(Ristorante r) {
        int numero = 0;
        for (CommentiRistoranti c : listaCommenti) {
            if (r.getIdRis() == c.getIdRistorante()) {
                numero++;                    
                }
            }
        return numero;
    }
    
    /**
     * Restituisce fino a un numero "max" di recensioni relative a un ristorante.
     *
     * @param idRistorante ID del ristorante.
     * @param max numero massimo di recensioni da restituire.
     * @return lista di recensioni.
     */
    public ArrayList<CommentiRistoranti> getRecensioniPer(int idRistorante, int max) {
        ArrayList<CommentiRistoranti> lista = new ArrayList<>();
        for (CommentiRistoranti c : listaCommenti) {
            if (c.getIdRistorante() == idRistorante) {
                lista.add(c);
            }
            if (lista.size() == max) {
                break;
            }
        }
        return lista;
    }
    
     /**
     * Restituisce tutti i commenti scritti da un utente.
     *
     * @param idUtente ID dell'utente.
     * @return lista di commenti scritti dall'utente.
     */
    public ArrayList<CommentiRistoranti> getCommentiPerUtente(int idUtente) {
        ArrayList<CommentiRistoranti> lista = new ArrayList<>();
        for (CommentiRistoranti c : listaCommenti) {
            if (c.getIdScrittore() == idUtente) {
                lista.add(c);
            }
        }
        return lista;
    }

    /**
     * Calcola la valutazione media di un ristorante in base alle recensioni ricevute.
     *
     * @param idRistorante ID del ristorante.
     * @return media dei voti, oppure "0.0" se non ci sono recensioni.
     */
    public double calcolaMediaPerRistorante(int idRistorante) {
        int somma = 0;
        int count = 0;
        for (CommentiRistoranti c : listaCommenti) {
            if (c.getIdRistorante() == idRistorante) {
                somma += c.getValutazione();
                count++;
            }
        }
        return (count > 0) ? (double) somma / count : 0.0;
    }
}   

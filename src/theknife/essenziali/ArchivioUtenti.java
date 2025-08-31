/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.essenziali;
import theknife.essenziali.Utente;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


/**
 * Gestisce l'archivio degli utenti dell'applicazione.
 * <p>
 * Questa classe si occupa di:
 *  <ul>
 *      <li>Caricare gli utenti da un file CSV.</li>
 *      <li>Verificare l'esistenza di un account tramite email e password.</li>
 *      <li>Aggiungere o rimuovere utenti.</li>
 *      <li>Generare ID unici per nuovi utenti.</li>
 *      <li>Gestire l'utente attualmente loggato.</li>
 *  </ul>
 *
 * <p>
 * Il file di riferimento è: data\Utenti.csv,  
 * con righe salvate nel formato generato da {@link Utente#toString()}.
 *
 * @see Utente
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */

public class ArchivioUtenti {
    
    /** Percorso del file CSV degli utenti. {@code FILE_PATH}*/
    private static final String FILE_PATH = "data" + File.separator + "Utenti.csv";
    
    /** Utente attualmente autenticato. {@code utenteAttuale}*/
    private Utente utenteAttuale;
    
    /** Lista di tutti gli utenti caricati dall'archivio. {@code listaUtenti}*/
    private final ArrayList<Utente> listaUtenti = new ArrayList<>();
    
    /**
     * Costruttore vuoto.
     * <p>Inizializza un archivio senza caricare automaticamente i dati.
     */
    public ArchivioUtenti() {}
    
    /**
     * Legge l'archivio degli utenti dal file CSV e compila la lista interna.
     */
    public void leggiArchivio() {
        listaUtenti.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                if(token.countTokens() == 9){
                    String nome = token.nextToken();
                    String cognome = token.nextToken();
                    String username = token.nextToken();
                    String email = token.nextToken();
                    String password = token.nextToken();
                    String posizione = token.nextToken();
                    String stato = token.nextToken();
                    int id = Integer.parseInt(token.nextToken());
                    String ruolo = token.nextToken();
                    
                    listaUtenti.add(new Utente(nome, cognome, username, email, password, posizione, stato, id, ruolo));
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio utenti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Verifica se esiste un utente con email e password specificati.
     * Se trovato, imposta l' {@link #utenteAttuale}.
     *
     * @param email email dell'utente
     * @param pass  password dell'utente
     * @return true se l'utente esiste, false altrimenti
     */
    public boolean esisteUtente(String email, String pass) {
        for (Utente u: listaUtenti) {
            if (u.getEmailUtente().equals(email) && u.getPassUtente().equals(pass)) {
                utenteAttuale = u;
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se un'email è già presente nell'archivio.
     *
     * @param email email da controllare
     * @return true se l'email esiste, false altrimenti
     */
    public boolean esisteMail(String email) {
        for (Utente u: listaUtenti) {
            if (u.getEmailUtente().equals(email)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Genera un nuovo ID univoco per un utente.
     *
     * @return ID non ancora utilizzato
     */
    public int creaID() {
        int max = 0;
        for (Utente f : listaUtenti)
            if (max < f.getIdUtente())
                max = f.getIdUtente();
        return max + 1;
    }
    
    /**
     * Riscrive il file CSV aggiornandolo con la lista attuale degli utenti.
     */
    public void aggiornaUtenti() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Utente f : listaUtenti) {
                wr.write(f.toString());
                wr.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Errore: archivio utenti non trovato.", "Errore", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Aggiunge un nuovo utente all'archivio e aggiorna il file.
     *
     * @param u utente da aggiungere
     */
    public void aggiungiUtente(Utente u) {
        listaUtenti.add(u);
        aggiornaUtenti();
    }
    
    /**
     * Rimuove un utente dall'archivio e aggiorna il file.
     *
     * @param u utente da rimuovere
     */
    public void rimuoviUtente(Utente u) {
        listaUtenti.remove(u);
        aggiornaUtenti();
    }
    
    /**
     * Imposta come attuale l'utente con l'ID specificato.
     *
     * @param i ID dell'utente da selezionare
     */
    public void setUtenteAttuale(int i) {
        this.utenteAttuale = getUtente(i);
    }
    
    /**
     * Restituisce l'utente attualmente loggato.
     *
     * @return utente attuale, oppure "null" se non autenticato
     */
    public Utente getUtenteAttuale() {
        return utenteAttuale;
    }
    
    /**
     * Esegue il logout, rimuovendo l'utente attuale.
     */
    public void logout() {
        this.utenteAttuale = null;
    }
    
    /**
     * Restituisce il numero totale di utenti presenti nell'archivio.
     *
     * @return numero degli utenti
     */
    public int getNumeroUtenti() {
        return listaUtenti.size();
    }
    
    /**
     * Restituisce la lista di tutti gli utenti caricati.
     *
     * @return lista di {@link Utente}
     */
    public ArrayList<Utente> getUtenti() {
        return listaUtenti;
    }
    
    /**
     * Restituisce un utente dato il suo ID.
     *
     * @param i identificativo dell'utente
     * @return utente con l'ID corrispondente, oppure "null" se non trovato
     */
    public Utente getUtente(int i) {
        for (Utente u : listaUtenti) {
            if (u.getIdUtente() == i) {
                return u;
            }
        }
        return null;
    } 
      
    /**
     * Restituisce l'ID di un utente verificando email e password.
     *
     * @param email email dell'utente
     * @param password password dell'utente
     * @return ID dell'utente se trovato, -1 altrimenti
     */
    public int getId(String email, String password) {
        for (Utente u : listaUtenti) {
            if (u.getEmailUtente().equals(email) && u.getPassUtente().equals(password)) {
                return u.getIdUtente();
            }
        }
        return -1;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;
import java.io.*;
import java.util.*;


/**
 *
 * @author davim sugo alefro
 */

public class ArchivioUtenti {
    
    
    private final String FILE_PATH = "data\\Utenti.csv";
    private Utente utenteAttuale;
    private ArrayList<Utente> listaUtenti = new ArrayList<>();
    
    public ArchivioUtenti() {}
    
    //Metodo per leggere l'archivio.
    public void leggiArchivio () {
        listaUtenti.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                if(token.countTokens() == 8){
                    String nome = token.nextToken();
                    String cognome = token.nextToken();
                    String username = token.nextToken();
                    String email = token.nextToken();
                    String password = token.nextToken();
                    String posizione = token.nextToken();
                    int id = Integer.parseInt(token.nextToken());
                    String ruolo = token.nextToken();
                    
                    listaUtenti.add(new Utente (nome, cognome, username, email, password, posizione, id, ruolo));
                }
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodo per controllare se Username e Password sono già presenti nell'archivio.
    public boolean esisteUtente(String user, String pass) {
        for (Utente u: listaUtenti) {
            if (u.getUsernameUtente().equals(user) && u.getPassUtente().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    //Metodo per controllare se un'Email è già presente nell'archivio.
    public boolean esisteMail(String email) {
        for (Utente u: listaUtenti) {
            if (u.getEmailUtente().equals(email)) {
                utenteAttuale = u;
                return true;
            }
        }
        return false;
    }
    
    //Metodo per creare un ID unico.
    public int creaID() {
        int max = 0;
        for (Utente f : listaUtenti)
            if (max < f.getIdUtente())
                max = f.getIdUtente();
        return max + 1;
    }
    
    //Metodo per riscrivere il file di testo, aggiornando l'archivio.
    public void aggiornaUtenti() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Utente f : listaUtenti) {
                wr.write(f.toString());
                wr.newLine();
                }
            } catch (IOException e) {
                 System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodo per aggiungere un utente all'archivio.
    public void aggiungiUtente(Utente u) {
        listaUtenti.add(u);
        aggiornaUtenti();
    }
    
    //Metodo per rimuovere un utente dall'archivio.
    public void rimuoviUtente(Utente u) {
        listaUtenti.remove(u);
        aggiornaUtenti();
    }
    
    //Metodi per gestire l'utente attuale.
    public void setUtenteAttuale(int i) {
        this.utenteAttuale = getUtente(i);
    }
    
    public Utente getUtenteAttuale() {
        return utenteAttuale;
    }
    
    public void logout() {
        this.utenteAttuale = null;
    }
    
    //Per debug o controllo.
    public int getNumeroUtenti() {
        return listaUtenti.size();
    }
    
    public ArrayList<Utente> getUtenti() {
        return listaUtenti;
    }
    
      public Utente getUtente(int i) {
        for (Utente u : listaUtenti) {
            if (u.getIdUtente() == i) {
                return u;
            }
        }
        return null;
    } 
}

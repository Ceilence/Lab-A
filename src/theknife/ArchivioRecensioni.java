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

public class ArchivioRecensioni {
    private final String FILE_PATH = "data\\Recensioni.csv";
    private final ArrayList<Recensione> listaRecensioni = new ArrayList<>();
    private Recensione recAttuale;
    
    public ArchivioRecensioni() {}
    
    //Metodo per leggere l'archivio.
    public void leggiArchivio() {
        listaRecensioni.clear();
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = rd.readLine()) != null && !line.isBlank()) {
                StringTokenizer token = new StringTokenizer(line, "§");
                if(token.countTokens() == 4) {
                    String recensione = token.nextToken();
                    int mediaStelle = Integer.parseInt(token.nextToken());
                    int idUtente = Integer.parseInt(token.nextToken());
                    int idRis = Integer.parseInt(token.nextToken());
                   
                    listaRecensioni.add(new Recensione(recensione, mediaStelle, idUtente, idRis));
                }
            }   
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodo per rimuovere un utente dall'archivio.
    public void rimuoviRecensione(Recensione r) {
        listaRecensioni.remove(r);
        aggiornaRec();
    }
    
    //Metodo per aggiungere un utente all'archivio.
    public void aggiungiRecensione(Recensione r) {
        listaRecensioni.add(r);
        aggiornaRec();
    }
    
    //Metodo per ottenere la lista di ristoranti preferiti.
    public ArrayList<Recensione> getRecensioni() {
        return listaRecensioni;
    }
    
    //Metodo per riscrivere il file di testo, aggiornando l'archivio.
    public void aggiornaRec() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Recensione r : listaRecensioni) {
                wr.write(r.toString());
                wr.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodi per gestire la recensione visualizzata.
    public void setRecAttuale(Recensione r) {
        this.recAttuale = r;
    }
    
    public Recensione getRecAttuale() {
        return recAttuale;
    }
    
    public void reset() {
        this.recAttuale = null; 
    }
       
    
    //Per debug o controllo.
    public int getNumeroRecensioni() {
        return listaRecensioni.size();
    }
    
    public ArrayList<Recensione> getListaRec() {
        return listaRecensioni;
    }  
}


//QUANDO SI FA LOGOUT RESETTARE LISTA PREFERITI





































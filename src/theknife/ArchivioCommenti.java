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
public class ArchivioCommenti {
    
    private static final String FILE_PATH = "data\\Commenti.csv";
    private final ArrayList<CommentiRistoranti> listaCommenti = new ArrayList<>();
    
    public ArchivioCommenti() {}
    
    /**
     * Mi lecca il pisello.
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
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        } 
    }
    
    public void aggiornaCommenti() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (CommentiRistoranti cr : listaCommenti) {
                wr.write(cr.toString());
                wr.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    public CommentiRistoranti getRisposta(CommentiRistoranti commento) {
        for (CommentiRistoranti cr : listaCommenti) {
            if (cr.getIdCommento() == commento.getIdCommento() && cr.isRisposta()) {
                return cr;
            }
        }
        return null;
    }
    
    public void aggiungiCommento(CommentiRistoranti c) {
        listaCommenti.add(c);
        aggiornaCommenti();
    }
    
    public void rimuoviCommento(CommentiRistoranti c) {
        listaCommenti.remove(c);
        aggiornaCommenti();
    }
    
    public int creaID() {
        int max = 0;
        for (CommentiRistoranti cr : listaCommenti) {
            if (max < cr.getIdCommento()) {
                max = cr.getIdCommento();
            }
        }
        return max + 1;
    }
    
    public ArrayList<CommentiRistoranti> getListaCommenti() {
        return listaCommenti;
    }
     
    public boolean haGiaRecensione(int idUtente, int idRistorante) {
        for (CommentiRistoranti c : listaCommenti) {
            if (c.getIdScrittore() == idUtente && c.getIdRistorante() == idRistorante) {
                return true;
            }
        }
        return false;
    }
    
     public int contaCommenti(Ristorante r) {
        int numero = 0;
        for (CommentiRistoranti c : listaCommenti) {
            if (r.getIdRis() == c.getIdRistorante()) {
                numero++;                    
                }
            }
        return numero;
        }
}   

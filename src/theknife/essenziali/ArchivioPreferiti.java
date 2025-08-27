/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.essenziali;
import theknife.essenziali.Preferito;
import java.io.*;
import java.util.*;


/**
 *
 * @author davim sugo alefro
 */

public class ArchivioPreferiti {
    private final String FILE_PATH = "data\\RisPreferiti.csv";
    private final ArrayList<Preferito> listaPreferiti = new ArrayList<>();
    private Preferito prefAttuale;
    
    public ArchivioPreferiti() {}
    
    //Metodo per leggere l'archivio.
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
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodo per impostare il preferito in uso.
    public void setPrefAttuale(int idRis, int idUtente) {
        this.prefAttuale = new Preferito (idRis, idUtente);
    }
    
    //Metodo per ottenere il preferito attualmente visualizzato.
    public Preferito getPrefAttuale() {
        return prefAttuale;
    }
    
    //Metodo per aggiungere un preferito.
    public void aggiungiPreferito() {
        listaPreferiti.add(prefAttuale);
        aggiornaPref();
    }
   
    
    //Metodo per rimuovere un preferito.
    public void rimuoviPreferito() {
        listaPreferiti.remove(prefAttuale);
        aggiornaPref();
    }
   
    //Metodo per riscrivere il file di testo, aggiornando l'archivio.
    public void aggiornaPref() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Preferito p : listaPreferiti) {
                wr.write(p.toString());
                wr.newLine();
                }
            } catch (IOException e) {
                 System.out.println("Errore nella lettura del file:" + e.getMessage());
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
  
    //Per debug o controllo.
    public int getNumeroPreferiti() {
        return listaPreferiti.size();
    }
   
     public ArrayList<Preferito> getPreferiti() {
        return listaPreferiti;
    }
}


//QUANDO SI FA LOGOUT RESETTARE LISTA PREFERITI





































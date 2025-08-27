/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.essenziali;
import theknife.essenziali.Ristorante;
import java.io.*;
import java.util.*;


/**
 *
 * @author davim, sugo, alefrogs
 */
public class ArchivioRis {
    private static final String FILE_PATH = "data\\Ristoranti.csv";
    private Ristorante risAttuale;
    private final ArrayList<Ristorante> listaRis = new ArrayList<>();
   
    public ArchivioRis() {}
    
    //Metodo per leggere l'archivio.
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

                listaRis.add(new Ristorante(nomeRis, indRis, locRis, statoRis, priceRis, cuisRis, longRis, latRis, telRis,mediaStelleRis, delivery, prenotaOnline, desRis, idRis, idRistoratore));
            }
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodo per aggiungere un ristorante all'archivio.
    public void aggiungiRis(Ristorante ris) {
        listaRis.add(ris);
        aggiornaRis();
    }
    
    //Metodo per rimuovere un ristorante dall'archivio.
    public void rimuoviRis(Ristorante ris) {
        listaRis .remove(ris);
        aggiornaRis();
    }

    //Metodo per creare un ID unico.
    public int creaID() {
        int max = 0;
        for (Ristorante r : listaRis ) {
            if (max < r.getIdRis()) {
                max = r.getIdRis();
            }
        }
         return max + 1;
    }
    
    //Metodo per riscrivere il file di testo, aggiornando l'archivio.
    public void aggiornaRis() {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (Ristorante ris : listaRis) {
                wr.write(ris.toString());
                wr.newLine();
            }
        } catch (IOException e) {
                 System.out.println("Errore nella lettura del file:" + e.getMessage());
        }
    }
    
    //Metodi per gestire il ristorante attualmente visualizzato.
     public void setRisAttuale(Ristorante r) {
        risAttuale = r;
    }
    
    public Ristorante getRisAttuale() {
        return risAttuale;
    }
    
    public int getNumeroRis() {
        return listaRis.size();
    }
    
    public ArrayList<Ristorante> getRis() {
        return listaRis;
    }
    
    public Ristorante getRistorante(int i) {
        for (Ristorante r : listaRis) {
            if (r.getIdRis() == i) {
                return r;
            }
        } 
        return null;
    }
}


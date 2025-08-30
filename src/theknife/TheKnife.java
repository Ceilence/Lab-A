/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */

package theknife;

import theknife.gestori.GestoreArchivi;
import theknife.grafica.RisList;

/**
 * Classe principale del progetto TheKnife.
 * <p>
 *  Questa classe contiene il main. Si occupa di:
 *  <ul>
 *      <li>Inizializzare il {@link GestoreArchivi}, che gestisce i vari archivi (utenti, risorse, città, preferiti, commenti).</li>
 *      <li>Caricare i dati salvati dai file tramite i metodi (leggiArchivio()}).</li>
 *      <li>Avviare l'interfaccia grafica principale {@link RisList}.</li>
 *  </ul>
 * </p>
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class TheKnife {
    
    /**
     * Metodo di avvio del programma.
     * <p>
     *  Esegue le seguenti operazioni:
     *  <ol>
     *      <li>Inizializza il {@link GestoreArchivi}.</li>
     *      <li>Legge i dati degli archivi (utenti, risorse, città, preferiti, commenti).</li>
     *      <li>Carica la finestra {@link RisList}, l'interfaccia grafica principale.</li>
     *  </ol>
     * </p>
     *
     * @param args argomenti passati da riga di comando (non utilizzati).
     */
    public static void main(String[] args) {
        GestoreArchivi gestore = new GestoreArchivi();
        
        gestore.getArchivioUtenti().leggiArchivio();
        gestore.getArchivioRis().leggiArchivio();
        gestore.getArchivioCitta().leggiArchivio();
        gestore.getArchivioPreferiti().leggiArchivio();
        gestore.getArchivioCommenti().leggiArchivio();
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GestoreArchivi.RisListFrame = new RisList(gestore);
                GestoreArchivi.RisListFrame.setVisible(false);
                GestoreArchivi.RisListFrame.pack();
                GestoreArchivi.RisListFrame.setLocationRelativeTo(null);
            }
        });
    }
}
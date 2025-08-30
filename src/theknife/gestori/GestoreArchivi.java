/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) - Sede: Como
 */
package theknife.gestori;

import theknife.essenziali.ArchivioCitta;
import theknife.essenziali.ArchivioCommenti;
import theknife.essenziali.ArchivioPreferiti;
import theknife.essenziali.ArchivioRis;
import theknife.essenziali.ArchivioUtenti;
import theknife.grafica.RisList;

/**
 * Classe che gestisce tutti gli archivi del sistema.
 * <p>
 * Contiene gli archivi di utenti, ristoranti, città, preferiti e commenti,
 * e fornisce metodi di accesso a ciascuno di essi.
 * </p>
 */
public class GestoreArchivi {
    
    /** Archivio degli utenti registrati. {@code archivioUtenti} */
    private final ArchivioUtenti archivioUtenti;
    
    /** Archivio dei ristoranti. {@code archivioRis} */
    private final ArchivioRis archivioRis;
    
    /** Archivio delle città. {@code archivioCitta} */
    private final ArchivioCitta archivioCitta;
    
    /** Archivio dei preferiti degli utenti. {@code archivioPref} */
    private final ArchivioPreferiti archivioPref;
    
    /** Archivio dei commenti sui ristoranti. {@code archivioCom} */
    private final ArchivioCommenti archivioCom;
    
    /** Finestra principale per la lista dei ristoranti. {@code RisListFrame} */
    public static RisList RisListFrame;
    
    /**
     * Costruttore della classe GestoreArchivi.
     * <p>
     * Inizializza tutti gli archivi: utenti, ristoranti, città, preferiti e commenti.
     * </p>
     */
    public GestoreArchivi() {
        archivioUtenti = new ArchivioUtenti();
        archivioRis = new ArchivioRis();
        archivioCitta = new ArchivioCitta();
        archivioPref = new ArchivioPreferiti();
        archivioCom = new ArchivioCommenti();    
    }

    /** @return l'archivio utenti */
    public ArchivioUtenti getArchivioUtenti() {
        return archivioUtenti;
    }

    /** @return l'archivio ristoranti */
    public ArchivioRis getArchivioRis() {
        return archivioRis;
    }

    /** @return l'archivio città */
    public ArchivioCitta getArchivioCitta() {
        return archivioCitta;
    }

    /** @return l'archivio preferiti */
    public ArchivioPreferiti getArchivioPreferiti() {
        return archivioPref;
    }
    
    /** @return l'archivio commenti */
    public ArchivioCommenti getArchivioCommenti() {
        return archivioCom;
    }
}

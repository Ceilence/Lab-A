/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife.gestori;

import theknife.essenziali.ArchivioCitta;
import theknife.essenziali.ArchivioCommenti;
import theknife.essenziali.ArchivioPreferiti;
import theknife.essenziali.ArchivioRis;
import theknife.essenziali.ArchivioUtenti;
import theknife.grafica.RisList;

/**
 *
 * @author davim
 */
public class GestoreArchivi {
    private final ArchivioUtenti archivioUtenti;
    private final ArchivioRis archivioRis;
    private final ArchivioCitta archivioCitta;
    private final ArchivioPreferiti archivioPref;
    private final ArchivioCommenti archivioCom;
    
    public static RisList RisListFrame;
    
    public GestoreArchivi() {
        archivioUtenti = new ArchivioUtenti();
        archivioRis = new ArchivioRis();
        archivioCitta = new ArchivioCitta();
        archivioPref = new ArchivioPreferiti();
        archivioCom = new ArchivioCommenti();    
    }

    public ArchivioUtenti getArchivioUtenti() {
        return archivioUtenti;
    }

    public ArchivioRis getArchivioRis() {
        return archivioRis;
    }

    public ArchivioCitta getArchivioCitta() {
        return archivioCitta;
    }

    public ArchivioPreferiti getArchivioPreferiti() {
        return archivioPref;
    }
    
    public ArchivioCommenti getArchivioCommenti() {
        return archivioCom;
    }
}

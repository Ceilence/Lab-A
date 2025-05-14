/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package theknife;

/**
 *
 * @author davim
 */
public class GestoreArchivi {
    private ArchivioUtenti archivioUtenti;
    private ArchivioRis archivioRis;
    private ArchivioCitta archivioCitta;
    private ArchivioPreferiti archivioPref;
    private ArchivioRecensioni archivioRec;
    
    public GestoreArchivi() {
        archivioUtenti = new ArchivioUtenti();
        archivioRis = new ArchivioRis();
        archivioCitta = new ArchivioCitta();
        archivioPref = new ArchivioPreferiti();
        archivioRec = new ArchivioRecensioni();
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

    public ArchivioPreferiti getArchivioPref() {
        return archivioPref;
    }

    public ArchivioRecensioni getArchivioRec() {
        return archivioRec;
    }
}

/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import theknife.essenziali.Ristorante;
import java.awt.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import theknife.essenziali.Citta;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;




/**
 * Finestra principale che mostra la lista dei ristoranti disponibili. 
 * <p>
 * Consente di:
 *  <ul>
 *      <li>Visualizzare i ristoranti sotto forma di {@link PannelloRistorante}.</li>
 *      <li>Applicare filtri di ricerca tramite {@link Filtro}.</li>
 *      <li>Gestire la paginazione dei risultati.</li>
 *      <li>Mostrare i dettagli e le recensioni associate a un ristorante.</li>
 *  </ul>
 * <p>
 * La classe interagisce con {@link GestoreArchivi} per accedere agli archivi e aggiornare le informazioni in base all’utente e ai dati caricati.
 *
 * @see GestoreArchivi
 * @see PannelloRistorante
 * @see Filtro
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class RisList extends javax.swing.JFrame {
    
    /** Numero massimo di elementi da visualizzare per ogni pagina. {@code ELEMENTI_PER_PAGINA} */
    private final int ELEMENTI_PER_PAGINA = 100;
    
    /** Messaggio preimpostato in #campoRicerca. */
    private final String messaggioBarra = "Lasciare vuoto per visualizzare tutti i ristoranti";

    /** Riferimento al gestore degli archivi. {@code gestore}*/
    private final GestoreArchivi gestore;

    /** Lista di tutti i pannelli ristorante caricati. {@code tuttiIPannelli}*/
    private final ArrayList<PannelloRistorante> tuttiIPannelli = new ArrayList<>();

    /** Lista di pannelli ristorante attualmente filtrati. {@code pannelliFiltrati}*/
    private final ArrayList<PannelloRistorante> pannelliFiltrati = new ArrayList<>();

    /** Finestra di caricamento mostrata durante l'inizializzazione. {@code caricamentoFrame}*/
    private final Caricamento caricamentoFrame;

    /** Numero della pagina attualmente visualizzata. {@code paginaAttuale}*/
    private int paginaAttuale = 0;

    /** Icone di bandiere e simboli utilizzate nella UI. */
    private ImageIcon flagItalia, flagCina, flagFrancia, flagGermania, flagSpagna, flagStatiUniti, flagGiappone, flagMondo, stellaVuota, stellaPiena;

    /** Finestra di filtro attiva, se presente. {@code f}*/
    private Filtro f;
    
    /**
     * Costruisce la finestra di lista dei ristoranti e inizializza i componenti.
     * <p>
     * Vengono caricati i pannelli dei ristoranti, le icone delle bandiere e viene mostrato un frame di caricamento finché i dati non sono pronti.
     *
     * @param gestore il {@link GestoreArchivi} utilizzato per accedere ai dati
     */
    public RisList(GestoreArchivi gestore) {
        this.gestore = gestore;
        initComponents();
        
        //Imposta il messagio predefinito.
        campoRicerca.setText(messaggioBarra);
        campoRicerca.setForeground(Color.LIGHT_GRAY);
        campoRicerca.setFont(campoRicerca.getFont().deriveFont(Font.ITALIC));
        
        //Creazione frame di caricamento.
        caricamentoFrame = new Caricamento();
        caricamentoFrame.setLocationRelativeTo(null);
        caricamentoFrame.setVisible(true);

        //Impostazione dei Layout e del contenuto degli scrollPane.
        contenitorePanel.setLayout(new BoxLayout(contenitorePanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(contenitorePanel);
        contenitoreRec.setLayout(new BoxLayout(contenitoreRec, BoxLayout.Y_AXIS));
        scrollPaneRec.setViewportView(contenitoreRec);
        
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        scrollPaneDet.getVerticalScrollBar().setUnitIncrement(50);
        scrollPaneRec.getVerticalScrollBar().setUnitIncrement(50);
        
        creaImmagini();
        caricaPannelli();
        
        
        getRootPane().setDefaultButton(cerca);
    }
    
    /**
     * Carica i pannelli {@link PannelloRistorante} relativi a ciascun {@link Ristorante} presente nell'archivio e aggiorna 
     * la barra di progresso del caricamento.
     * <p>
     * L’operazione è eseguita in background tramite {@link SwingWorker}.
     */
    private void caricaPannelli() {
        ArrayList<Ristorante> lista = gestore.getArchivioRis().getRis();
        int totale = lista.size();

        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                int count = 0;
                for (Ristorante r : lista) {
                    PannelloRistorante p = new PannelloRistorante(RisList.this, gestore, r, contenitoreAnteprima);
                    tuttiIPannelli.add(p);
                    

                    count++;
                    publish(count); 
                }
                return null;
            }
                @Override
                protected void process(java.util.List<Integer> chunks) {
                    int ultimoValore = chunks.get(chunks.size() - 1);
                    caricamentoFrame.aggiornaProgresso(ultimoValore, totale);
            }

            @Override
            protected void done() {
                caricamentoFrame.dispose();

                creaLogin();
            }
        };
        worker.execute();
    }
    
    /**
     * Applica un filtro testuale ai ristoranti.
     * <p>
     * Se #campoRicerca è vuoto vengono mostrati tutti i ristoranti.
     * Altrimenti vengono mostrati solo i ristoranti che contengono il testo di #campoRicerca.
     * Se non esistono ristoranti che soddisfano questo requisito, viene mostrato un messagio di errore.
     * 
     * @param filtro stringa di ricerca da applicare ai nomi dei ristoranti
     */
    private void filtraPannelli(String filtro) {
        paginaAttuale = 0;
        filtro = filtro.toLowerCase();
        pannelliFiltrati.clear();
        boolean trovato = false;
        
        if (filtro.equals("lasciare vuoto per visualizzare tutti i ristoranti")) {
            pannelliFiltrati.addAll(tuttiIPannelli);
            graficaImpaginata();
        } else {
            for (PannelloRistorante p : tuttiIPannelli) {
                Ristorante r = p.getRistorante();

                if (r.getNomeRis().toLowerCase().contains(filtro)) {
                    trovato = true;
                    pannelliFiltrati.add(p);
                }
            }
            if (!trovato) {
                JOptionPane.showMessageDialog(this, "Nessun ristorante trovato", "Ricerca fallita", JOptionPane.INFORMATION_MESSAGE);
            } else {
                graficaImpaginata();
            }
        }
    }
    
    /**
     * Filtra i ristoranti in base alla posizione dell’utente.
     * <p>
     * Vengono mostrati i ristoranti entro una distanza massima dalla città specificata. Se la città non esiste,
     * vengono mostrati i ristoranti nello stato corrente dell’utente.
     *
     * @param cittaUtente nome della città inserita dall’utente
     * @param distanzaMax distanza massima (in km) dalla città
     */
    public void filtraPosizione(String cittaUtente, double distanzaMax){ 
        pannelliFiltrati.clear();
        Citta citta = gestore.getArchivioCitta().getCitta(cittaUtente);
        
        if (citta != null) {
            for(PannelloRistorante p : tuttiIPannelli){
                Ristorante r = p.getRistorante();

                if(r.getStatoRis().equals(gestore.getArchivioUtenti().getUtenteAttuale().getStatoUtente())){
                    double distanza = gestore.getArchivioCitta().calcolaDistanza(citta.getLatCitta(), citta.getLonCitta(), r.getLatRis(), r.getLongRis());
                    if(distanza <= distanzaMax){
                        pannelliFiltrati.add(p);
                    }
                }
            }
        }
      
        if(citta == null){
            pannelliFiltrati.clear();
            for(PannelloRistorante p : tuttiIPannelli){
                Ristorante r = p.getRistorante();
                if(r.getStatoRis().equals(gestore.getArchivioUtenti().getUtenteAttuale().getStatoUtente())){
                    pannelliFiltrati.add(p);
                }
            }
            JOptionPane.showMessageDialog(this, "Nessun ristorante trovato a " + cittaUtente + "\n" + "Verranno mostrati i ristoranti nel tuo stato: " + gestore.getArchivioUtenti().getUtenteAttuale().getStatoUtente(), "Avviso", JOptionPane.INFORMATION_MESSAGE);
        }
        graficaImpaginata();
    }
    
    /**
     * Crea il filtro dei ristoranti se non è già stato creato.
     * <p>
     * Viene utilizzato per applicare filtri sui ristoranti visualizzati.
     * 
     * @see Filtro
     */
    public void creaFiltro() {
        if (f == null) {
            f = new Filtro(gestore, RisList.this, tuttiIPannelli);
        }
    }
    
    /**
     * Chiude il filtro dei ristoranti se aperto.
     * <p>
     * Dopo l'esecuzione di questo metodo, il filtro non sarà più visibile e la finestra principale sarà nuovamente attiva.
     * 
     * @see Filtro
     */
    public void chiudiFiltro() {
        if (f != null) {
            f.dispose();
            f = null;
        }
    }
    
     /**
     * Applica i filtri selezionati sui pannelli dei ristoranti.
     * <p>
     * Dopo l'applicazione dei filtri, aggiorna la pagina e i componenti generali. Mostra un messaggio se nessun ristorante soddisfa i criteri.
     */
    public void applicaFiltri(){
        pannelliFiltrati.clear();
        f.filtra(tuttiIPannelli, pannelliFiltrati);
        if (!pannelliFiltrati.isEmpty()) {
            graficaImpaginata();
            
            this.setEnabled(true);
            f.setVisible(false);
            this.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(f, "Nessun ristorante trovato con i filtri applicati", "Risultati vuoti", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    
    
    //----METODI PUBBLICI DI AGGIORNAMENTO UI----
    
    /**
     * Aggiorna tutti i componenti dell'interfaccia utente in base al ristorante selezionato.
     * <p>
     * Questo metodo aggiorna dettagli, preferiti, anteprime recensioni, etichette e pulsanti.
     * 
     * @param r il {@link Ristorante} di riferimento
     */
    public void aggiornaComponentiGenerali(Ristorante r) { 
        impostaRisAttuale(r);
        setPreferitoVisualizzato(r);
        mostraRecensioniAnteprima();
        resettaBarra();
        aggiornaLabel(r);
        aggiornaDetPref();
        aggiornaDettagli();
        aggiornaTastoScrivi();
        aggiornaBottoneVedi();
        aggiornaScriviGuest();
    }
    
    /**
     * Aggiorna l'interfaccia utente dopo modifiche alle recensioni.
     * <p>
     * Viene utilizzato per ricaricare le anteprime e aggiornare i pulsanti correlati.
     */
    public void aggiornaPostModificheRecensioni() {
        mostraRecensioniAnteprima();
        aggiornaTastoScrivi();
        aggiornaBottoneVedi();
    }
    
    /**
     * Aggiorna l'interfaccia in modo che l'impaginazione sia visualizzata correttamente.
     */
    public void graficaImpaginata() {
        resetPagina();
        impaginazione(paginaAttuale);
        aggiornaComponentiGenerali(pannelliFiltrati.get(0).getRistorante());   
    }
    
    /**
     * Imposta la visualizzazione per utenti ospiti.
     * <p>
     * Se l'utente corrente è ospite (ID 0), alcuni componenti sono nascosti. L'utente potrà solamente vedere i ristoranti ed usare i filtri
     */
    public void versioneGuest() {
        if (gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente() == 0) {
            detPref.setVisible(false);
            profiloUtente.setVisible(false);
            scriviRec.setVisible(false);
            logoutBottone.setVisible(true);
        } else {
            detPref.setVisible(true);
            logoutBottone.setVisible(false);
            profiloUtente.setVisible(true);
            scriviRec.setVisible(true);
        }
    }
    
    /**
     * Gestisce l'impaginazione dei pannelli dei ristoranti.
     * <p>
     * Visualizza solo gli elementi della pagina corrente e aggiorna il contatore.
     * 
     * @param pagina numero della pagina da visualizzare
     */
    private void impaginazione(int pagina){
        contenitorePanel.removeAll();
        int da = ELEMENTI_PER_PAGINA * pagina;
        int a = Math.min(pannelliFiltrati.size(), da + ELEMENTI_PER_PAGINA);
        for(int i = da; i < a; i++){
            contenitorePanel.add(pannelliFiltrati.get(i));
            contenitorePanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }
        contenitorePanel.revalidate();
        contenitorePanel.repaint();
        
        int totalePagine = (int) Math.ceil((double) pannelliFiltrati.size() / ELEMENTI_PER_PAGINA);
        contatore.setText((pagina + 1) + " / " + totalePagine);
    }
    
    /**
     * Aggiorna l'icona del preferito visualizzato.
     * <p>
     * Mostra la stella piena se il ristorante è tra i preferiti, altrimenti la stella vuota.
     */
     public void aggiornaDetPref() {
        if (gestore.getArchivioPreferiti().esistePref()) {
            detPref.setIcon(stellaPiena);
        } else {
            detPref.setIcon(stellaVuota);
        }
    }
     
    /**
     * Crea e visualizza il frame di login.
     * <p>
     * Permette all'utente di effettuare il login o entrare come ospite.
     * 
     * @see Login
     */ 
    public void creaLogin() {
        Login loginFrame = new Login(gestore, RisList.this);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }
    
    /**
     * Setta la barra di ricerca a frase predefinita
     */
    public void resetBarraRicerca(){
            campoRicerca.setText(messaggioBarra);
            campoRicerca.setForeground(Color.LIGHT_GRAY);
            campoRicerca.setFont(campoRicerca.getFont().deriveFont(Font.ITALIC));
    }
    
    /**
     * Crea un nuovo pannello ristorante.
     * 
     * @param r il ristorante da cui deve prendere i dati.
     */
    public void aggiungiPannello(Ristorante r) {
        tuttiIPannelli.add(new PannelloRistorante(RisList.this, gestore, r, contenitoreAnteprima));
    }
    
    
    
    //----METODI PRIVATI DI SUPPORTO----
    
    /**
     * Ripristina il numero della pagina attuale a zero.
     */
    private void resetPagina() {
        paginaAttuale = 0;
    }
    
    /**
     * Imposta il preferito attuale visualizzato.
     * 
     * @param r ristorante da segnare come preferito
     * @see Preferito
     */
    private void setPreferitoVisualizzato(Ristorante r) {
        gestore.getArchivioPreferiti().setPrefAttuale(r.getIdRis(), gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente());
    }
    
    /**
     * Imposta il ristorante attuale selezionato.
     * 
     * @param r ristorante da impostare come corrente
     * @see Ristorante
     */
    private void impostaRisAttuale(Ristorante r) {
        gestore.getArchivioRis().setRisAttuale(r);
    }
    
    /**
     * Resetta la barra di scorrimento verticale dei dettagli.
     */
    public void resettaBarra(){
        scrollPaneDet.getVerticalScrollBar().setValue(0);
    }
    
    /**
     * Resetta la barra di scorrimento verticale dei ristoranti.
     */
    public void resettaBarraRis(){
        scrollPane.getVerticalScrollBar().setValue(0);
    }
    
    /**
     * Mostra la scheda dei dettagli del ristorante.
     */
    private void aggiornaDettagli(){
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
    }
    
    /**
     * Aggiorna la visibilità del pulsante "Vedi tutte le recensioni".
     */
    private void aggiornaBottoneVedi() {
        int numero = gestore.getArchivioCommenti().contaCommenti(gestore.getArchivioRis().getRisAttuale());
        
        if (numero >= 3) {
            vediTutte.setVisible(true);
        } else {
            vediTutte.setVisible(false);
        }
    }
    
    /**
     * Aggiorna la visibilità del pulsante "Scrivi recensione".
     */
    private void aggiornaTastoScrivi() {
        int idUtente = gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente();
        int idRistorante = gestore.getArchivioRis().getRisAttuale().getIdRis();
        if (gestore.getArchivioCommenti().haGiaRecensione(idUtente, idRistorante)) {
            scriviRec.setVisible(false);
        } else {
            scriviRec.setVisible(true);
        }
    }
    
    /**
     * Aggiorna le etichette con i dettagli del ristorante.
     * 
     * @param r ristorante di riferimento
     */
    private void aggiornaLabel (Ristorante r) {
        detNome.setText(r.getNomeRis());
        detCuis.setText(r.getCuisRis());
        detInd.setText("Indirizzo: " + r.getIndRis());
        detPrezzo.setText("Fascia di prezzo: " + String.valueOf(r.getPriceRis()));
        detMedia.setText("Valutazione media: " + String.valueOf(r.getMediaStelleRis()) + "/5");
        detDes.setText("<html><p style='width:635px'>" + r.getDesRis() + "</p></html>");
        detBan.setIcon(selezionaImmagine(r.getStatoRis())); 
    }
    
    /**
     * Mostra le prime 3 recensioni nella sezione anteprima.
     */
    private void mostraRecensioniAnteprima() {
        mostraRecensioni(3, contenitoreAnteprima);
    }

    /**
     * Mostra tutte le recensioni del ristorante.
     */
    private void mostraTutteLeRecensioni() {
        mostraRecensioni(Integer.MAX_VALUE, contenitoreRec);
    }
    
    /**
     * Mostra un numero limitato di recensioni nel panel contenitore.
     * 
     * @param max numero massimo di recensioni da mostrare
     * @param contenitore pannello in cui aggiungere le recensioni
     * @see CommentiRistoranti
     * @see PannelloRecensioni
     * @see PannelloRisposta
     */
    private void mostraRecensioni( int max, JPanel contenitore) {
        contenitore.removeAll();
        Ristorante r = gestore.getArchivioRis().getRisAttuale();
        ArrayList<CommentiRistoranti> lista = gestore.getArchivioCommenti().getRecensioniPer(r.getIdRis(), max);
        
        for (CommentiRistoranti c : lista) {
            contenitore.add(new PannelloRecensioni(gestore, c));
            if (c.haRisposta()) {
                contenitore.add(new PannelloRisposta(gestore, c));
            }
            contenitore.add(Box.createVerticalStrut(5));
        }
        contenitore.revalidate();
        contenitore.repaint();
        dettaglioPanel.revalidate();
        dettaglioPanel.repaint();
    }
    
    /**
     * Rimuove il tasto Scrivi se l'id utente è uguale a 0 (guest).
     */
    private void aggiornaScriviGuest() {
        if (gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente() == 0) {
            scriviRec.setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pannelloSfondo = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        contenitorePanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        panRicerca = new javax.swing.JPanel();
        cerca = new javax.swing.JButton();
        campoRicerca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        filtri = new javax.swing.JButton();
        profiloUtente = new javax.swing.JButton();
        pannelloDestra = new javax.swing.JPanel();
        scrollPaneDet = new javax.swing.JScrollPane();
        dettaglioPanel = new javax.swing.JPanel();
        detBan = new javax.swing.JLabel();
        detNome = new javax.swing.JLabel();
        detCuis = new javax.swing.JLabel();
        detDes = new javax.swing.JLabel();
        detPref = new javax.swing.JButton();
        labelRecensioni = new javax.swing.JLabel();
        contenitoreAnteprima = new javax.swing.JPanel();
        scriviRec = new javax.swing.JButton();
        vediTutte = new javax.swing.JButton();
        detInd = new javax.swing.JLabel();
        detMedia = new javax.swing.JLabel();
        detPrezzo = new javax.swing.JLabel();
        recensioniPannello = new javax.swing.JPanel();
        indietroBottone = new javax.swing.JButton();
        scrollPaneRec = new javax.swing.JScrollPane();
        contenitoreRec = new javax.swing.JPanel();
        indietro = new javax.swing.JButton();
        avanti = new javax.swing.JButton();
        contatore = new javax.swing.JLabel();
        logoutBottone = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(770, 660));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        pannelloSfondo.setBackground(new java.awt.Color(0, 102, 102));
        pannelloSfondo.setForeground(new java.awt.Color(0, 102, 102));
        pannelloSfondo.setMinimumSize(new java.awt.Dimension(670, 560));
        pannelloSfondo.setPreferredSize(new java.awt.Dimension(1370, 760));
        pannelloSfondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pannelloSfondoMouseClicked(evt);
            }
        });
        pannelloSfondo.setLayout(new java.awt.GridBagLayout());

        scrollPane.setMaximumSize(null);
        scrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollPane.setPreferredSize(new java.awt.Dimension(450, 2));

        contenitorePanel.setBackground(new java.awt.Color(255, 255, 255));
        contenitorePanel.setMaximumSize(null);
        contenitorePanel.setOpaque(false);
        contenitorePanel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout contenitorePanelLayout = new javax.swing.GroupLayout(contenitorePanel);
        contenitorePanel.setLayout(contenitorePanelLayout);
        contenitorePanelLayout.setHorizontalGroup(
            contenitorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );
        contenitorePanelLayout.setVerticalGroup(
            contenitorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(contenitorePanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 4.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        pannelloSfondo.add(scrollPane, gridBagConstraints);

        logo.setText("logo");
        logo.setMinimumSize(new java.awt.Dimension(50, 50));
        logo.setPreferredSize(new java.awt.Dimension(50, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
        pannelloSfondo.add(logo, gridBagConstraints);

        panRicerca.setBackground(new java.awt.Color(240, 240, 240));
        panRicerca.setMaximumSize(new java.awt.Dimension(415, 40));
        panRicerca.setPreferredSize(new java.awt.Dimension(415, 40));
        panRicerca.setLayout(new java.awt.GridBagLayout());

        cerca.setBackground(new java.awt.Color(254, 254, 254));
        cerca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerca.setMaximumSize(new java.awt.Dimension(40, 40));
        cerca.setMinimumSize(new java.awt.Dimension(40, 40));
        cerca.setPreferredSize(new java.awt.Dimension(40, 40));
        cerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cercaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 1.0;
        panRicerca.add(cerca, gridBagConstraints);

        campoRicerca.setToolTipText("");
        campoRicerca.setMaximumSize(null);
        campoRicerca.setMinimumSize(new java.awt.Dimension(315, 40));
        campoRicerca.setPreferredSize(new java.awt.Dimension(375, 40));
        campoRicerca.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                campoRicercaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoRicercaFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 1.0;
        panRicerca.add(campoRicerca, gridBagConstraints);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        panRicerca.add(jScrollPane1, new java.awt.GridBagConstraints());

        filtri.setBackground(new java.awt.Color(254, 254, 254));
        filtri.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        filtri.setMaximumSize(new java.awt.Dimension(60, 40));
        filtri.setMinimumSize(new java.awt.Dimension(60, 40));
        filtri.setPreferredSize(new java.awt.Dimension(40, 40));
        filtri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtriActionPerformed(evt);
            }
        });
        panRicerca.add(filtri, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.6;
        gridBagConstraints.weighty = 0.4;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        pannelloSfondo.add(panRicerca, gridBagConstraints);

        profiloUtente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pagina Utente.png"))); // NOI18N
        profiloUtente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profiloUtente.setMaximumSize(new java.awt.Dimension(50, 51));
        profiloUtente.setMinimumSize(new java.awt.Dimension(50, 51));
        profiloUtente.setPreferredSize(new java.awt.Dimension(50, 50));
        profiloUtente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profiloUtenteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        pannelloSfondo.add(profiloUtente, gridBagConstraints);

        pannelloDestra.setLayout(new java.awt.CardLayout());

        scrollPaneDet.setMaximumSize(null);
        scrollPaneDet.setMinimumSize(null);
        scrollPaneDet.setViewportView(null);

        dettaglioPanel.setBackground(new java.awt.Color(254, 254, 254));
        dettaglioPanel.setLayout(new java.awt.GridBagLayout());

        detBan.setText("Bandiera");
        detBan.setMinimumSize(new java.awt.Dimension(60, 60));
        detBan.setPreferredSize(new java.awt.Dimension(60, 60));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        dettaglioPanel.add(detBan, gridBagConstraints);

        detNome.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        detNome.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 15.0;
        gridBagConstraints.weighty = 0.01;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        dettaglioPanel.add(detNome, gridBagConstraints);

        detCuis.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        detCuis.setText("Nome");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.03;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        dettaglioPanel.add(detCuis, gridBagConstraints);

        detDes.setBackground(new java.awt.Color(204, 204, 204));
        detDes.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        detDes.setText("Desc");
        detDes.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        dettaglioPanel.add(detDes, gridBagConstraints);

        detPref.setBorderPainted(false);
        detPref.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        detPref.setPreferredSize(new java.awt.Dimension(40, 40));
        detPref.setRequestFocusEnabled(false);
        detPref.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detPrefActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.02;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 20);
        dettaglioPanel.add(detPref, gridBagConstraints);

        labelRecensioni.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelRecensioni.setText("Recensioni:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.06;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        dettaglioPanel.add(labelRecensioni, gridBagConstraints);

        contenitoreAnteprima.setBackground(new java.awt.Color(255, 255, 255));
        contenitoreAnteprima.setLayout(new javax.swing.BoxLayout(contenitoreAnteprima, javax.swing.BoxLayout.Y_AXIS));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        dettaglioPanel.add(contenitoreAnteprima, gridBagConstraints);

        scriviRec.setBackground(new java.awt.Color(0, 102, 102));
        scriviRec.setForeground(new java.awt.Color(255, 255, 255));
        scriviRec.setText("Scrivi");
        scriviRec.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scriviRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scriviRecActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 2.0;
        dettaglioPanel.add(scriviRec, gridBagConstraints);

        vediTutte.setBackground(new java.awt.Color(0, 102, 102));
        vediTutte.setForeground(new java.awt.Color(255, 255, 255));
        vediTutte.setText("Vedi tutte");
        vediTutte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vediTutte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vediTutteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 0);
        dettaglioPanel.add(vediTutte, gridBagConstraints);

        detInd.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        detInd.setText("Indirizzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        dettaglioPanel.add(detInd, gridBagConstraints);

        detMedia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        detMedia.setText("Valutazione Media");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.01;
        gridBagConstraints.weighty = 0.02;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 15, 0);
        dettaglioPanel.add(detMedia, gridBagConstraints);

        detPrezzo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        detPrezzo.setText("Prezzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.02;
        dettaglioPanel.add(detPrezzo, gridBagConstraints);

        scrollPaneDet.setViewportView(dettaglioPanel);

        pannelloDestra.add(scrollPaneDet, "dettagli");

        recensioniPannello.setBackground(new java.awt.Color(255, 255, 255));
        recensioniPannello.setLayout(new java.awt.GridBagLayout());

        indietroBottone.setBackground(new java.awt.Color(0, 102, 102));
        indietroBottone.setForeground(new java.awt.Color(255, 255, 255));
        indietroBottone.setText("X");
        indietroBottone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroBottoneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        recensioniPannello.add(indietroBottone, gridBagConstraints);

        contenitoreRec.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenitoreRecLayout = new javax.swing.GroupLayout(contenitoreRec);
        contenitoreRec.setLayout(contenitoreRecLayout);
        contenitoreRecLayout.setHorizontalGroup(
            contenitoreRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1568, Short.MAX_VALUE)
        );
        contenitoreRecLayout.setVerticalGroup(
            contenitoreRecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1384, Short.MAX_VALUE)
        );

        scrollPaneRec.setViewportView(contenitoreRec);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 705;
        gridBagConstraints.ipady = 685;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        recensioniPannello.add(scrollPaneRec, gridBagConstraints);

        pannelloDestra.add(recensioniPannello, "recensioni");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 2.4;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        pannelloSfondo.add(pannelloDestra, gridBagConstraints);

        indietro.setBackground(new java.awt.Color(254, 254, 254));
        indietro.setText("Indietro");
        indietro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        indietro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indietroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        pannelloSfondo.add(indietro, gridBagConstraints);

        avanti.setBackground(new java.awt.Color(254, 254, 254));
        avanti.setText("Avanti");
        avanti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        avanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avantiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        pannelloSfondo.add(avanti, gridBagConstraints);

        contatore.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contatore.setForeground(new java.awt.Color(255, 255, 255));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        pannelloSfondo.add(contatore, gridBagConstraints);

        logoutBottone.setBackground(new java.awt.Color(254, 254, 254));
        logoutBottone.setText("Logout");
        logoutBottone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBottone.setFocusPainted(false);
        logoutBottone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBottoneActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        pannelloSfondo.add(logoutBottone, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pannelloSfondo, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Gestisce il click sul pulsante dei preferiti.
     * <p>
     * Verifica tramite {@link ArchivioPreferiti#esistePref()} se il ristorante corrente è già tra i preferiti. Se sì, lo rimuove, 
     * altrimenti lo aggiunge. Poi aggiorna l'icona del pulsante detPref{@link aggiornaDetPref()}.
     * 
     * @param evt evento generato dal click del pulsante
     * @see ArchivioPreferiti
     * @see #aggiornaDetPref()
     */
    private void detPrefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detPrefActionPerformed
        if (gestore.getArchivioPreferiti().esistePref()) {
            gestore.getArchivioPreferiti().rimuoviPreferito();
            aggiornaDetPref();
            gestore.getArchivioPreferiti().aggiornaPref();
        } else {
            gestore.getArchivioPreferiti().aggiungiPreferito();
            aggiornaDetPref();
            gestore.getArchivioPreferiti().aggiornaPref();
        }
    }//GEN-LAST:event_detPrefActionPerformed

    /**
     * Mostra la pagina dell'utente corrente.
     * <p>
     * Apre {@link PaginaUtente} e disabilita temporaneamente la finestra principale.
     * 
     * @param evt evento generato dal click del pulsante
     * @see PaginaUtente
     */
    private void profiloUtenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profiloUtenteActionPerformed
        PaginaUtente p = new PaginaUtente(gestore, this);
        p.setVisible(true);
        this.setEnabled(false);
        p.setLocationRelativeTo(null);
    }//GEN-LAST:event_profiloUtenteActionPerformed

    /**
     * Applica il filtro di ricerca in base al testo inserito nella barra.
     * <p>
     * Viene aggiornato l'elenco dei pannelli visualizzati e l'impaginazione.
     * 
     * @param evt evento generato dal click del pulsante
     * @see #filtraPannelli(String)
     */
    private void cercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cercaActionPerformed
        filtraPannelli(campoRicerca.getText().trim());
    }//GEN-LAST:event_cercaActionPerformed

    /**
     * Passa alla pagina successiva dei ristoranti.
     * <p>
     * Aggiorna l'impaginazione e il contatore delle pagine.
     * 
     * @param evt evento generato dal click del pulsante
     * @see #impaginazione(int)
     */
    private void avantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avantiActionPerformed
        scrollPane.getVerticalScrollBar().setValue(0);
        int totalePagine = (int) Math.ceil((double) pannelliFiltrati.size() / ELEMENTI_PER_PAGINA);
        
        if(paginaAttuale < totalePagine - 1){
            paginaAttuale++;
            impaginazione(paginaAttuale);
        }

        contatore.setText((paginaAttuale + 1) + " / " + totalePagine);
    }//GEN-LAST:event_avantiActionPerformed

    /**
     * Torna alla pagina precedente dei ristoranti.
     * <p>
     * Aggiorna l'impaginazione e il contatore delle pagine.
     * 
     * @param evt evento generato dal click del pulsante
     * @see #impaginazione(int)
     */
    private void indietroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroActionPerformed
        scrollPane.getVerticalScrollBar().setValue(0);
        int totalePagine = (int) Math.ceil((double) pannelliFiltrati.size() / ELEMENTI_PER_PAGINA);
        
        if(paginaAttuale > 0){
            paginaAttuale--;
            impaginazione(paginaAttuale);   
        }
        contatore.setText((paginaAttuale + 1) + " / " + totalePagine);
    }//GEN-LAST:event_indietroActionPerformed

    /**
     * Apre il frame per scrivere una nuova recensione.
     * <p>
     * La recensione sarà associata al ristorante attualmente selezionato.
     * 
     * @param evt evento generato dal click del pulsante
     * @see ScriviRecensione
     */
    private void scriviRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scriviRecActionPerformed
        ScriviRecensione pagRec = new ScriviRecensione(gestore.getArchivioRis().getRisAttuale(), gestore, RisList.this);
        pagRec.setLocationRelativeTo(scrollPaneDet);
        pagRec.pack();
        pagRec.setVisible(true);
        this.setEnabled(false);
    }//GEN-LAST:event_scriviRecActionPerformed

    /**
     * Mostra tutte le recensioni del ristorante selezionato.
     * <p>
     * Cambia il pannello visualizzato in "recensioni" e carica tutte le recensioni.
     * 
     * @param evt evento generato dal click del pulsante
     */
    private void vediTutteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vediTutteActionPerformed
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "recensioni");
        mostraTutteLeRecensioni();
    }//GEN-LAST:event_vediTutteActionPerformed

    /**
     * Torna alla visualizzazione dettagli del ristorante.
     * <p>
     * Ripristina la barra di scorrimento verticale.
     * 
     * @param evt evento generato dal click del pulsante
     */
    private void indietroBottoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indietroBottoneActionPerformed
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
        resettaBarra();
    }//GEN-LAST:event_indietroBottoneActionPerformed

    /**
     * Mostra il pannello dei filtri.
     * <p>
     * Imposta lo stato e la città dell'utente di default e disabilita la finestra principale.
     * 
     * @param evt evento generato dal click del pulsante
     * @see Filtro
     */
    private void filtriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtriActionPerformed
        if(f.getStato().getSelectedItem() == null){
            f.getStato().setSelectedItem(gestore.getArchivioUtenti().getUtenteAttuale().getStatoUtente());
            f.getCitta().setSelectedItem(gestore.getArchivioUtenti().getUtenteAttuale().getPosizioneUtente());
        }
        f.setVisible(true);
        this.setEnabled(false);
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_filtriActionPerformed

    /**
     * Effettua il logout dell'utente corrente.
     * <p>
     * Resetta l'utente attuale, chiude eventuali filtri aperti, mostra la finestra di login e chiude la finestra corrente.
     * 
     * @param evt evento generato dal click del pulsante
     * @see #creaLogin()
     * @see #chiudiFiltro()
     */
    private void logoutBottoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBottoneActionPerformed
        // TODO add your handling code here:                                    
        gestore.getArchivioUtenti().setUtenteAttuale(0);
        this.setEnabled(true);
        this.setVisible(false);
        this.chiudiFiltro();
        
        this.creaLogin();
        this.dispose();
    }//GEN-LAST:event_logoutBottoneActionPerformed

    /**
     * Rimuove messaggio predefinito per ricerca ristorante.
     * 
     * @param evt evento generato quando #campoRicerca ha il focus scrittura.
     */
    private void campoRicercaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRicercaFocusGained
        if (campoRicerca.getText().equals(messaggioBarra)) {
            campoRicerca.setText("");
            campoRicerca.setForeground(Color.BLACK);
            campoRicerca.setFont(campoRicerca.getFont().deriveFont(Font.PLAIN));
        }
    }//GEN-LAST:event_campoRicercaFocusGained

    /**
     * Imposta il messaggio predefinito per ricerca ristorante se #campoRicerca è vuoto.
     * 
     * @param evt evento generato quando #campoRicerca non ha il focus scrittura.
     */
    private void campoRicercaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoRicercaFocusLost
        if (campoRicerca.getText().isEmpty()) {
            campoRicerca.setText(messaggioBarra);
            campoRicerca.setForeground(Color.LIGHT_GRAY);
            campoRicerca.setFont(campoRicerca.getFont().deriveFont(Font.ITALIC));
        }
    }//GEN-LAST:event_campoRicercaFocusLost

    /** 
     * Prende il focus togliendolo al resto.
     * 
     * @param evt evento generato al click del mouse.
     */
    private void pannelloSfondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pannelloSfondoMouseClicked
        requestFocusInWindow();
    }//GEN-LAST:event_pannelloSfondoMouseClicked
   
    /**
     * Crea e ridimensiona tutte le immagini utilizzate nell'interfaccia.
     * <p>
     * Include bandiere, icone per preferiti, filtri, ricerca e logo.
     */
    private void creaImmagini(){
        ImageIcon flagIT = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_Italy.png");
        Image scaledImageItalia = flagIT.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconItalia = new ImageIcon(scaledImageItalia);
        this.flagItalia = scaledIconItalia; 
        
        ImageIcon flagCN = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_China.png");
        Image scaledImageCina = flagCN.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconCina = new ImageIcon(scaledImageCina);
        this.flagCina = scaledIconCina; 
        
        ImageIcon flagJP = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_Japan.png");
        Image scaledImageGiappone = flagJP.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGiappone = new ImageIcon(scaledImageGiappone);
        this.flagGiappone = scaledIconGiappone; 
        
        ImageIcon flagES = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_Spain.png");
        Image scaledImageSpagna = flagES.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconSpagna = new ImageIcon(scaledImageSpagna);
        this.flagSpagna = scaledIconSpagna; 
        
        ImageIcon flagDE = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_Germany.png");
        Image scaledImageGermania = flagDE.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconGermania = new ImageIcon(scaledImageGermania);
        this.flagGermania = scaledIconGermania; 
        
        ImageIcon flagUSA = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_United_States.png");
        Image scaledImageUSA = flagUSA.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconUSA = new ImageIcon(scaledImageUSA);
        this.flagStatiUniti = scaledIconUSA; 
        
        ImageIcon flagFR = new ImageIcon("resources" + File.separator + "images" + File.separator + "Flag_of_France.png");
        Image scaledImageFrancia = flagFR.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconFrancia = new ImageIcon(scaledImageFrancia);
        this.flagFrancia = scaledIconFrancia; 
        
        ImageIcon flagWD = new ImageIcon("resources" + File.separator + "images" + File.separator + "Globe.png");
        Image scaledImageMondo = flagWD.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIconMondo = new ImageIcon(scaledImageMondo);
        this.flagMondo = scaledIconMondo; 
        
        ImageIcon tkIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "images" + File.separator + "TheKnife.png"));
        Image tk1 = tkIcon.getImage();
        Image tk2 = tk1.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tk3 = new ImageIcon(tk2);
        logo.setIcon(tk3);
        
        ImageIcon paIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "images" + File.separator + "pref_Aggiungi.png"));
        Image pa1 = paIcon.getImage();
        Image pa2 = pa1.getScaledInstance(detPref.getWidth(), detPref.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pa3 = new ImageIcon(pa2);
        this.stellaVuota = pa3;
        
        ImageIcon ptIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "images" + File.separator + "pref_Togli.png"));
        Image pt1 = ptIcon.getImage();
        Image pt2 = pt1.getScaledInstance(detPref.getWidth(), detPref.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon pt3 = new ImageIcon(pt2);
        this.stellaPiena = pt3; 
        
        ImageIcon filtriIcon = new ImageIcon("resources" + File.separator + "images" + File.separator + "filtri.png");
        Image filtri1 = filtriIcon.getImage();
        Image filtri2 = filtri1.getScaledInstance(filtri.getWidth(), filtri.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon filtri3 = new ImageIcon(filtri2);
        filtri.setIcon(filtri3);
        
        ImageIcon cercaIcon = new ImageIcon("resources" + File.separator + "images" + File.separator + "Lente.png");
        Image ci1 = cercaIcon.getImage();
        Image ci2 = ci1.getScaledInstance(cerca.getWidth(), cerca.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ci3 = new ImageIcon(ci2);
        cerca.setIcon(ci3);
    }
     
    /**
     * Restituisce l'immagine della bandiera corrispondente alla nazione.
     * <p>
     * Se la nazione non è tra quelle gestite, restituisce l'icona "mondo".
     * 
     * @param nazione nome della nazione
     * @return {@link ImageIcon} corrispondente alla nazione
     */
    public ImageIcon selezionaImmagine(String nazione){
        if(nazione.equals("Italy"))
            return this.flagItalia;
        
        if(nazione.equals("France"))
            return this.flagFrancia;
        
        if(nazione.equals("Germany"))
            return this.flagGermania;
        
        if(nazione.equals("China"))
            return this.flagCina;
        
        if(nazione.equals("Japan"))
            return this.flagGiappone;
        
        if(nazione.equals("Spain"))
            return this.flagSpagna;
        
        if(nazione.equals("USA"))
            return this.flagStatiUniti;
        
        return this.flagMondo;
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avanti;
    private javax.swing.JTextField campoRicerca;
    private javax.swing.JButton cerca;
    private javax.swing.JLabel contatore;
    private javax.swing.JPanel contenitoreAnteprima;
    private javax.swing.JPanel contenitorePanel;
    private javax.swing.JPanel contenitoreRec;
    private javax.swing.JLabel detBan;
    private javax.swing.JLabel detCuis;
    private javax.swing.JLabel detDes;
    private javax.swing.JLabel detInd;
    private javax.swing.JLabel detMedia;
    private javax.swing.JLabel detNome;
    private javax.swing.JButton detPref;
    private javax.swing.JLabel detPrezzo;
    private javax.swing.JPanel dettaglioPanel;
    private javax.swing.JButton filtri;
    private javax.swing.JButton indietro;
    private javax.swing.JButton indietroBottone;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelRecensioni;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logoutBottone;
    private javax.swing.JPanel panRicerca;
    private javax.swing.JPanel pannelloDestra;
    private javax.swing.JPanel pannelloSfondo;
    private javax.swing.JButton profiloUtente;
    private javax.swing.JPanel recensioniPannello;
    private javax.swing.JButton scriviRec;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPaneDet;
    private javax.swing.JScrollPane scrollPaneRec;
    private javax.swing.JButton vediTutte;
    // End of variables declaration//GEN-END:variables
}




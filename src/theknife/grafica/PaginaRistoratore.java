/*
 * @author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como@author Alessandro Frigerio (matr. 759926), Antonio Pardo (matr. 760613), Davide Moretti (matr. 762176) Sede: Como
 */
package theknife.grafica;
import theknife.utili.ValidaReg;
import theknife.grafica.RisList;
import theknife.essenziali.Ristorante;
import theknife.essenziali.Utente;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 * La classe {@link PaginaRistoratore} rappresenta la finestra grafica principale destinata ai ristoratori.
 * <p>
 *  Permette di visualizzare e gestire i commenti dei clienti, applicare modifiche al profilo del ristorante e navigare tra le sezioni tramite interfaccia.
 *  La classe si appoggia al {@link GestoreArchivi} per il recupero e l’aggiornamento dei dati e a {@link RisList} per la gestione delle liste dei ristoranti. 
 *
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 *
 * @see GestoreArchivi
 * @see RisList
 * @see CommentiRistoranti
 */
public class PaginaRistoratore extends javax.swing.JFrame {
    //Dichiarazione variabili
    
    /** Riferimento al {@link GestoreArchivi}, utilizzato per accedere e modificare i dati persistenti del sistema. {@code gestore}*/
    private GestoreArchivi gestore;
    
    /**Riferimento alla lista dei ristoranti {@link RisList}. {@code risList}*/
    private RisList risList;
    
    /**Icona utilizzata per mostrare la password. {@code showPass}*/
    private ImageIcon showPass;
    
    /**Icona utilizzata per mostrare la password. {@code hidePass}*/
    private ImageIcon hidePass;
    
    /**Collezione di commenti {@link CommentiRistoranti} che devono ancora essere letti dal ristoratore. {@code listaDaLeggere}*/
    private ArrayList<CommentiRistoranti> listaDaLeggere = new ArrayList<>();
    
    /** Stringa che contiene il valore originale di un campo prima che venga modificato. {@code originale}*/
    private String originale;
    
    /**Contatore usato come identificatore numerico. {@code numero}*/
    private static int numero = 0;
    
    /**
     * Costruttore della classe {@code PaginaRistoratore}.
     * <p>
     * Inizializza i riferimenti a {@link GestoreArchivi} e {@link RisList}, imposta i componenti grafici e prepara la disposizione iniziale dei pannelli.
     *
     * @param gestore istanza di {@link GestoreArchivi} per la gestione dei dati.
     * @param risList istanza di {@link RisList} per la gestione dei ristoranti.
     */
    public PaginaRistoratore(GestoreArchivi gestore, RisList risList) { 
        this.gestore = gestore;
        this.risList = risList;
        //Inizializzazione vari componenti e Label.
        initComponents();  
        //aggiungiDaLeggere();
        
        generaImmagini();
        
        contenitoreRisposte.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        impostaModifiche();
        scrollPane.getVerticalScrollBar().setUnitIncrement(50);
        commentiRistorante.getVerticalScrollBar().setUnitIncrement(50);
        
        
        contenitoreCommenti.setLayout(new BoxLayout(contenitoreCommenti, BoxLayout.Y_AXIS));
        commentiRistorante.setViewportView(contenitoreCommenti);
        
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
        
        this.gestore = gestore;
        this.risList = risList;
        boolean delivery;
        
        
    }
    //Generated Code.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dettagliUtente = new javax.swing.JLabel();
        modificaDatiUtente = new javax.swing.JLabel();
        registraRistorante = new javax.swing.JLabel();
        areaRistoranti = new javax.swing.JLabel();
        areaCommenti = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        pannelloDestra = new javax.swing.JPanel();
        pannelloRisposte = new javax.swing.JScrollPane();
        contenitoreRisposte = new javax.swing.JPanel();
        commentiRistorante = new javax.swing.JScrollPane();
        contenitoreCommenti = new javax.swing.JPanel();
        dettagliRisto = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        cognome = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        eyePass = new javax.swing.JToggleButton();
        scrollPane = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        modificaDati = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        nome1 = new javax.swing.JTextField();
        cognome1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        email1 = new javax.swing.JTextField();
        password1 = new javax.swing.JPasswordField();
        jLabel34 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        eyePass1 = new javax.swing.JToggleButton();
        aggiorna = new javax.swing.JButton();
        registraRisto = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        città = new javax.swing.JTextField();
        regRis = new javax.swing.JButton();
        locRist = new javax.swing.JLabel();
        indRist = new javax.swing.JLabel();
        indirizzo = new javax.swing.JTextField();
        nomeRist = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        lonRist = new javax.swing.JLabel();
        latRist = new javax.swing.JLabel();
        descrizione = new javax.swing.JTextField();
        desRist = new javax.swing.JLabel();
        delcheck = new javax.swing.JCheckBox();
        prencheck = new javax.swing.JCheckBox();
        deliveryRist = new javax.swing.JLabel();
        prenOnl = new javax.swing.JLabel();
        cuisRist = new javax.swing.JLabel();
        cucina = new javax.swing.JTextField();
        prezzoBox = new javax.swing.JComboBox<>();
        priceRist = new javax.swing.JLabel();
        longitudine = new javax.swing.JTextField();
        latitudine = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        stato = new javax.swing.JComboBox<>();
        modificaRisto = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        modCittà = new javax.swing.JTextField();
        modRis = new javax.swing.JButton();
        modLocRist = new javax.swing.JLabel();
        modIndRist = new javax.swing.JLabel();
        modIndirizzo = new javax.swing.JTextField();
        modNomeRist = new javax.swing.JLabel();
        modNomeField = new javax.swing.JTextField();
        modLonRist = new javax.swing.JLabel();
        modLongitudine = new javax.swing.JTextField();
        modLatitudine = new javax.swing.JTextField();
        modLatRist = new javax.swing.JLabel();
        modDescrizione = new javax.swing.JTextField();
        modDesRist = new javax.swing.JLabel();
        modDelcheck = new javax.swing.JCheckBox();
        modPrencheck = new javax.swing.JCheckBox();
        modDeliveryRist = new javax.swing.JLabel();
        modPrenOnl = new javax.swing.JLabel();
        modCuisRist = new javax.swing.JLabel();
        modCucina = new javax.swing.JTextField();
        modPrezzoBox = new javax.swing.JComboBox<>();
        modPriceRist = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        modStato = new javax.swing.JComboBox<>();
        logout2 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel9.setText("Pagina ristoratore");

        jSeparator1.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator1.setMaximumSize(new java.awt.Dimension(50, 10));

        dettagliUtente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        dettagliUtente.setText("Dettagli ristoratore");
        dettagliUtente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dettagliUtente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dettagliUtenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dettagliUtenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dettagliUtenteMouseExited(evt);
            }
        });

        modificaDatiUtente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modificaDatiUtente.setText("Modifica dati");
        modificaDatiUtente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificaDatiUtente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificaDatiUtenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                modificaDatiUtenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                modificaDatiUtenteMouseExited(evt);
            }
        });

        registraRistorante.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registraRistorante.setText("Registra ristorante");
        registraRistorante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registraRistorante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registraRistoranteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registraRistoranteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registraRistoranteMouseExited(evt);
            }
        });

        areaRistoranti.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaRistoranti.setText("I tuoi ristoranti");
        areaRistoranti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        areaRistoranti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areaRistorantiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                areaRistorantiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                areaRistorantiMouseExited(evt);
            }
        });

        areaCommenti.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaCommenti.setText("Rispondi ai commenti");
        areaCommenti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        areaCommenti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                areaCommentiMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                areaCommentiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                areaCommentiMouseExited(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator2.setMaximumSize(new java.awt.Dimension(50, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 102, 102));
        jSeparator3.setMaximumSize(new java.awt.Dimension(50, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dettagliUtente)
                            .addComponent(modificaDatiUtente)
                            .addComponent(registraRistorante)
                            .addComponent(areaRistoranti)
                            .addComponent(areaCommenti))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dettagliUtente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificaDatiUtente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(areaRistoranti)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registraRistorante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaCommenti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        pannelloDestra.setLayout(new java.awt.CardLayout());

        contenitoreRisposte.setLayout(new javax.swing.BoxLayout(contenitoreRisposte, javax.swing.BoxLayout.Y_AXIS));
        pannelloRisposte.setViewportView(contenitoreRisposte);

        pannelloDestra.add(pannelloRisposte, "rispondiPanel");

        contenitoreCommenti.setBackground(new java.awt.Color(255, 255, 255));
        contenitoreCommenti.setLayout(new javax.swing.BoxLayout(contenitoreCommenti, javax.swing.BoxLayout.Y_AXIS));
        commentiRistorante.setViewportView(contenitoreCommenti);

        pannelloDestra.add(commentiRistorante, "commenti");

        dettagliRisto.setMaximumSize(new java.awt.Dimension(783, 620));
        dettagliRisto.setMinimumSize(new java.awt.Dimension(783, 620));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel21.setText("Dettagli ristoratore");

        nome.setBackground(new java.awt.Color(204, 204, 204));
        nome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nome.setMaximumSize(new java.awt.Dimension(64, 22));

        cognome.setBackground(new java.awt.Color(204, 204, 204));
        cognome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome.setMaximumSize(new java.awt.Dimension(64, 22));

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email.setMaximumSize(new java.awt.Dimension(64, 22));

        username.setBackground(new java.awt.Color(204, 204, 204));
        username.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        username.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Nome");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Cognome");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("E-mail");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setText("Password");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setText("Username");

        password.setBackground(new java.awt.Color(204, 204, 204));
        password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password.setMaximumSize(new java.awt.Dimension(64, 22));

        eyePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass.setMaximumSize(new java.awt.Dimension(30, 30));
        eyePass.setMinimumSize(new java.awt.Dimension(30, 30));
        eyePass.setPreferredSize(new java.awt.Dimension(30, 30));
        eyePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dettagliRistoLayout = new javax.swing.GroupLayout(dettagliRisto);
        dettagliRisto.setLayout(dettagliRistoLayout);
        dettagliRistoLayout.setHorizontalGroup(
            dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dettagliRistoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(dettagliRistoLayout.createSequentialGroup()
                        .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dettagliRistoLayout.createSequentialGroup()
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eyePass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cognome, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        dettagliRistoLayout.setVerticalGroup(
            dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dettagliRistoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eyePass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(dettagliRistoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(333, Short.MAX_VALUE))
        );

        pannelloDestra.add(dettagliRisto, "dettagli");

        scrollPane.setMaximumSize(null);
        scrollPane.setMinimumSize(new java.awt.Dimension(0, 0));
        scrollPane.setPreferredSize(new java.awt.Dimension(450, 2));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(null);
        jPanel4.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(jPanel4);

        pannelloDestra.add(scrollPane, "ristorantiMenu");

        modificaDati.setMaximumSize(new java.awt.Dimension(783, 620));
        modificaDati.setMinimumSize(new java.awt.Dimension(783, 620));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel28.setText("Modifica dati ristoratore");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setText("Nome");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setText("Cognome");

        nome1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nome1.setMaximumSize(new java.awt.Dimension(64, 22));

        cognome1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cognome1.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setText("E-mail");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setText("Password");

        email1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        email1.setMaximumSize(new java.awt.Dimension(64, 22));

        password1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        password1.setMaximumSize(new java.awt.Dimension(64, 22));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setText("Username");

        username1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        username1.setMaximumSize(new java.awt.Dimension(64, 22));

        eyePass1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eyePass1.setMaximumSize(new java.awt.Dimension(30, 30));
        eyePass1.setMinimumSize(new java.awt.Dimension(30, 30));
        eyePass1.setPreferredSize(new java.awt.Dimension(30, 30));
        eyePass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eyePass1ActionPerformed(evt);
            }
        });

        aggiorna.setBackground(new java.awt.Color(0, 102, 102));
        aggiorna.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        aggiorna.setForeground(new java.awt.Color(255, 255, 255));
        aggiorna.setText("Aggiorna");
        aggiorna.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aggiorna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aggiornaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout modificaDatiLayout = new javax.swing.GroupLayout(modificaDati);
        modificaDati.setLayout(modificaDatiLayout);
        modificaDatiLayout.setHorizontalGroup(
            modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificaDatiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(modificaDatiLayout.createSequentialGroup()
                        .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(email1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(modificaDatiLayout.createSequentialGroup()
                                .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eyePass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cognome1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(aggiorna)
                    .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        modificaDatiLayout.setVerticalGroup(
            modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modificaDatiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cognome1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eyePass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(modificaDatiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aggiorna)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        pannelloDestra.add(modificaDati, "modifica");

        registraRisto.setPreferredSize(new java.awt.Dimension(400, 500));
        registraRisto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel11.setText("REGISTRAZIONE RISTORANTE");
        registraRisto.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 550, 40));
        registraRisto.add(città, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 135, 30));

        regRis.setBackground(new java.awt.Color(0, 102, 102));
        regRis.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        regRis.setForeground(new java.awt.Color(255, 255, 255));
        regRis.setText("Registra");
        regRis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regRis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regRisActionPerformed(evt);
            }
        });
        registraRisto.add(regRis, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 100, 30));

        locRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        locRist.setText("Città:");
        registraRisto.add(locRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 79, -1));

        indRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        indRist.setText("Indirizzo:");
        registraRisto.add(indRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 82, -1));
        registraRisto.add(indirizzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 290, 30));

        nomeRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nomeRist.setText("Nome:");
        registraRisto.add(nomeRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 60, -1));
        registraRisto.add(nomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 290, 30));

        lonRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lonRist.setText("Longitudine:");
        registraRisto.add(lonRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 90, -1));

        latRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        latRist.setText("Latitudine:");
        registraRisto.add(latRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 350, 80, -1));
        registraRisto.add(descrizione, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 290, 30));

        desRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        desRist.setText("Descrizione:");
        registraRisto.add(desRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        delcheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registraRisto.add(delcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, -1));

        prencheck.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registraRisto.add(prencheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        deliveryRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deliveryRist.setText("Delivery:");
        registraRisto.add(deliveryRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        prenOnl.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        prenOnl.setText("Prenotazione:");
        registraRisto.add(prenOnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        cuisRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cuisRist.setText("Tipo Cucina:");
        registraRisto.add(cuisRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 110, -1));
        registraRisto.add(cucina, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 290, 30));

        prezzoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$", "$$", "$$$", "$$$$" }));
        prezzoBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registraRisto.add(prezzoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 70, 20));

        priceRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        priceRist.setText("Fascia prezzo:");
        registraRisto.add(priceRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, -1, -1));
        registraRisto.add(longitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 135, 30));
        registraRisto.add(latitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 370, 135, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Stato:");
        registraRisto.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 230, -1, -1));

        stato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        stato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam" }));
        stato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registraRisto.add(stato, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 250, 135, 28));

        pannelloDestra.add(registraRisto, "registra");

        modificaRisto.setPreferredSize(new java.awt.Dimension(400, 500));
        modificaRisto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(204, 204, 204));
        jLabel16.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel16.setText("MODIFICA RISTORANTE");
        modificaRisto.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 450, 40));
        modificaRisto.add(modCittà, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 135, 30));

        modRis.setBackground(new java.awt.Color(0, 102, 102));
        modRis.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modRis.setForeground(new java.awt.Color(255, 255, 255));
        modRis.setText("Modifica");
        modRis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modRis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modRisActionPerformed(evt);
            }
        });
        modificaRisto.add(modRis, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, 100, 30));

        modLocRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modLocRist.setText("Città:");
        modificaRisto.add(modLocRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 79, -1));

        modIndRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modIndRist.setText("Indirizzo:");
        modificaRisto.add(modIndRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 82, -1));
        modificaRisto.add(modIndirizzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 290, 30));

        modNomeRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modNomeRist.setText("Nome:");
        modificaRisto.add(modNomeRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 49, -1));
        modificaRisto.add(modNomeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 290, 30));

        modLonRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modLonRist.setText("Longitudine:");
        modificaRisto.add(modLonRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 90, -1));
        modificaRisto.add(modLongitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 135, 30));
        modificaRisto.add(modLatitudine, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 370, 135, 30));

        modLatRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modLatRist.setText("Latitudine:");
        modificaRisto.add(modLatRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 350, 80, -1));
        modificaRisto.add(modDescrizione, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, 290, 30));

        modDesRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modDesRist.setText("Descrizione:");
        modificaRisto.add(modDesRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));
        modificaRisto.add(modDelcheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, -1, -1));
        modificaRisto.add(modPrencheck, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        modDeliveryRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modDeliveryRist.setText("Delivery:");
        modificaRisto.add(modDeliveryRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 480, -1, -1));

        modPrenOnl.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modPrenOnl.setText("Prenotazione:");
        modificaRisto.add(modPrenOnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        modCuisRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modCuisRist.setText("Tipo Cucina:");
        modificaRisto.add(modCuisRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 90, -1));
        modificaRisto.add(modCucina, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 290, 30));

        modPrezzoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$", "$$", "$$$", "$$$$" }));
        modPrezzoBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificaRisto.add(modPrezzoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 70, 20));

        modPriceRist.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modPriceRist.setText("Fascia prezzo:");
        modificaRisto.add(modPriceRist, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Stato:");
        modificaRisto.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 230, -1, -1));

        modStato.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        modStato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abu Dhabi", "Andorra", "Argentina", "Austria", "Belgium", "Brazil", "Canada", "China Mainland", "Croatia", "Czech Republic", "Czechia", "Denmark", "Dubai", "Estonia", "Finland", "France", "Germany", "Greece", "Hong Kong", "Hong Kong SAR China", "Hungary", "Iceland", "Ireland", "Italy", "Japan", "Latvia", "Lithuania", "Luxembourg", "Macau", "Malaysia", "Malta", "Mexico", "Netherlands", "Norway", "Poland", "Portugal", "Qatar", "Serbia", "Singapore", "Slovenia", "South Korea", "Spain", "Sweden", "Switzerland", "Taiwan", "Thailand", "Türkiye", "USA", "United Kingdom", "Vietnam" }));
        modStato.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificaRisto.add(modStato, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 250, 135, 28));

        pannelloDestra.add(modificaRisto, "modificaRisto");

        logout2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        logout2.setText("Logout");
        logout2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pannelloDestra, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logout2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(logout2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pannelloDestra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
    * Mostra tutti i ristoranti dell'utente attuale nel pannello principale.
    * <p>
    *   Per ciascun ristorante crea un pannello con il nome e i pulsanti "Modifica" ed "Elimina". L'azione dei pulsanti aggiorna direttamente i campi grafici o rimuove il ristorante dall'archivio.
    *
    * @see GestoreArchivi
    * @see Ristorante
    */
    private void mostraRistoranti() {
        // Pannello che conterrà tutti i ristoranti
        JPanel contenitore = new JPanel();
        contenitore.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));
        contenitore.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Recupera l'utente attuale
        Utente attuale = gestore.getArchivioUtenti().getUtenteAttuale();

        // Cicla su tutti i ristoranti nell'archivio
        for (Ristorante r : gestore.getArchivioRis().getRis()) {
            // Mostra solo i ristoranti di questo utente
            if (r.getIdRistoratore() == attuale.getIdUtente()) {
                JPanel panelRisto = new JPanel(new BorderLayout());
                panelRisto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                panelRisto.setBackground(new Color(245, 245, 245)); 

                panelRisto.setPreferredSize(new Dimension(scrollPane.getViewport().getWidth() - 30, 80));
                panelRisto.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70)); // altezza fissa

                //nome del ristorante
                JLabel nomeLabel = new JLabel(r.getNomeRis());
                nomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
                nomeLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                panelRisto.add(nomeLabel, BorderLayout.CENTER);

                //pulsanti
                JPanel pulsantiPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
                pulsantiPanel.setOpaque(false);

                JButton btnModifica = new JButton("Modifica");
                btnModifica.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnModifica.addActionListener(e -> {
                    CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
                    cl.show(pannelloDestra, "modificaRisto");
                    gestore.getArchivioRis().setRisAttuale(r);
                    modNomeField.setText(r.getNomeRis());
                    modNomeField.setEditable(true);
                    modCucina.setText(r.getCuisRis());
                    modCucina.setEditable(true);
                    modCittà.setText(r.getLocRis());
                    modCittà.setEditable(true);
                    modStato.setSelectedItem(r.getStatoRis());
                    modStato.setEditable(true);
                    modIndirizzo.setText(r.getIndRis());
                    modIndirizzo.setEditable(true);
                    modLongitudine.setText(String.valueOf(r.getLongRis()));
                    modLongitudine.setEditable(true);
                    modLatitudine.setText(String.valueOf(r.getLatRis()));
                    modLatitudine.setEditable(true);
                    modDescrizione.setText(r.getDesRis());
                    modDescrizione.setEditable(true);
                    modDelcheck.setSelected(r.isDelivery());
                    modPrencheck.setSelected(r.isPrenotaOnline());
                    modPrezzoBox.setSelectedItem(r.getPriceRis());
                });

                JButton btnElimina = new JButton("Elimina");
                btnElimina.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnElimina.addActionListener(e -> {
                    int conferma = JOptionPane.showOptionDialog(this, "Vuoi davvero eliminare " + r.getNomeRis() + "?", "Conferma eliminazione", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Sì", "No"}, "No");
                    if (conferma == JOptionPane.YES_OPTION) {
                        gestore.getArchivioRis().rimuoviRis(r);
                        mostraRistoranti();
                    }
                });
                pulsantiPanel.add(btnModifica);
                pulsantiPanel.add(btnElimina);
                panelRisto.add(pulsantiPanel, BorderLayout.EAST);
                contenitore.add(panelRisto);
                contenitore.add(Box.createVerticalStrut(10));
            }
        }

        // Metti il contenitore nello scrollPane
        scrollPane.setViewportView(contenitore);
        scrollPane.revalidate();
        scrollPane.repaint();
    }
    
    /**
    * Mostra tutti i commenti dei ristoranti dell'utente attuale nel pannello dedicato alle risposte.
    * <p>
    *   Viene aggiunto un pannello {@link RecensioniRistorantiGestiti} per ciascun ristorante.
    *
    * @see CommentiRistoranti
    * @see RecensioniRistorantiGestiti
    */
    public void mostraCommenti() {
        contenitoreRisposte.removeAll();

        Utente attuale = gestore.getArchivioUtenti().getUtenteAttuale();

        for (Ristorante r : gestore.getArchivioRis().getRis()) {
            if (r.getIdRistoratore() == attuale.getIdUtente()) {
                contenitoreRisposte.add(new RecensioniRistorantiGestiti(gestore, r, contenitoreCommenti, pannelloDestra, PaginaRistoratore.this));
                contenitoreRisposte.add(Box.createVerticalStrut(10));
            }
        }

        contenitoreRisposte.revalidate();
        contenitoreRisposte.repaint();
    }
    
    /**
    * Registra un nuovo ristorante con i dati inseriti nei campi grafici.
    * <p>
    *   Verifica che latitudine e longitudine siano numeriche e che non esista già un ristorante alla stessa posizione.
    *
    * @param evt evento di azione generato dal pulsante.
    */
    private void regRisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regRisActionPerformed
        if(!longitudine.getText().matches("[0-9.]*") && !longitudine.getText().matches("[0-9.]*"))
            JOptionPane.showMessageDialog(null, "Puoi inserire solo numeri e il punto come separatore decimale!");
        else{
            boolean trovato = false;
            for(Ristorante r: gestore.getArchivioRis().getRis()){
                if(Double.parseDouble(latitudine.getText()) == r.getLatRis() && Double.parseDouble(longitudine.getText()) == r.getLongRis())
                    trovato = true;
            }
            if(trovato == true)
                JOptionPane.showMessageDialog(null, "Esiste già un ristorante alla posizione inserita!");
            else{
                Ristorante r = new Ristorante(nomeField.getText(), indirizzo.getText(), città.getText(), (String) stato.getSelectedItem(), (String)prezzoBox.getSelectedItem(), cucina.getText(), Double.parseDouble(longitudine.getText().trim()), Double.parseDouble(latitudine.getText().trim()), " ", 0, delcheck.isSelected(), prencheck.isSelected(), descrizione.getText(), gestore.getArchivioRis().creaID(), gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente());
                gestore.getArchivioRis().aggiungiRis(r);
                risList.aggiungiPannello(r);
                JOptionPane.showMessageDialog(this, "Ristorante creato con successo!");
                nomeField.setText("");
                indirizzo.setText("");
                città.setText("");
                prezzoBox.setSelectedItem("$");
                cucina.setText("");
                longitudine.setText("");
                latitudine.setText("");
                delcheck.setSelected(false);
                prencheck.setSelected(false);
                descrizione.setText("");
            }
        }
    }//GEN-LAST:event_regRisActionPerformed
    
    /** Imposta i campi grafici dei dati dell'utente, distinguendo tra campi modificabili e non modificabili.*/
    private void impostaModifiche() {
        //Dati dell'utente non modificabili
        Utente u = gestore.getArchivioUtenti().getUtenteAttuale();
        nome.setText(u.getNomeUtente());
        nome.setEditable(false);
        cognome.setText(u.getCognomeUtente());
        cognome.setEditable(false);
        email.setText(u.getEmailUtente());
        email.setEditable(false);
        username.setText(u.getUsernameUtente());
        username.setEditable(false);
        password.setText(u.getPassUtente());
        password.setEditable(false);
        
        //Dati dell'utente modificabili
        nome1.setText(u.getNomeUtente());
        nome1.setEditable(true);
        cognome1.setText(u.getCognomeUtente());
        cognome1.setEditable(true);
        email1.setText(u.getEmailUtente());
        email1.setEditable(true);
        username1.setText(u.getUsernameUtente());
        username1.setEditable(true);
        password1.setText(u.getPassUtente());
        password1.setEditable(true);
        
        
    }
    
    /**
    * Conta il numero di commenti per un ristorante e aggiunge quelli non letti alla lista {@link #listaDaLeggere}.
    *
    * @param r ristorante di riferimento
    */
    public void contaAggiungiDaLeggere(Ristorante r) {
        numero = 0;
        for (CommentiRistoranti c : gestore.getArchivioCommenti().getListaCommenti()) {
            if (r.getIdRis() == c.getIdRistorante()) {
                numero++;
                if (c.isDaLeggere()) {
                    listaDaLeggere.add(c);
                }
            }
        }
    }
    
    /**Segna come già letti tutti i commenti presenti in {@link #listaDaLeggere} e aggiorna l'archivio dei commenti.*/
    public void impostaGiaLette() {
       for (CommentiRistoranti c : listaDaLeggere) {
           c.setDaLeggere(false);
       }
       gestore.getArchivioCommenti().aggiornaCommenti();
       listaDaLeggere.clear();
    }
    
    /** Cambia la card del pannello principale per mostrare i commenti di un ristorante e genera dinamicamente i pannelli per le risposte.*/
    public void cambiaCard(){
        CardLayout cl = (CardLayout) pannelloDestra.getLayout();
        cl.show(pannelloDestra, "commenti");

        // Mostra commenti del ristorante
        ArrayList<CommentiRistoranti> lista = gestore.getArchivioCommenti().getRecensioniPer(gestore.getArchivioRis().getRisAttuale().getIdRis(), Integer.MAX_VALUE);
        contenitoreCommenti.removeAll();

        for (CommentiRistoranti c : lista) {
            contenitoreCommenti.add(new PannelloRecDaRispondere(gestore, c, PaginaRistoratore.this));
            if (c.haRisposta()) {
                contenitoreCommenti.add(new PannelloRispostaRistoratore(gestore, c, PaginaRistoratore.this));
            }
            contenitoreCommenti.add(Box.createVerticalStrut(10));
        }

        contenitoreCommenti.revalidate();
        contenitoreCommenti.repaint();
    }
    
    /**
    * Mostra o nasconde la password nel campo {@code password} basandosi sullo stato del checkbox {@code eyePass}.
    *
    * @param evt evento di azione generato dal checkbox
    */
    private void eyePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePassActionPerformed
        if (eyePass.isSelected()) {
            eyePass.setIcon(hidePass);
            password.setEchoChar((char)0);
        } else {
            eyePass.setIcon(showPass);
            password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePassActionPerformed
    
    /**
    * Effettua il logout dell'utente attuale e mostra la schermata di login.
    *
    * @param evt evento di azione generato dal pulsante
    */
    private void logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout2ActionPerformed
        gestore.getArchivioUtenti().setUtenteAttuale(0);
        risList.creaLogin();
        this.dispose();
    }//GEN-LAST:event_logout2ActionPerformed
    
    /**
    * Mostra o nasconde la password basandosi sullo stato del checkbox.
    *
    * @param evt evento di azione generato dal checkbox
    */
    private void eyePass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eyePass1ActionPerformed
        if (eyePass1.isSelected()) {
            eyePass1.setIcon(hidePass);
            password1.setEchoChar((char)0);
        } else {
            eyePass1.setIcon(showPass);
            password1.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_eyePass1ActionPerformed
    
    /**
    * Aggiorna i dati dell'utente con quelli inseriti nei campi grafici e aggiorna l'archivio degli utenti.
    *
    * @param evt evento di azione generato dal pulsante
    * @see ValidaReg
    */
    private void aggiornaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aggiornaActionPerformed
        if (!(ValidaReg.campiPieni(nome1.getText(), cognome1.getText(), username1.getText(), email1.getText(), password1.getText(), "guest", "guest"))) {
            JOptionPane.showMessageDialog(null, "Inserisci i campi obbligatori");
        } else if (!ValidaReg.mailValida(email1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Formato mail non valido");
        } else if (!ValidaReg.passValida(password1.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Formato password non valido");
        }else{
            Utente u = gestore.getArchivioUtenti().getUtenteAttuale();
            u.setNomeUtente(nome1.getText());
            u.setCognomeUtente(cognome1.getText());
            u.setEmailUtente(email1.getText());
            u.setPassUtente(password1.getText());
            u.setUsernameUtente(username1.getText());
            gestore.getArchivioUtenti().aggiornaUtenti();
            
            nome.setText(nome1.getText());
            cognome.setText(cognome1.getText());
            email.setText(email1.getText());
            password.setText(password1.getText());
            username.setText(username1.getText());
            

            JOptionPane.showMessageDialog(this, "Dati aggiornati con successo!");

            CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
            cl.show(pannelloDestra, "dettagli");
        }
    }//GEN-LAST:event_aggiornaActionPerformed
    
    /**
    * Mostra la card "dettagli" dell'utente.
    *
    * @param evt evento di click sul label
    */
    private void dettagliUtenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dettagliUtenteMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "dettagli");
    }//GEN-LAST:event_dettagliUtenteMouseClicked
    
    /**
    * Applica la formattazione "sottolineato" al testo del label dei dettagli quando il mouse entra sul label.
    *
    * @param evt evento generato dal passaggio del mouse sul label
    */
    private void dettagliUtenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dettagliUtenteMouseEntered
        originale = dettagliUtente.getText();
        dettagliUtente.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_dettagliUtenteMouseEntered
    
    /**
    * Ripristina il testo originale del label dei dettagli quando il mouse esce dal label.
    *
    * @param evt evento generato dal passaggio del mouse sul label.
    */
    private void dettagliUtenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dettagliUtenteMouseExited
        dettagliUtente.setText(originale);
    }//GEN-LAST:event_dettagliUtenteMouseExited
    
    /**
    * Mostra la card "modifica" dell'utente.
    *
    * @param evt evento di click sul label
    */
    private void modificaDatiUtenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificaDatiUtenteMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "modifica");
    }//GEN-LAST:event_modificaDatiUtenteMouseClicked
    
    /**
     * Sottolinea il label "modifica dati utente" al passaggio del mouse.
     *
     * @param evt evento generato dal passaggio del mouse sul label.
     */
    private void modificaDatiUtenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificaDatiUtenteMouseEntered
        originale = modificaDatiUtente.getText();
        modificaDatiUtente.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_modificaDatiUtenteMouseEntered
    
    /**
    * Ripristina il testo originale del label "modifica dati utente" quando il mouse esce.
    *
    * @param evt evento generato dal passaggio del mouse sul label.
    */
    private void modificaDatiUtenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificaDatiUtenteMouseExited
        modificaDatiUtente.setText(originale);
    }//GEN-LAST:event_modificaDatiUtenteMouseExited
    
    /**
     * Mostra la card "registra ristorante" al click sul label.
     *
     * @param evt evento di click sul label
     */
    private void registraRistoranteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registraRistoranteMouseClicked
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "registra");
    }//GEN-LAST:event_registraRistoranteMouseClicked
    
    /**
     * Sottolinea il label "registra ristorante" al passaggio del mouse.
     *
     * @param evt evento generato dal passaggio del mouse sul label.
     */
    private void registraRistoranteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registraRistoranteMouseEntered
        originale = registraRistorante.getText();
        registraRistorante.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_registraRistoranteMouseEntered

    /**
    * Ripristina il testo originale del label "registra ristorante".
    *
    * @param evt evento generato dal passaggio del mouse sul label.
    */
    private void registraRistoranteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registraRistoranteMouseExited
        registraRistorante.setText(originale);
    }//GEN-LAST:event_registraRistoranteMouseExited
    
    /**
    * Mostra la card "ristorantiMenu" e genera la lista dei ristoranti.
    *
    * @param evt evento di click sul label
    */
    private void areaRistorantiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaRistorantiMouseClicked
        mostraRistoranti();
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "ristorantiMenu");
    }//GEN-LAST:event_areaRistorantiMouseClicked
    
    /**
    * Sottolinea il label "ristoranti" al passaggio del mouse.
    *
    * @param evt evento generato dal passaggio del mouse sul label.
    */
    private void areaRistorantiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaRistorantiMouseEntered
        originale = areaRistoranti.getText();
        areaRistoranti.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_areaRistorantiMouseEntered

    /**
    * Ripristina il testo originale del label "ristoranti".
    *
    * @param evt evento generato dal passaggio del mouse sul label.
    */
    private void areaRistorantiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaRistorantiMouseExited
        areaRistoranti.setText(originale);
    }//GEN-LAST:event_areaRistorantiMouseExited

   /**
    * Aggiorna i dati del ristorante attual con i valori modificati nei campi grafici
    * 
    * @param evt evento di azione generato dal pulsante
    */
    private void modRisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modRisActionPerformed
        gestore.getArchivioRis().getRisAttuale().setNomeRis(modNomeField.getText().trim());
        gestore.getArchivioRis().getRisAttuale().setCuisRis(modCucina.getText().trim());
        gestore.getArchivioRis().getRisAttuale().setLocRis(modCittà.getText().trim());
        gestore.getArchivioRis().getRisAttuale().setStatoRis((String) modStato.getSelectedItem());
        gestore.getArchivioRis().getRisAttuale().setIndRis(modIndirizzo.getText().trim());
        gestore.getArchivioRis().getRisAttuale().setLongRis(Double.parseDouble(modLongitudine.getText().trim()));
        gestore.getArchivioRis().getRisAttuale().setLatRis(Double.parseDouble(modLatitudine.getText().trim())); 
        gestore.getArchivioRis().getRisAttuale().setDesRis(modDescrizione.getText().trim());
        gestore.getArchivioRis().getRisAttuale().setDelivery(modDelcheck.isSelected());
        gestore.getArchivioRis().getRisAttuale().setPrenotaOnline(modPrencheck.isSelected());
        gestore.getArchivioRis().getRisAttuale().setPriceRis((String)modPrezzoBox.getSelectedItem());
        gestore.getArchivioRis().aggiornaRis();
        
        JOptionPane.showMessageDialog(this, "Dati aggiornati con successo!");
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "ristorantiMenu");
        mostraRistoranti();
    }//GEN-LAST:event_modRisActionPerformed
    /**
     * Mostra la card "rispondiPanel" e genera i pannelli dei commenti da rispondere.
     * 
     * @param evt evento di click sul label
     */
    private void areaCommentiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaCommentiMouseClicked
        mostraCommenti();
        CardLayout cl = (CardLayout)(pannelloDestra.getLayout());
        cl.show(pannelloDestra, "rispondiPanel");
    }//GEN-LAST:event_areaCommentiMouseClicked
    
    /**
     * Sottolinea il label "commenti" al passaggio del mouse.
     * 
     * @param evt evento generato dal passaggio del mouse sul label. 
     */
    private void areaCommentiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaCommentiMouseEntered
        originale = areaCommenti.getText();
        areaCommenti.setText("<html><u>" + originale + "</u></html>");
    }//GEN-LAST:event_areaCommentiMouseEntered
    
    /**
     * Ripristina il testo originale del label "commenti".
     * 
     * @param evt evento generato dal passaggio del mouse sul label.
     */
    private void areaCommentiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_areaCommentiMouseExited
        areaCommenti.setText(originale);
    }//GEN-LAST:event_areaCommentiMouseExited
    
    /** Genera le immagini ridimensionate per i pulsanti di mostra/nascondi password e le assegna ai checkbox.*/
    public void generaImmagini() {
        //Immagine per mostrare la password ridimensionata ed applicata.
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "images" + File.separator + "show_pass.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        eyePass.setIcon(sp3);
        eyePass1.setIcon(sp3);
        this.showPass = sp3;  
        
         //Immagine per nascondere la password ridimensionata.
        ImageIcon hpIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources" + File.separator + "images" + File.separator + "hide_pass.png"));
        Image hp1 = hpIcon.getImage();
        Image hp2 = hp1.getScaledInstance(eyePass.getWidth(), eyePass.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hp3 = new ImageIcon(hp2); 
        this.hidePass = hp3;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aggiorna;
    private javax.swing.JLabel areaCommenti;
    private javax.swing.JLabel areaRistoranti;
    private javax.swing.JTextField città;
    private javax.swing.JTextField cognome;
    private javax.swing.JTextField cognome1;
    private javax.swing.JScrollPane commentiRistorante;
    private javax.swing.JPanel contenitoreCommenti;
    private javax.swing.JPanel contenitoreRisposte;
    private javax.swing.JTextField cucina;
    private javax.swing.JLabel cuisRist;
    private javax.swing.JCheckBox delcheck;
    private javax.swing.JLabel deliveryRist;
    private javax.swing.JLabel desRist;
    private javax.swing.JTextField descrizione;
    private javax.swing.JPanel dettagliRisto;
    private javax.swing.JLabel dettagliUtente;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email1;
    private javax.swing.JToggleButton eyePass;
    private javax.swing.JToggleButton eyePass1;
    private javax.swing.JLabel indRist;
    private javax.swing.JTextField indirizzo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel latRist;
    private javax.swing.JTextField latitudine;
    private javax.swing.JLabel locRist;
    private javax.swing.JButton logout2;
    private javax.swing.JLabel lonRist;
    private javax.swing.JTextField longitudine;
    private javax.swing.JTextField modCittà;
    private javax.swing.JTextField modCucina;
    private javax.swing.JLabel modCuisRist;
    private javax.swing.JCheckBox modDelcheck;
    private javax.swing.JLabel modDeliveryRist;
    private javax.swing.JLabel modDesRist;
    private javax.swing.JTextField modDescrizione;
    private javax.swing.JLabel modIndRist;
    private javax.swing.JTextField modIndirizzo;
    private javax.swing.JLabel modLatRist;
    private javax.swing.JTextField modLatitudine;
    private javax.swing.JLabel modLocRist;
    private javax.swing.JLabel modLonRist;
    private javax.swing.JTextField modLongitudine;
    private javax.swing.JTextField modNomeField;
    private javax.swing.JLabel modNomeRist;
    private javax.swing.JLabel modPrenOnl;
    private javax.swing.JCheckBox modPrencheck;
    private javax.swing.JComboBox<String> modPrezzoBox;
    private javax.swing.JLabel modPriceRist;
    private javax.swing.JButton modRis;
    private javax.swing.JComboBox<String> modStato;
    private javax.swing.JPanel modificaDati;
    private javax.swing.JLabel modificaDatiUtente;
    private javax.swing.JPanel modificaRisto;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField nome1;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeRist;
    private javax.swing.JPanel pannelloDestra;
    private javax.swing.JScrollPane pannelloRisposte;
    private javax.swing.JPasswordField password;
    private javax.swing.JPasswordField password1;
    private javax.swing.JLabel prenOnl;
    private javax.swing.JCheckBox prencheck;
    private javax.swing.JComboBox<String> prezzoBox;
    private javax.swing.JLabel priceRist;
    private javax.swing.JButton regRis;
    private javax.swing.JPanel registraRisto;
    private javax.swing.JLabel registraRistorante;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JComboBox<String> stato;
    private javax.swing.JTextField username;
    private javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables

}

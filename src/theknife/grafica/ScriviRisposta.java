/*
 * @author Alessandro Frigerio (num. matricola: 759926), Antonio Pardo (num. matricola: 760613), Davide Moretti (num. matricola: 762176), Sede: Como
 */
package theknife.grafica;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
import theknife.essenziali.CommentiRistoranti;
import theknife.gestori.GestoreArchivi;

/**
 * Finestra per scrivere una risposta a una recensione esistente.
 * Una volta confermata, la risposta viene salvata negli archivi e la GUI del ristoratore viene aggiornata.
 * 
 * @see GestoreArchivi
 * @see CommentiRistoranti
 * @see PaginaRistoratore
 * 
 * @author Alessandro Frigerio
 * @author Davide Moretti
 * @author Antonio Pardo
 */
public class ScriviRisposta extends javax.swing.JFrame {
    
    /** Gestore degli archivi dell’applicazione. {@code gestore} */
    private GestoreArchivi gestore;
    
    /** Icona stella vuota. {@code stellaVuota} */
    private ImageIcon stellaVuota;
            
     /** Icona stella piena. {@code stellaPiena} */
    private ImageIcon stellaPiena;
    
    /** Valutazione numerica della recensione (0–5). {@code valutazione} */
    private int valutazione = 0;
    
     /** Numero massimo di caratteri per la risposta. {@code MAX_CHAR} */
    private final int MAX_CHAR =  400;
    
    /** Recensione originale a cui si sta rispondendo. {@code commento} */
    private CommentiRistoranti commento;
    
    /** Pulsante associato alla scrittura della risposta. {@code bottoneScrivi} */
    private final JButton bottoneScrivi;
    
    /** Pagina del ristoratore corrente. {@code pagRisto} */
    private PaginaRistoratore pagRisto;
   
     /**
     * Costruttore della classe ScriviRisposta. Inizializza la finestra di risposta impostando la recensione originale e la pagina del ristoratore.
     *
     * @param gestore Gestore degli archivi dell’applicazione {@link GestoreArchivi}.
     * @param commento Recensione a cui rispondere.
     * @param bottoneScrivi Pulsante da nascondere dopo la risposta.
     * @param pagRisto Pagina del ristoratore da aggiornare.
     */
    public ScriviRisposta(GestoreArchivi gestore, CommentiRistoranti commento, JButton bottoneScrivi, PaginaRistoratore pagRisto) {
        this.gestore = gestore;
        this.bottoneScrivi = bottoneScrivi;
        this.commento = commento;
        this.pagRisto = pagRisto;
        setUndecorated(true);
        initComponents();
        creaImmagini();
        aggiornaStelle(commento.getValutazione());
        nomeRec.setText("Recensione scritta da: " +  gestore.getArchivioUtenti().getUtente(commento.getIdScrittore()).getUsernameUtente() + " #" + commento.getIdScrittore());
        titoloRec.setText(commento.getTitolo());
        testoRec.setText(commento.getTesto());
        areaTesto.setTransferHandler(null);
    }

     /**
     * Aggiorna graficamente le stelle mostrate in base alla valutazione della recensione originale.
     *
     * @param finoA numero di stelle da mostrare come piene
     */
    private void aggiornaStelle(int finoA) {
        JLabel[] stelle = {stella1, stella2, stella3, stella4, stella5};
        for (int i = 0; i < stelle.length; i++) {
            if (i < finoA) {
                stelle[i].setIcon(stellaPiena);
            } else {
                stelle[i].setIcon(stellaVuota);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scriviRecPannello = new javax.swing.JPanel();
        confermaButton = new javax.swing.JButton();
        areaTesto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        conteggio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeRec = new javax.swing.JLabel();
        stella1 = new javax.swing.JLabel();
        stella2 = new javax.swing.JLabel();
        stella3 = new javax.swing.JLabel();
        stella4 = new javax.swing.JLabel();
        stella5 = new javax.swing.JLabel();
        titoloRec = new javax.swing.JLabel();
        testoRec = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(558, 498));
        setResizable(false);

        scriviRecPannello.setBackground(new java.awt.Color(255, 255, 255));
        scriviRecPannello.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 5, true));

        confermaButton.setBackground(new java.awt.Color(0, 102, 102));
        confermaButton.setForeground(new java.awt.Color(255, 255, 255));
        confermaButton.setText("Conferma");
        confermaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confermaButtonActionPerformed(evt);
            }
        });

        areaTesto.setColumns(20);
        areaTesto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        areaTesto.setLineWrap(true);
        areaTesto.setRows(5);
        areaTesto.setWrapStyleWord(true);
        areaTesto.setAutoscrolls(false);
        areaTesto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 1, true));
        areaTesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areaTestoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                areaTestoKeyTyped(evt);
            }
        });

        jButton1.setText("X");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        conteggio.setText("0/400");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Rispondi:");

        nomeRec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nomeRec.setText("Recensione di:");
        nomeRec.setEnabled(false);

        stella1.setBackground(new java.awt.Color(255, 255, 255));
        stella1.setForeground(new java.awt.Color(255, 255, 255));
        stella1.setMinimumSize(new java.awt.Dimension(30, 30));
        stella1.setPreferredSize(new java.awt.Dimension(25, 25));

        stella2.setBackground(new java.awt.Color(255, 255, 255));
        stella2.setForeground(new java.awt.Color(255, 255, 255));
        stella2.setMinimumSize(new java.awt.Dimension(30, 30));
        stella2.setPreferredSize(new java.awt.Dimension(25, 25));

        stella3.setBackground(new java.awt.Color(255, 255, 255));
        stella3.setForeground(new java.awt.Color(255, 255, 255));
        stella3.setMinimumSize(new java.awt.Dimension(30, 30));
        stella3.setPreferredSize(new java.awt.Dimension(25, 25));

        stella4.setBackground(new java.awt.Color(255, 255, 255));
        stella4.setForeground(new java.awt.Color(255, 255, 255));
        stella4.setMinimumSize(new java.awt.Dimension(30, 30));
        stella4.setPreferredSize(new java.awt.Dimension(25, 25));

        stella5.setBackground(new java.awt.Color(255, 255, 255));
        stella5.setForeground(new java.awt.Color(255, 255, 255));
        stella5.setMinimumSize(new java.awt.Dimension(30, 30));
        stella5.setPreferredSize(new java.awt.Dimension(25, 25));

        titoloRec.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        titoloRec.setText("   ");
        titoloRec.setEnabled(false);

        testoRec.setEditable(false);
        testoRec.setColumns(20);
        testoRec.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        testoRec.setForeground(new java.awt.Color(255, 255, 255));
        testoRec.setLineWrap(true);
        testoRec.setRows(5);
        testoRec.setWrapStyleWord(true);
        testoRec.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        testoRec.setDragEnabled(true);
        testoRec.setEnabled(false);
        testoRec.setSelectionColor(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout scriviRecPannelloLayout = new javax.swing.GroupLayout(scriviRecPannello);
        scriviRecPannello.setLayout(scriviRecPannelloLayout);
        scriviRecPannelloLayout.setHorizontalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testoRec)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scriviRecPannelloLayout.createSequentialGroup()
                        .addComponent(nomeRec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1))
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                                .addComponent(stella1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(confermaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(conteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(titoloRec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        scriviRecPannelloLayout.setVerticalGroup(
            scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scriviRecPannelloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(nomeRec))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stella1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stella5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titoloRec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testoRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaTesto, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(scriviRecPannelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conteggio)
                    .addComponent(confermaButton))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scriviRecPannello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scriviRecPannello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * Conferma la risposta inserita dall’utente.
     * La salva negli archivi, imposta la recensione originale come "con risposta", nasconde il pulsante di scrittura e aggiorna la pagina del ristoratore.
     */
    private void confermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confermaButtonActionPerformed
        if (areaTesto.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Inserisci un testo valido");
        } else {
            gestore.getArchivioCommenti().aggiungiCommento(new CommentiRistoranti(gestore.getArchivioUtenti().getUtenteAttuale().getIdUtente(), areaTesto.getText().trim(), commento.getIdCommento()));
            gestore.getArchivioCommenti().impostaBooleanRisposta(commento);
            bottoneScrivi.setVisible(false);
            pagRisto.mostraCommenti();
            pagRisto.cambiaCard();
            this.dispose();
        }
    }//GEN-LAST:event_confermaButtonActionPerformed

    /**
     * Aggiorna il conteggio dei caratteri della risposta mentre l’utente digita. Blocca ulteriori caratteri se si raggiunge {@code MAX_CHAR}.
     */
    private void areaTestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTestoKeyTyped
       if (areaTesto.getText().length() >= MAX_CHAR) {
            evt.consume(); 
        }
        conteggio.setText((areaTesto.getText().length()) + "/400");
    }//GEN-LAST:event_areaTestoKeyTyped

     /**
     * Chiude la finestra senza salvare la risposta.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Evita l’invio di caratteri di nuova linea nel campo testo premendo Invio.
     */
    private void areaTestoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTestoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            evt.consume();
        }
    }//GEN-LAST:event_areaTestoKeyPressed

    /**
     * Carica e ridimensiona le icone per le stelle vuote e piene.
     * Applica le immagini alle rispettive etichette.
     */
    private void creaImmagini() {
        ImageIcon svIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\pref_Aggiungi.png"));
        Image sv1 = svIcon.getImage();
        Image sv2 = sv1.getScaledInstance(stella1.getWidth(), stella1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sv3 = new ImageIcon(sv2);
        this.stellaVuota = sv3;
        
        ImageIcon spIcon = new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources\\images\\pref_Togli.png"));
        Image sp1 = spIcon.getImage();
        Image sp2 = sp1.getScaledInstance(stella1.getWidth(), stella1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sp3 = new ImageIcon(sp2);
        this.stellaPiena = sp3;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTesto;
    private javax.swing.JButton confermaButton;
    private javax.swing.JLabel conteggio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nomeRec;
    private javax.swing.JPanel scriviRecPannello;
    private javax.swing.JLabel stella1;
    private javax.swing.JLabel stella2;
    private javax.swing.JLabel stella3;
    private javax.swing.JLabel stella4;
    private javax.swing.JLabel stella5;
    private javax.swing.JTextArea testoRec;
    private javax.swing.JLabel titoloRec;
    // End of variables declaration//GEN-END:variables
}
